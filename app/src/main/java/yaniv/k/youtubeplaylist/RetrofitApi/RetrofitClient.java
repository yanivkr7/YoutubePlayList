package yaniv.k.youtubeplaylist.RetrofitApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL ="https://landing.cal-online.co.il/";
    private static Retrofit instance;

    public static Retrofit getInstance(){
        if(instance == null)
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return instance;
    }

    public static ApiService getApiService(){
        return getInstance().create(ApiService.class);
    }

    public RetrofitClient() {
    }
}
