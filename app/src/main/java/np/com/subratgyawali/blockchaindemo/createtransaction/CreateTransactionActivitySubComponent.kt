package np.com.subratgyawali.blockchaindemo.createtransaction

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface CreateTransactionActivitySubComponent :AndroidInjector<CreateTransactionActivity>{

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<CreateTransactionActivity>()
}