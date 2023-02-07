package dad.classicgames.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dad.classicgames.api.model.Item;
import dad.classicgames.emulator.DOSBox;
import dad.classicgames.emulator.Emulator;
import net.lingala.zip4j.ZipFile;

public class DownloadGames {
	public static File ROOT_DIR = new File("."); // new File(System.getProperty("user.home"));
	public static File APP_DIR = new File(ROOT_DIR, ".ClassicGamesFX");
	public static File GAMES_DIR = new File(APP_DIR, "games");

	public static String obtenerNombreZip(String output) {
		String zipName = "";
		try {
			// convertimos la cadena a JSON a traves de la libreria GSON
			JsonObject json = new Gson().fromJson(output, JsonObject.class);
			JsonArray files = json.get("files").getAsJsonArray();
			for (JsonElement file : files) {
				JsonObject fileparser = file.getAsJsonObject();
				String formats = fileparser.get("format").getAsString();
				if (formats.equals("ZIP")) {
					zipName = fileparser.get("name").getAsString();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return zipName;
	}
	public static String ObtenerEmuExec(String output) {
		String emuStart = "";
		try {

			// convertimos la cadena a JSON a traves de la libreria GSON
			JsonObject json = new Gson().fromJson(output, JsonObject.class);
			JsonObject metadata = json.get("metadata").getAsJsonObject();
			emuStart = metadata.get("emulator_start").getAsString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emuStart;
	}

	public static String Peticion(Item titulo) {
		String output = "";
		try {
			URL url = new URL("https://archive.org/metadata/" + titulo.getIdentifier());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				// si la respuesta del servidor es distinta al codigo 200 lanzaremos una
				// Exception
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			// creamos un StringBuilder para almacenar la respuesta del web service
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = br.read()) != -1) {
				sb.append((char) cp);
			}
			// en la cadena output almacenamos toda la respuesta del servidor
			output = sb.toString();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;

	}

	public static File download(String urlString) throws Exception {
		URL url = new URL(urlString);
		String filename = url.getFile();
		File downloadedFile = new File(System.getProperty("java.io.tmpdir"), filename);
		FileUtils.copyURLToFile(url, downloadedFile);
		return downloadedFile;
	}

	public static void unzipAndExecute(File gameFile, String exec) throws InterruptedException, IOException {
		File gameDir = new File(GAMES_DIR, FilenameUtils.getBaseName(gameFile.getName()));
		if (!gameDir.exists()) {
			gameDir.mkdirs();
			System.out.println("gameDir: " + gameDir + exec + "ea");
			ZipFile zipFile = new ZipFile(gameFile);
			try {
				zipFile.extractAll(gameDir.getAbsolutePath());
				zipFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		File exeFile = new File(gameDir, exec);
		System.out.println("runningGame " + exeFile + "!");
		Emulator emulator = new DOSBox();
		emulator.run(exeFile).waitFor();
		System.out.println("Finish!");

	}
}
