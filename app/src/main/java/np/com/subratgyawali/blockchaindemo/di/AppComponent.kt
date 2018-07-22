package np.com.subratgyawali.blockchaindemo.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import np.com.subratgyawali.blockchaindemo.MainApplication
import javax.inject.Singleton

/**
 * Created by subrat on 6/25/18.
 */

/**
 * This is a Dagger component. Refer to [com.rosia] for the list of Dagger components
 * used in this application.
 *
 *
 * Even though Dagger allows annotating a [Component] as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in [ ].
 * //[AndroidSupportInjectionModule]
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */

@Singleton
@Component(modules = [
    (ApiModule::class),
    (AndroidSupportInjectionModule::class),
    (ApplicationModule::class),
    (ActivityBindingModule::class),
    (FragmentBindingModule::class)])
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : AppComponent.Builder
        fun build() : AppComponent
    }

}