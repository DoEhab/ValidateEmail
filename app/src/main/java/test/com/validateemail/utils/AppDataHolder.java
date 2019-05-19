package test.com.validateemail.utils;


import test.com.validateemail.model.User;

/**
 * Created by Doha on 21/02/19.
 */
public class AppDataHolder {
    private static AppDataHolder instance;


    private String authToken;
    private User user;
    public static void setInstance(AppDataHolder instance) {
        AppDataHolder.instance = instance;
    }

    public static AppDataHolder getInstance(){
        if(instance == null ){
            instance = new AppDataHolder();
        }
        return instance;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
