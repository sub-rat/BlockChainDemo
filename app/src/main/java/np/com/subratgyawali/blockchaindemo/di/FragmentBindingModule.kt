package np.com.subratgyawali.blockchaindemo.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import np.com.subratgyawali.blockchaindemo.main.blockchain.BlockChainFragment
import np.com.subratgyawali.blockchaindemo.main.blockchain.BlockChainFragmentModule
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped
import np.com.subratgyawali.blockchaindemo.main.register.RegisterNeighbourNodesFragment
import np.com.subratgyawali.blockchaindemo.main.register.RegisterNeighbourNodesFragmentModule
import np.com.subratgyawali.blockchaindemo.main.transaction.CurrentTransactionFragment
import np.com.subratgyawali.blockchaindemo.main.transaction.CurrentTransactionFragmentModule

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
abstract class FragmentBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [(BlockChainFragmentModule::class)])
    internal abstract fun blockChainFragment(): BlockChainFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [(CurrentTransactionFragmentModule::class)])
    abstract fun currentTransactionFragment(): CurrentTransactionFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [(RegisterNeighbourNodesFragmentModule::class)])
    abstract fun registerNeighbourNodesFragment(): RegisterNeighbourNodesFragment


}