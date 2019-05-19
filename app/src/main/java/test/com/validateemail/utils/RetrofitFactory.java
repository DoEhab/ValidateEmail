package test.com.validateemail.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


public class RetrofitFactory {
        public static <T> T createService(Class<T> clazz) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(chain -> {
                        Request.Builder request = chain.request().newBuilder().addHeader("Accept", "application/json");


                            request.addHeader("X-RapidAPI-Host","pozzad-email-validator.p.rapidapi.com")
                                    .addHeader("X-RapidAPI-Key","3107299430mshf677156844da714p1d3154jsn49ecfcf7ccd5");

                        Response response =  chain.proceed(request.build());
                        return response;

                    })
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit
                    .Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Constants.RETROFIT_BASE_URL)
                    .client(okHttpClient)
                    .build();
            return  retrofit.create(clazz);
        }
    }
