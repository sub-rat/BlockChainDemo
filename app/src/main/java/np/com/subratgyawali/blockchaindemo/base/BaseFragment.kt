package np.com.subratgyawali.blockchaindemo.base

import android.os.Bundle
import dagger.android.support.DaggerFragment
import np.com.subratgyawali.blockchaindemo.MainApplication
import np.com.subratgyawali.blockchaindemo.di.AppComponent

abstract class BaseFragment : DaggerFragment() {
    lateinit var component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.component = MainApplication.component(context!!)
    }
}