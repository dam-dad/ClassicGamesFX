package dad.classicgames.test;

import java.util.ArrayList;
import java.util.List;

//import org.jsoup.Jsoup; import ParseHtmlToText

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.DownloadGames;
import dad.classicgames.api.model.File;

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

		ArchiveOrg archive = new ArchiveOrg();
		List<File> files = new ArrayList<File>();
		files.addAll(archive.getItemMetadata("doom-play").getFiles());
		System.out.println(files);
	for (File file : files) {
		if (file.getFormat().contains("ZIP")) {
			java.io.File gamefile = DownloadGames.download("https://archive.org/download/"+archive.getItemMetadata("doom-play").getMetadata().getIdentifier()+"/"+file.getName()); 
			java.io.File gamedir= DownloadGames.unzip(gamefile);
			DownloadGames.execute(gamedir, archive.getItemMetadata("doom-play").getMetadata().getEmulatorStart());
		}
	}
	}

}
