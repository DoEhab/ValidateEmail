package test.com.validateemail.activity

import android.app.Activity
import android.os.Bundle
import test.com.validateemail.R
import test.com.validateemail.ValidateEmailApp
import test.com.validateemail.fragment.HomeFragment
import test.com.validateemail.fragment.ValidateEmailBaseFragment

class HomeActivity : ValidateEmailBaseActivity (){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        (application as ValidateEmailApp).getComponent().inject(this)

        launchFragment(HomeFragment(),false)
    }

    fun launchFragment(fragment: ValidateEmailBaseFragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()

        if (addToBackStack) {
            transaction
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        } else {
            transaction.add(R.id.fragment_container, fragment).commitAllowingStateLoss()
        }
    }
}

