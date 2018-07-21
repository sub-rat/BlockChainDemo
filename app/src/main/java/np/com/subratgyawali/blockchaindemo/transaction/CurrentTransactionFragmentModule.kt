package np.com.subratgyawali.blockchaindemo.transaction

import dagger.Module
import dagger.Provides
import np.com.subratgyawali.blockchaindemo.data.MainRepositoryImpl
import np.com.subratgyawali.blockchaindemo.data.remote.MainRemoteRepo
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService


@Module
class CurrentTransactionFragmentModule {

    @FragmentScoped
    @Provides
    fun provideCurrentTransactionFragment(currentTransactionFragment: CurrentTransactionFragment) : CurrentTransactionPageContract.View{
        return currentTransactionFragment
    }

    @FragmentScoped
    @Provides
    fun provideCurrentTransactionPagePresenter(view: CurrentTransactionPageContract.View, repository: MainRepositoryImpl) : CurrentTransactionPageContract.Presenter{
        return CurrentTransactionPagePresenter(view, repository)
    }

    @Provides
     fun provideMainRemoteData(retrofitApiService: RetrofitApiService): MainRepository {
        return MainRemoteRepo(retrofitApiService)
    }

}