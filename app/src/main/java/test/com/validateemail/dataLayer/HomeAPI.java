package test.com.validateemail.dataLayer;

import io.reactivex.Flowable;
import test.com.validateemail.DataBinding;


public interface HomeAPI {
    Flowable<DataBinding.BaseResponse> validateMyEmail(String email);

}
