
package yaniv.k.youtubeplaylist.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentDetails {

    @SerializedName("videoId")
    private String videoId;
    @SerializedName("videoPublishedAt")
    private String videoPublishedAt;

    public String getVideoId() {
        return videoId;
    }

    public String getVideoPublishedAt() {
        return videoPublishedAt;
    }

}
