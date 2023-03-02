package dad.classicgames.test;

import java.util.ArrayList;
//import org.jsoup.Jsoup; import ParseHtmlToText
import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.model.Item;
import dad.classicgames.api.model.Result;
import retrofit2.Response;

public class ArchiveOrgTest {

	public static void main(String[] args) throws Exception {
//		ArchiveOrg archive = new ArchiveOrg();
////		System.out.println("buscando juegos ...");
////		archive.getGames().stream().forEach(System.out::println);;
//		ArrayList<Item> listajuegos = new ArrayList<Item>();
//		listajuegos.addAll(archive.getGames());
//		System.out.println("obteniendo metadatos ...");
//		for (Item item : listajuegos) {
//			ItemMetadata meta = archive.getMetadata(item.getIdentifier());
//			System.out.println();
//			System.out.println(item.getIdentifier());
////			String htmlText = meta.getMetadata().getDescription(); 
////			System.out.println(Jsoup.parse(htmlText).text()); ParseHtmlToText
//			System.out.println(meta.getFiles());
//			System.out.println();
//			System.out.println();
//
//		}

		ArchiveOrg archive = ArchiveOrg.getInstance();
		String search = "doom";
		ArrayList<Item> listajuegos = new ArrayList<Item>();
		Result result = archive.searchGames(null, null, search);
		listajuegos.addAll(result.getItems());
		for (Item item : listajuegos) {
			System.out.println(item);
		}
//		
//		ArrayList<Item> listajuegos = new ArrayList<Item>();
//		Response<Result> response = archive.getGames("100", null);
//		listajuegos.addAll(response.body().getItems());
//		for (Item item : listajuegos) {
//			System.out.println(item);
//		}
//		
//	}

	}
}
