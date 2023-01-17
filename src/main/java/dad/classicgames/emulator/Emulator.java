package dad.classicgames.emulator;

import java.io.File;
import java.io.IOException;

public abstract class Emulator {

	private String name;
	private File executable;

	public Emulator(String name, File executable) {
		super();
		this.name = name;
		this.executable = executable;
	}
	
	public String getName() {
		return name;
	}
	
	public File getExecutable() {
		return executable;
	}

	public abstract Process run(File file) throws IOException;

}
