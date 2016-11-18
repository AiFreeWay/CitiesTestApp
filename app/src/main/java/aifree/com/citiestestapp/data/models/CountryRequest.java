package aifree.com.citiestestapp.data.models;


public class CountryRequest {

    private CountryData[] Result;

    public CountryRequest() {
    }

    public CountryRequest(CountryData[] result) {
        Result = result;
    }

    public CountryData[] getResult() {
        return Result;
    }

    public void setResult(CountryData[] result) {
        Result = result;
    }
}
