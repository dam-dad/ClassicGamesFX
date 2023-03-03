package dad.classicgames.emulator;

import java.io.File;
import java.io.IOException;

public class DOSBox extends Emulator {

	public DOSBox() {
		super("DOSBox", new File("DOSBox/DOSBox.exe"));
	}

	@Override
	public Process run(File exeFile) throws IOException {
		ProcessBuilder builder = new ProcessBuilder().command(getExecutable().getAbsolutePath(),
				exeFile.getAbsolutePath(), "-noconsole", "-exit", "-fullscreen");
		return builder.start();

	}

}
