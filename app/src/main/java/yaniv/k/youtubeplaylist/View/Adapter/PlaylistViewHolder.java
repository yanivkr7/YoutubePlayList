package yaniv.k.youtubeplaylist.View.Adapter;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import yaniv.k.youtubeplaylist.Model.YoutubePlayList;
import yaniv.k.youtubeplaylist.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class PlaylistViewHolder extends GroupViewHolder {
    private TextView mTextView;
    private ImageView mArrowIv;

    PlaylistViewHolder(View itemView) {
        super(itemView);

        mTextView = itemView.findViewById(R.id.textView);
        mArrowIv = itemView.findViewById(R.id.arrowImage);
    }

    void bind(YoutubePlayList youtubePlayList){
        mTextView.setText(youtubePlayList.getTitle());
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        mArrowIv.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        mArrowIv.setAnimation(rotate);
    }
}
