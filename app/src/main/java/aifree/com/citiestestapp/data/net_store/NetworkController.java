package aifree.com.citiestestapp.data.net_store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import aifree.com.citiestestapp.data.models.CountryRequest;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public class NetworkController {

    public static final String API_EXTENSIONS = "api/";
    public static final String COUNTRIES = API_EXTENSIONS+"countries";

    private final String BASE_URL = "https://atw-backend.azurewebsites.net/";

    private ApiController mApiController;

    public NetworkController() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        mApiController = retrofit.create(ApiController.class);
    }

    public Observable<CountryRequest> getCities() {
        return mApiController.getCities();
    }
}
