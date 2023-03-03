
package dad.classicgames.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

	@SerializedName("identifier")
	@Expose
	private String identifier;
	@SerializedName("date")
	@Expose
	private String date;
	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("title")
	@Expose
	private String title;

	@SerializedName("emulator_start")
	@Expose
	private String emulatorStart;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmulatorStart() {
		return emulatorStart;
	}

	public void setEmulatorStart(String emulatorStart) {
		this.emulatorStart = emulatorStart;
	}


	@Override
	public String toString() {
		return "Metadata [identifier=" + identifier + ", date=" + date + ", description=" + description + ", title="
				+ title + ", emulatorStart=" + emulatorStart + "]";
	}

}
