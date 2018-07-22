package np.com.subratgyawali.blockchaindemo.base

import android.content.pm.ActivityInfo
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import dagger.android.support.DaggerAppCompatActivity
import np.com.subratgyawali.blockchaindemo.MainApplication
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.di.AppComponent

abstract class BaseActivity : DaggerAppCompatActivity(){
    lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        this.component = MainApplication.component(this)
    }

    fun <T : ViewDataBinding> showLoading(binding: T?, loadingMessage:String?) {
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = loadingMessage?.let { it }?:"Loading..."
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.VISIBLE
    }

    fun <T : ViewDataBinding> showData(binding: T?) {
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.GONE
    }

    fun <T : ViewDataBinding> showError(binding: T?, errorMessage: String) {
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.visibility = View.VISIBLE
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<TextView>(R.id.txtLoading)?.text = errorMessage
        binding?.root?.findViewById<RelativeLayout>(R.id.loadingLayout)?.findViewById<ProgressBar>(R.id.progressBar)?.visibility = View.GONE
    }
}