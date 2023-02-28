package dad.classicgames.api;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import dad.classicgames.emulator.DOSBox;
import dad.classicgames.emulator.Emulator;
import javafx.stage.FileChooser;
import net.lingala.zip4j.ZipFile;

public class DownloadGames {
	public static File ROOT_DIR = new File("."); // new File(System.getProperty("user.home"));
	public static File APP_DIR = new File(ROOT_DIR, ".ClassicGamesFX");
	public static File GAMES_DIR = new File(APP_DIR, "games");

	public static File download(String urlString) throws Exception {
		File gameDir;
		URL url = new URL(urlString);
		String filename = url.getFile();
		System.out.println(filename);
		File downloadedFile = new File(System.getProperty("java.io.tmpdir"), filename);
		gameDir= new File(GAMES_DIR, FilenameUtils.getBaseName(downloadedFile.getName()));
		if (!gameDir.exists()) {
			FileUtils.copyURLToFile(url, downloadedFile);
		}
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

	public static void execute(File gamedir, String emuexec) {
		Emulator emulator = new DOSBox();
		if (emuexec.contains("*.exe") || emuexec.contains("*.bat")) {
			File exeFile = new File(gamedir, emuexec);
			System.out.println("runningGame " + exeFile + "!");
			try {
				emulator.run(exeFile).waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Executing!");
		} else {
			FileChooser chooser = new FileChooser();
			chooser.setTitle("Load source from file");
			chooser.setInitialDirectory(gamedir);
			File chosen = chooser.showOpenDialog(null);
			if (chosen != null) {
				System.out.println(chosen.getName());
				File exeFile = new File(gamedir, chosen.getName());
				System.out.println(exeFile);
				try {
					emulator.run(exeFile).waitFor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
