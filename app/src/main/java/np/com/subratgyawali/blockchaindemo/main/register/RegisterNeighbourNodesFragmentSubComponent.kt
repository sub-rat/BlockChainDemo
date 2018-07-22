package np.com.subratgyawali.blockchaindemo.main.register

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface RegisterNeighbourNodesFragmentSubComponent : AndroidInjector<RegisterNeighbourNodesFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<RegisterNeighbourNodesFragment>()
}

