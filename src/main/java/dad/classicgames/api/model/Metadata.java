
package dad.classicgames.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("mediatype")
    @Expose
    private String mediatype;
    @SerializedName("collection")
    @Expose
    private List<String> collection;
    @SerializedName("creator")
    @Expose
    private String creator;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("emulator")
    @Expose
    private String emulator;
    @SerializedName("scanner")
    @Expose
    private String scanner;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("uploader")
    @Expose
    private String uploader;
    @SerializedName("publicdate")
    @Expose
    private String publicdate;
    @SerializedName("addeddate")
    @Expose
    private String addeddate;
    @SerializedName("curation")
    @Expose
    private String curation;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("emulator_ext")
    @Expose
    private String emulatorExt;
    @SerializedName("emulator_start")
    @Expose
    private String emulatorStart;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("rights")
    @Expose
    private String rights;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public List<String> getCollection() {
        return collection;
    }

    public void setCollection(List<String> collection) {
        this.collection = collection;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getEmulator() {
        return emulator;
    }

    public void setEmulator(String emulator) {
        this.emulator = emulator;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getPublicdate() {
        return publicdate;
    }

    public void setPublicdate(String publicdate) {
        this.publicdate = publicdate;
    }

    public String getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(String addeddate) {
        this.addeddate = addeddate;
    }

    public String getCuration() {
        return curation;
    }

    public void setCuration(String curation) {
        this.curation = curation;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmulatorExt() {
        return emulatorExt;
    }

    public void setEmulatorExt(String emulatorExt) {
        this.emulatorExt = emulatorExt;
    }

    public String getEmulatorStart() {
        return emulatorStart;
    }

    public void setEmulatorStart(String emulatorStart) {
        this.emulatorStart = emulatorStart;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

}
