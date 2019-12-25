package yaniv.k.youtubeplaylist.Model;

import com.google.gson.annotations.SerializedName;

public class ResourceId {

    @SerializedName("videoId")
    private String videoId;

    public String getVideoId() {
        return videoId;
    }
}
