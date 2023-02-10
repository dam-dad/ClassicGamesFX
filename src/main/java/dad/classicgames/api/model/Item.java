package dad.classicgames.api.model;

public class Item {

	private String identifier;
	private String title;
	private Boolean Installed;

	public Item(String title, String identifier) {
		this.title = title;
		this.identifier = identifier;
		this.Installed=false;
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

	public Boolean getInstalled() {
		return Installed;
	}

	public void setInstalled(Boolean installed) {
		Installed = installed;
	}

	@Override
	public String toString() {
		return "Game " + title + " with ID " + identifier;
	}

}
