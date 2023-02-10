
package dad.classicgames.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("source")
	@Expose
	private String source;
	@SerializedName("size")
	@Expose
	private String size;

	@SerializedName("format")
	@Expose
	private String format;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", source=" + source + ", size=" + size + ", format=" + format + "]\n";
	}

}
