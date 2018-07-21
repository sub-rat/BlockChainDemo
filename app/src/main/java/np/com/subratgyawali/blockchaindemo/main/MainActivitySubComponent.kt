package np.com.subratgyawali.blockchaindemo.main

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainActivitySubComponent: AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>()
}