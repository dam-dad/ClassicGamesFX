package dad.classicgames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ListaJuegos {
	public static ArrayList<Titulos> ObtenerListaJuegos() {
		ArrayList<Titulos> titulos = new ArrayList<Titulos>();
		try {
			// creamos una URL donde esta nuestro webservice
			URL url = new URL(
					"https://archive.org/services/search/v1/scrape?fields=title,collection&q=softwarelibrary_msdos_games");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// indicamos por que verbo HTML ejecutaremos la solicitud
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
			String output = sb.toString();
			// convertimos la cadena a JSON a traves de la libreria GSON
			JsonObject json = new Gson().fromJson(output, JsonObject.class);
			JsonArray items = json.get("items").getAsJsonArray();
			for (JsonElement item : items) {
				JsonObject itemparser = item.getAsJsonObject();
				if (!itemparser.get("identifier").getAsString().equals("Doom-2")) {
					String title = itemparser.get("title").getAsString();
					String identifier = itemparser.get("identifier").getAsString();
					Titulos titulo = new Titulos(title, identifier);
					titulos.add(titulo);
				}
			}
			conn.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return titulos;
	}

}
