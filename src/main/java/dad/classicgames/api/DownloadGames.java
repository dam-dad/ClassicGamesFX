package dad.classicgames.api;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import dad.classicgames.emulator.DOSBox;
import dad.classicgames.emulator.Emulator;
import net.lingala.zip4j.ZipFile;

public class DownloadGames {
	public static File ROOT_DIR = new File("."); // new File(System.getProperty("user.home"));
	public static File APP_DIR = new File(ROOT_DIR, ".ClassicGamesFX");
	public static File GAMES_DIR = new File(APP_DIR, "games");

	public static File download(String urlString) throws Exception {
		URL url = new URL(urlString);
		String filename = url.getFile();
		File downloadedFile = new File(System.getProperty("java.io.tmpdir"), filename);
		FileUtils.copyURLToFile(url, downloadedFile);
		return downloadedFile;
	}

	public static File unzip(File gameFile) {
		File gameDir = new File(GAMES_DIR, FilenameUtils.getBaseName(gameFile.getName()));
		if (!gameDir.exists()) {
			gameDir.mkdirs();
			ZipFile zipFile = new ZipFile(gameFile);
			try {
				zipFile.extractAll(gameDir.getAbsolutePath());
				zipFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return gameDir;
	}

	public static void execute(File gameDir, String emuexec) {

		File exeFile = new File(gameDir, emuexec);
		System.out.println("runningGame " + exeFile + "!");
		Emulator emulator = new DOSBox();
		try {
			emulator.run(exeFile).waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Executing!");
	}

}
