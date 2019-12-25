package yaniv.k.youtubeplaylist.Model;

import com.google.gson.annotations.SerializedName;

public class Snippet {

    @SerializedName("title")
    private String title;
    @SerializedName("thumbnails")
    private Thumbnails thumbnails;
    @SerializedName("resourceId")
    private ResourceId resourceId;

    public String getTitle() {
        return title;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public ResourceId getResourceId() {
        return resourceId;
    }
}
