package yaniv.k.youtubeplaylist.Model;

import com.google.gson.annotations.SerializedName;

public class Thumbnails {

    @SerializedName("medium")
    private Medium medium;

    public Medium getMedium() {
        return medium;
    }
}
