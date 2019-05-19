package test.com.validateemail.dataLayer.impl;

import io.reactivex.Flowable;

import test.com.validateemail.DataBinding;
import test.com.validateemail.dataLayer.HomeAPI;
import test.com.validateemail.service.HomeService;


import java.util.HashMap;

public class HomeAPIImpl implements HomeAPI {
    private final HomeService service;

    HomeAPIImpl(HomeService service){
        this.service = service;
    }


    @Override
    public Flowable<DataBinding.BaseResponse> validateMyEmail(String email) {
        return service.validateMyEmail(email);
    }
}
