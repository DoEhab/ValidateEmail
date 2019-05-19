package test.com.validateemail.service;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import test.com.validateemail.DataBinding;

public interface HomeService {
    @GET("validateEmail/{email}")
    Flowable<DataBinding.BaseResponse> validateMyEmail(@Path("email") String email);


}
