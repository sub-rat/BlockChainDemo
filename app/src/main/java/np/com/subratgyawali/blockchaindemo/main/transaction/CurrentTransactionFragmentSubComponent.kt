package np.com.subratgyawali.blockchaindemo.main.transaction

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface CurrentTransactionFragmentSubComponent: AndroidInjector<CurrentTransactionFragment> {

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<CurrentTransactionFragment>()
}