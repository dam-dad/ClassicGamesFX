package dad.classicgames;

public class Titulos {
	private String identifier;
	private String title;
	public Titulos(String tit,String id) {
		this.title=tit;
		this.identifier=id;
	}
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
	return "el juego "+title+" con identificador "+identifier+"\n";
	}
}
