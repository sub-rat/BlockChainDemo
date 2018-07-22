package np.com.subratgyawali.blockchaindemo.main.blockchain


import android.support.v4.app.Fragment
import dagger.Subcomponent
import dagger.android.AndroidInjector


/**
 * A simple [Fragment] subclass.
 *
 */

@Subcomponent
interface BlockChainFragmentSubComponent : AndroidInjector<BlockChainFragment>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BlockChainFragment>()
}
