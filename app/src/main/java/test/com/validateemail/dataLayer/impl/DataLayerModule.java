package test.com.validateemail.dataLayer.impl;

import dagger.Module;
import dagger.Provides;

import test.com.validateemail.dataLayer.HomeAPI;
import test.com.validateemail.service.HomeService;
import test.com.validateemail.utils.RetrofitFactory;


import javax.inject.Singleton;


@Module
public class DataLayerModule {

    @Singleton
    @Provides
    HomeService providesHomeService() {
        return RetrofitFactory.createService(HomeService.class);
    }


    @Singleton
    @Provides
    HomeAPI providesHomeAPI(HomeService service) {
        return new HomeAPIImpl(service);
    }


}
