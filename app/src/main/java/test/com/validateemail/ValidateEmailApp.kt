package test.com.validateemail

import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatDelegate


class ValidateEmailApp: Application() {


    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }
    }
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
        val config = baseContext.resources.configuration


    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
    fun getComponent(): AppComponent = component

}