package dad.classicgames.api.model;

public class Item {
	
	private String identifier;
	private String title;

	public Item(String title, String identifier) {
		this.title = title;
		this.identifier = identifier;
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
		return "Game " + title + " with ID " + identifier;
	}
	
}
