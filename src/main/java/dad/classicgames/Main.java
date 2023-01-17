package dad.classicgames;

import java.io.File;
import java.io.IOException;

import dad.classicgames.emulator.DOSBox;
import dad.classicgames.emulator.Emulator;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("DOS Games emulator!");
		
		File rootDir = new File("."); // new File(System.getProperty("user.home"));
		File appDir = new File(rootDir, ".ClassicGamesFX");
		File gamesDir = new File(appDir, "games");
		File exeFile = new File(gamesDir, "4-In-A-Row_DOS_EN/4INAROW.EXE");
		
		Emulator emulator = new DOSBox();
		emulator.run(exeFile).waitFor();
		
		System.out.println("Finish!");
		
	}

}
