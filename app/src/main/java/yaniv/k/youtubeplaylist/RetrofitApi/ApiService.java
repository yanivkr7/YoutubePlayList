package yaniv.k.youtubeplaylist.RetrofitApi;

import retrofit2.Call;
import retrofit2.http.GET;
import yaniv.k.youtubeplaylist.Model.Feed;

public interface ApiService {

    @GET("youtube/playlists.json")
    Call<Feed> getFeed();
}
