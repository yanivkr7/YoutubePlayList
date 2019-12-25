package yaniv.k.youtubeplaylist.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("items")
    private List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }
}
