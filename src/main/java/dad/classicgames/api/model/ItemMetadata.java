
package dad.classicgames.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemMetadata {

    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("d1")
    @Expose
    private String d1;
    @SerializedName("d2")
    @Expose
    private String d2;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("files")
    @Expose
    private List<File> files;
    @SerializedName("files_count")
    @Expose
    private Integer filesCount;
    @SerializedName("item_last_updated")
    @Expose
    private Integer itemLastUpdated;
    @SerializedName("item_size")
    @Expose
    private Integer itemSize;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("uniq")
    @Expose
    private Integer uniq;
    @SerializedName("workable_servers")
    @Expose
    private List<String> workableServers;

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Integer getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(Integer filesCount) {
        this.filesCount = filesCount;
    }

    public Integer getItemLastUpdated() {
        return itemLastUpdated;
    }

    public void setItemLastUpdated(Integer itemLastUpdated) {
        this.itemLastUpdated = itemLastUpdated;
    }

    public Integer getItemSize() {
        return itemSize;
    }

    public void setItemSize(Integer itemSize) {
        this.itemSize = itemSize;
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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getUniq() {
        return uniq;
    }

    public void setUniq(Integer uniq) {
        this.uniq = uniq;
    }

    public List<String> getWorkableServers() {
        return workableServers;
    }

    public void setWorkableServers(List<String> workableServers) {
        this.workableServers = workableServers;
    }

}
