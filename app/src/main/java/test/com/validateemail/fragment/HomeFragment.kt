package test.com.validateemail.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*

import test.com.validateemail.R
import test.com.validateemail.ValidateEmailApp
import test.com.validateemail.viewModel.HomeViewModel
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : ValidateEmailBaseFragment(){
    @Inject
    lateinit var viewModel: HomeViewModel
    private val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = activity?.application as ValidateEmailApp
        application.getComponent().inject(this)
        textView_check.setOnClickListener {
            val checkEmailResult = viewModel.checkEmail(editText_email.text.toString())
            if (checkEmailResult.first == true ) {
                callValidateEmailService()
            } else if (checkEmailResult.first == false) {
                layout_email.error=getString(checkEmailResult.second)
            }
        }

    }

    private fun callValidateEmailService() {
        showProgressDialog()
        val subscription = viewModel.validateMyEmail(editText_email.text.toString()).subscribe(
            {
                dismissProgressDialog()
                if(it.isValid)
                textView_result.text=getString(R.string.valid)
                else
                    textView_result.text=getString(R.string.not_valid)
            },
            {
                dismissProgressDialog()
                textView_result.text=it.toString()
            }
        )
        compositeDisposable?.add(subscription)    }

    override fun onPause() {
        super.onPause()
        compositeDisposable?.clear()
    }

    override fun onDestroy() {
        super.onDestroy();
        compositeDisposable?.dispose()
    }
}
