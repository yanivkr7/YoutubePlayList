package yaniv.k.youtubeplaylist.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import yaniv.k.youtubeplaylist.Model.Item_;
import yaniv.k.youtubeplaylist.Model.YoutubePlayList;
import yaniv.k.youtubeplaylist.R;

public class VideoAdapter extends ExpandableRecyclerViewAdapter<PlaylistViewHolder, VideoViewHolder> {

    public VideoAdapter(Context context, List<? extends ExpandableGroup> groups) {
        super(groups);

    }

    @Override
    public PlaylistViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_playlist, parent, false);
        return new PlaylistViewHolder(v);
    }

    @Override
    public VideoViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_video, parent, false);
        return new VideoViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(VideoViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Item_ video = (Item_) group.getItems().get(childIndex);

        holder.bind(video);
    }

    @Override
    public void onBindGroupViewHolder(PlaylistViewHolder holder, int flatPosition, ExpandableGroup group) {
        final YoutubePlayList playlist = (YoutubePlayList)group;
        holder.bind(playlist);

    }
}
