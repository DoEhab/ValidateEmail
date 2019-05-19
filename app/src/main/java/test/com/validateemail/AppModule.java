package test.com.validateemail;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import test.com.validateemail.dataLayer.impl.DataLayerModule;
import test.com.validateemail.viewModel.impl.ViewModelModule;

import javax.inject.Singleton;

/**
 * Created by Doha on 21/02/19.
 */
@Module(includes = {DataLayerModule.class, ViewModelModule.class})

public class AppModule {
        private Application app;

        AppModule(Application app) {
            this.app = app;
        }

        @Singleton
        @Provides
        Context providesContext() {
            return app;
        }


    }

