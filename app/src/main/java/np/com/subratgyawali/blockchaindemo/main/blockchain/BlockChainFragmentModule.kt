package np.com.subratgyawali.blockchaindemo.main.blockchain


import dagger.Module
import dagger.Provides
import np.com.subratgyawali.blockchaindemo.data.MainRepositoryImpl
import np.com.subratgyawali.blockchaindemo.data.remote.MainRemoteRepo
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService


@Module
class BlockChainFragmentModule {

    @FragmentScoped
    @Provides
    fun providesBlockChainFragment(blockChainFragment: BlockChainFragment) : BlockChainPageContract.View{
        return blockChainFragment
    }

    @FragmentScoped
    @Provides
    fun provideBlockChainPagePresener(view: BlockChainPageContract.View, repository: MainRepositoryImpl) : BlockChainPageContract.Presenter{
        return BlockChainPagePresenter(view, repository)
    }

    @Provides
    fun provideMainRemoteData(retrofitApiService: RetrofitApiService): MainRepository {
        return MainRemoteRepo(retrofitApiService)
    }

}
