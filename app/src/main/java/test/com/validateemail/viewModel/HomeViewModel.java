package test.com.validateemail.viewModel;


import android.util.Pair;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import test.com.validateemail.DataBinding;


public interface HomeViewModel {
    Pair<Boolean, Integer> checkEmail(String email);
    Flowable<DataBinding.BaseResponse> validateMyEmail(String email);


}
