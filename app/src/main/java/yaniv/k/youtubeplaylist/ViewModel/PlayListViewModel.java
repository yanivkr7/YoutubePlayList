package yaniv.k.youtubeplaylist.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yaniv.k.youtubeplaylist.Model.Feed;
import yaniv.k.youtubeplaylist.Model.Item;
import yaniv.k.youtubeplaylist.RetrofitApi.ApiService;
import yaniv.k.youtubeplaylist.RetrofitApi.RetrofitClient;

public class PlayListViewModel extends ViewModel {
    public MutableLiveData<List<Item>> playLists;
    public MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<List<Item>> getItems() {
        loading.setValue(true);
        if (playLists == null) {
            playLists = new MutableLiveData<>();
            loadData();
        }

        return playLists;
    }

    public void loadData() {
        ApiService mApiService = RetrofitClient.getApiService();

        Call<Feed> call = mApiService.getFeed();
        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if(response.isSuccessful()){
                    loadError.setValue(false);
                    playLists.setValue(response.body().getItems());
                    loading.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                loadError.setValue(true);
            }
        });
    }
}
