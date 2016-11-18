package aifree.com.citiestestapp.data.net_store;

import aifree.com.citiestestapp.data.models.CountryRequest;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;


public interface ApiController {

    @Headers( "Content-Type: application/json" )
    @GET(NetworkController.COUNTRIES)
    Observable<CountryRequest> getCities();
}
