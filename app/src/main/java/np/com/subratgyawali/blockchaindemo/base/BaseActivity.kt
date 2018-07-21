package np.com.subratgyawali.blockchaindemo.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import dagger.android.support.DaggerAppCompatActivity
import np.com.subratgyawali.blockchaindemo.MainApplication
import np.com.subratgyawali.blockchaindemo.di.AppComponent

abstract class BaseActivity : DaggerAppCompatActivity(){
    lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        this.component = MainApplication.component(this)
    }
}