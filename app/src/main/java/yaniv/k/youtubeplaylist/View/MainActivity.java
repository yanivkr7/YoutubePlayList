package yaniv.k.youtubeplaylist.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.util.ArrayList;
import java.util.List;

import yaniv.k.youtubeplaylist.View.Adapter.VideoAdapter;
import yaniv.k.youtubeplaylist.View.Adapter.VideoViewHolder;
import yaniv.k.youtubeplaylist.Config.YoutubeConfig;
import yaniv.k.youtubeplaylist.Model.Item_;
import yaniv.k.youtubeplaylist.Model.YoutubePlayList;
import yaniv.k.youtubeplaylist.R;
import yaniv.k.youtubeplaylist.ViewModel.PlayListViewModel;

public class MainActivity extends AppCompatActivity implements VideoViewHolder.ItemClicked {

    private PlayListViewModel mViewModel;
    private ProgressBar mProgressBar;
    private TextView mErrorTextView;
    private RecyclerView mRecyclerView;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(PlayListViewModel.class);
        observeViewModel();

        mProgressBar = findViewById(R.id.progress_circular);
        mErrorTextView = findViewById(R.id.error_text_view);
        mRecyclerView = findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void observeViewModel() {

        getData();

        // Check if there is data
        mViewModel.playLists.observe(this, itemsList -> {
            if (itemsList != null && itemsList instanceof ArrayList) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                mErrorTextView.setVisibility(View.GONE);

            }
        });
        // Check if there is an error
        mViewModel.loadError.observe(this, isError -> {
            if (isError != null) {
                mErrorTextView.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });
        // Check if there is loading
        mViewModel.loading.observe(this, isLoading -> {
            if (isLoading != null) {
                if (isLoading) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mRecyclerView.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getData() {

        mViewModel.loadData();
        mViewModel.getItems().observe(this, playlists -> {
            ArrayList<YoutubePlayList> youtubePlayLists = new ArrayList<>();

            for(int i = 0; i < playlists.size(); i++){
                List<Item_> itemsList = playlists.get(i).getPlaylistItems().getItems();
                YoutubePlayList youtubePlayList = new YoutubePlayList(playlists.get(i).getSnippet().getTitle(), itemsList);
                youtubePlayLists.add(youtubePlayList);
            }
            videoAdapter = new VideoAdapter(MainActivity.this, youtubePlayLists);
            mRecyclerView.setAdapter(videoAdapter);
        });
    }

    @Override
    public void onItemClick(String videoId) {
        Intent intent = YouTubeStandalonePlayer.createVideoIntent( this, YoutubeConfig.getApiKey(), videoId,0,true,false);
        startActivity(intent);
    }
}




















