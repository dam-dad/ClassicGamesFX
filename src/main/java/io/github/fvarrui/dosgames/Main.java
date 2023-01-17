package io.github.fvarrui.dosgames;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("DOS Games emulator!");
		
		File rootDir = new File("."); // new File(System.getProperty("user.home"));
		File appDir = new File(rootDir, ".ClassicGamesFX");
		File gamesDir = new File(appDir, "games");
		File exeFile = new File(gamesDir, "4-In-A-Row_DOS_EN/4INAROW.EXE");
//		File exeFile = new File(gamesDir, "Sid_Meiers_Civilization/CIV.EXE");
		
		DOSBox dosbox = new DOSBox();
		Process process = dosbox.run(exeFile);
		process.waitFor();
		
		System.out.println("Finish!");
		
	}

}
