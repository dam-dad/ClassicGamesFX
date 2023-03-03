package dad.classicgames.api;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import dad.classicgames.emulator.DOSBox;
import dad.classicgames.emulator.Emulator;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import net.lingala.zip4j.ZipFile;

public class DownloadGames {
	public static File ROOT_DIR = new File("."); // new File(System.getProperty("user.home"));
	public static File APP_DIR = new File(ROOT_DIR, ".ClassicGamesFX");
	public static File GAMES_DIR = new File(APP_DIR, "games");
	private File gameDir, downloadedFile;
	private String filename;
	private URL url;
	private boolean isdownloaded;

	public boolean gameDirExist() {
		return gameDir.exists();
	}

	public void setGameVars(String urlString) throws MalformedURLException {
		url = new URL(urlString);
		filename = url.getFile();
		downloadedFile = new File(System.getProperty("java.io.tmpdir"), filename);
		gameDir = new File(GAMES_DIR, FilenameUtils.getBaseName(downloadedFile.getName()));
	}

	public void download() throws Exception {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws IOException {
				if (!isdownloaded) {
					FileUtils.copyURLToFile(url, downloadedFile);
					isdownloaded = true;
				}
				return null;
			}
		};
		new Thread(task).start();

	}

	public void unzip() {

		gameDir.mkdirs();
		ZipFile zipFile = new ZipFile(downloadedFile);
		try {
			zipFile.extractAll(gameDir.getAbsolutePath());
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void execute(String emuexec) {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws IOException {
				if (!isdownloaded) {
					Emulator emulator = new DOSBox();
					if (emuexec.endsWith(".exe") || emuexec.endsWith(".bat") || emuexec.endsWith(".EXE")
							|| emuexec.endsWith(".BAT")) {
						File exeFile = new File(gameDir, emuexec);
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
						System.out.println(gameDir + ", " + emuexec);
						FileChooser chooser = new FileChooser();
						chooser.setTitle("Load source from file");
						chooser.setInitialDirectory(gameDir);
						File chosen = chooser.showOpenDialog(null);
						if (chosen != null) {
							System.out.println(chosen.getName());
							File exeFile = new File(gameDir, chosen.getName());

							try {
								emulator.run(exeFile).waitFor();
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					isdownloaded = true;
				}
				return null;
			}
		};
		new Thread(task).start();
	}

	public File getGameDir() {
		return gameDir;
	}

	public File getDownloadedFile() {
		return downloadedFile;
	}
}
