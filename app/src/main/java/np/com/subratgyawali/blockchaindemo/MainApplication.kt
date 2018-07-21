package np.com.subratgyawali.blockchaindemo

import android.content.Context
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import np.com.subratgyawali.blockchaindemo.di.AppComponent
import np.com.subratgyawali.blockchaindemo.di.DaggerAppComponent


class MainApplication : DaggerApplication() {
    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        this.component = DaggerAppComponent.builder().application(this).build()
        return component
    }

    companion object {
        fun component(context: Context) : AppComponent = ( context.applicationContext as MainApplication).component
    }
}