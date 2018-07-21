package np.com.subratgyawali.blockchaindemo.blockchain


import android.support.v4.app.Fragment
import dagger.Subcomponent
import dagger.android.AndroidInjector
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped


/**
 * A simple [Fragment] subclass.
 *
 */

@Subcomponent
interface BlockChainFragmentSubComponent : AndroidInjector<BlockChainFragment>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BlockChainFragment>()
}
