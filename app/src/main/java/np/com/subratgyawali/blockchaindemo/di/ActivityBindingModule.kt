package np.com.subratgyawali.blockchaindemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import np.com.subratgyawali.blockchaindemo.createtransaction.CreateTransactionActivity
import np.com.subratgyawali.blockchaindemo.createtransaction.CreateTransactionActivityModule
import np.com.subratgyawali.blockchaindemo.di.scope.ActivityScoped
import np.com.subratgyawali.blockchaindemo.main.MainActivity
import np.com.subratgyawali.blockchaindemo.main.MainActivityModule

/**
 * Created by subrat on 6/25/18.
 */

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(MainActivityModule::class),(FragmentBindingModule::class)])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(CreateTransactionActivityModule::class)])
    internal abstract fun createTransactionActivity(): CreateTransactionActivity
}