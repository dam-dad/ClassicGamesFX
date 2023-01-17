package dad.classicgames;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import dad.classicgames.emulator.DOSBox;
import dad.classicgames.emulator.Emulator;
import net.lingala.zip4j.ZipFile;

public class Main {
	
	public static File ROOT_DIR = new File("."); // new File(System.getProperty("user.home"));
	public static File APP_DIR = new File(ROOT_DIR, ".ClassicGamesFX");	
	public static File GAMES_DIR = new File(APP_DIR, "games");
	
	public static void main(String[] args) throws Exception {

		System.out.println("MS-DOS Classic Games emulator!");
		
		if (!GAMES_DIR.exists()) {
			GAMES_DIR.mkdirs();
		}
		
		// download game zip file
		File gameFile = download("https://ia904502.us.archive.org/31/items/doom-play/DOOM.zip"); 
		System.out.println("gameFile: " + gameFile);
		
		// unzip game file in GAMES_DIR
		File gameDir = new File(GAMES_DIR, FilenameUtils.getBaseName(gameFile.getName()));
		if (!gameDir.exists()) {
			gameDir.mkdirs();
		}
		System.out.println("gameDir: " + gameDir);
		ZipFile zipFile = new ZipFile(gameFile);
		zipFile.extractAll(gameDir.getAbsolutePath());
		zipFile.close();
		
		// runs the game
		File exeFile = new File(gameDir, "GAME/FDOOM.EXE");
		System.out.println("runningGame " + exeFile + "!");
		Emulator emulator = new DOSBox();
		emulator.run(exeFile).waitFor();
		
		System.out.println("Finish!");
		
	}
	
	public static File download(String urlString) throws Exception {
		URL url = new URL(urlString);
		String filename = url.getFile();
		File downloadedFile = new File(System.getProperty("java.io.tmpdir"), filename);
		FileUtils.copyURLToFile(url, downloadedFile);
		return downloadedFile;
	}

}
