
package dad.classicgames.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("reviewtitle")
    @Expose
    private String reviewtitle;
    @SerializedName("reviewbody")
    @Expose
    private String reviewbody;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("reviewer")
    @Expose
    private String reviewer;
    @SerializedName("reviewdate")
    @Expose
    private String reviewdate;
    @SerializedName("createdate")
    @Expose
    private String createdate;
    @SerializedName("reviewer_itemname")
    @Expose
    private String reviewerItemname;

    public String getReviewtitle() {
        return reviewtitle;
    }

    public void setReviewtitle(String reviewtitle) {
        this.reviewtitle = reviewtitle;
    }

    public String getReviewbody() {
        return reviewbody;
    }

    public void setReviewbody(String reviewbody) {
        this.reviewbody = reviewbody;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(String reviewdate) {
        this.reviewdate = reviewdate;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getReviewerItemname() {
        return reviewerItemname;
    }

    public void setReviewerItemname(String reviewerItemname) {
        this.reviewerItemname = reviewerItemname;
    }

}
