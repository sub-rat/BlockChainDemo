package np.com.subratgyawali.blockchaindemo.transaction

import dagger.Subcomponent
import dagger.android.AndroidInjector
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped


@Subcomponent
interface CurrentTransactionFragmentSubComponent: AndroidInjector<CurrentTransactionFragment> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<CurrentTransactionFragment>()
}