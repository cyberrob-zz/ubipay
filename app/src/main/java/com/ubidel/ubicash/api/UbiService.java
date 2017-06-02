package com.ubidel.ubicash.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ubidel.ubicash.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UbiService {

    private ApiEndPoints apiService;
    private static HttpLoggingInterceptor logging;
    private static OkHttpClient okHttpClient;

    public UbiService() {
        final Gson gson = new GsonBuilder()
//                .registerTypeAdapter(AirQuality.class, new JsonDeserializer<AirQuality>() {
//                    @Override
//                    public AirQuality deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                        if (json.isJsonArray()) {
//                            return null;
//                        } else if (json.isJsonObject()) {
//                            final Gson theGson = new GsonBuilder().create();
//                            return theGson.fromJson(json, AirQuality.class);
//                        }
//                        return null;
//                    }
//                })
                .create();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.DEBUG? ServerConfig.DEV_API : ServerConfig.PROD_API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
        apiService = retrofit.create(ApiEndPoints.class);
    }

    private static OkHttpClient getOkHttpClient() {

        if (logging == null) {
            logging = new HttpLoggingInterceptor();
        }
        logging.setLevel(
                BuildConfig.DEBUG ?
                        HttpLoggingInterceptor.Level.BODY:
                        HttpLoggingInterceptor.Level.NONE);

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();
        }

        return okHttpClient;
    }

//    public Observable<List<Place>> getLocationInformation(final float lat, final float lng, final int radius, final String language, final List<String> types, final int limitOnEachType) {
//        return Observable.create(new Observable.OnSubscribe<List<Place>>() {
//            @Override
//            public void call(final Subscriber<? super List<Place>> subscriber) {
//                apiService.getPOI(new LocationRequest(lat, lng, radius, language, types, limitOnEachType)).enqueue(new Callback<LocationResponse>() {
//                    @Override
//                    public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
//                        final List<Place> places = response.body().results;
//                        subscriber.onNext(places);
//                        subscriber.onCompleted();
//                    }
//
//                    @Override
//                    public void onFailure(Call<LocationResponse> call, Throwable t) {
//                        subscriber.onError(t);
//                    }
//                });
//            }
//        });
//    }
//
//    public Observable<Result> search(List<String> types, String keyword) {
//        SearchBody searchBody = new SearchBody(types, keyword);
//        return apiService.search(searchBody);
//    }
//
//    public Observable<AirQuality> getAirQuality(LocationRequest locationRequest) {
//        return apiService.getAirQualityByCoordinate(locationRequest);
//    }
//
//    public Observable<Weather> getWeather(LocationRequest locationRequest) {
//        return apiService.getWeatherByCoordinate(locationRequest);
//    }
//
//    public Observable<FullWeatherData> getFullWeatherData(LocationRequest locationRequest) {
//        return apiService.getWeatherAndAirQuality(locationRequest);
//    }
}