package dad.classicgames.api.model;

public class Item {

	private String identifier;
	private String title;
	private String logo;

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Item [identifier=" + identifier + ", title=" + title + ", logo=" + logo + "]";
	}

}
