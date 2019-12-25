
package yaniv.k.youtubeplaylist.Model;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    private String id;
    @SerializedName("playlistItems")
    private PlaylistItems playlistItems;
    @SerializedName("snippet")
    private Snippet_ snippet;

    public String getId() {
        return id;
    }

    public PlaylistItems getPlaylistItems() {
        return playlistItems;
    }

    public Snippet_ getSnippet() {
        return snippet;
    }
}
