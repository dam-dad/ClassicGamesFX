
package dad.classicgames.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemMetadata {

	@SerializedName("files")
	@Expose
	private List<Files> files;

	@SerializedName("metadata")
	@Expose
	private Metadata metadata;

	@SerializedName("reviews")
	@Expose
	private List<Review> reviews;

	public List<Files> getFiles() {
		return files;
	}

	public void setFiles(List<Files> files) {
		this.files = files;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
