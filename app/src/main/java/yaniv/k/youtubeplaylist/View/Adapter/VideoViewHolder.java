package yaniv.k.youtubeplaylist.View.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import yaniv.k.youtubeplaylist.Model.Item_;
import yaniv.k.youtubeplaylist.R;

public class VideoViewHolder extends ChildViewHolder {
    private ItemClicked activity;
    private ImageView mImageView;
    private TextView mTextView;
    VideoViewHolder(View itemView) {
        super(itemView);

        activity = (ItemClicked) itemView.getContext();
        mImageView = itemView.findViewById(R.id.image_view);
        mTextView = itemView.findViewById(R.id.text_view);

    }

    void bind(Item_ video) {
        Glide.with(mImageView.getContext()).
                load(video.getSnippet().getThumbnails().getMedium().getUrl())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .centerInside()
                .into(mImageView);
        mTextView.setText(video.getSnippet().getTitle());
        ((View) mTextView.getParent()).setOnClickListener(v -> {
            if (activity != null) {
                activity.onItemClick(video.getSnippet().getResourceId().getVideoId());
            }
        });
    }

    public interface ItemClicked {
        void onItemClick(String videoId);
    }
}
