package test.com.validateemail;

import dagger.Component;
import test.com.validateemail.activity.HomeActivity;
import test.com.validateemail.fragment.HomeFragment;

import javax.inject.Singleton;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(ValidateEmailApp app);
    void inject(HomeActivity homeActivity);
    void inject(HomeFragment homeFragment);
}
