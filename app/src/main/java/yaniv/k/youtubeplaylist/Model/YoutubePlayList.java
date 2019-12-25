package yaniv.k.youtubeplaylist.Model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class YoutubePlayList extends ExpandableGroup<Item_> {
    public YoutubePlayList(String title, List<Item_> items) {
        super(title, items);
    }
}
