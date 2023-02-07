package dad.classicgames.test;

import dad.classicgames.api.ArchiveOrg;
import dad.classicgames.api.model.File;
import dad.classicgames.api.model.ItemMetadata;

public class ArchiveOrgTest {

	public static void main(String[] args) throws Exception {

		ArchiveOrg archive = new ArchiveOrg();
	
//		System.out.println("buscando juegos ...");
//		archive.getGames().stream().forEach(System.out::println);;

		System.out.println("obteniendo metadatos ...");
		ItemMetadata meta = archive.getMetadata("doom-play");
		File zip = meta.getFiles().stream()
			.filter(f -> f.getFormat().equals("ZIP"))
			.findFirst()
			.get();
		System.out.println(zip.getName());		
		
	}

}
