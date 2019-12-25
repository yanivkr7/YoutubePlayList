
package yaniv.k.youtubeplaylist.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PlaylistItems {

    @SerializedName("items")
    private List<Item_> items = null;

    public List<Item_> getItems() {
        return items;
    }
}
