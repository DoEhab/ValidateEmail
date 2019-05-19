package test.com.validateemail.viewModel.impl;

import android.util.Pair;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import test.com.validateemail.DataBinding;
import test.com.validateemail.R;
import test.com.validateemail.dataLayer.HomeAPI;
import test.com.validateemail.utils.Constants;
import test.com.validateemail.viewModel.HomeViewModel;

import java.util.HashMap;


public class HomeViewModelImpl implements HomeViewModel {

    private final HomeAPI homeAPI;

    HomeViewModelImpl(HomeAPI api) {
        this.homeAPI = api;
    }


       @Override
        public Pair<Boolean, Integer> checkEmail(String email) {
            email = email.replace(" ", "").replace("\n", "");
            if (email.isEmpty()) {
                return new Pair(false, R.string.empty_email);
            } else if (!email.matches(Constants.EMAIL_PATTERN)) {
                return new Pair(false, R.string.email_format);
            }
            return new Pair(true, R.string.ok);
        }

    @Override
    public Flowable<DataBinding.BaseResponse> validateMyEmail(String email) {
           return homeAPI.validateMyEmail(email).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
}
