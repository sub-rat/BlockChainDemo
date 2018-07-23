package np.com.subratgyawali.blockchaindemo.balance

import dagger.Module
import dagger.Provides
import np.com.subratgyawali.blockchaindemo.data.MainRepositoryImpl
import np.com.subratgyawali.blockchaindemo.data.remote.MainRemoteRepo
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.di.scope.ActivityScoped
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService

@Module
class BalanceFragmentModule {

    @FragmentScoped
    @Provides
    fun provideBalanceFragment( balanceFragment: BalanceFragment):BalancePageContract.View{
        return balanceFragment
    }

    @FragmentScoped
    @Provides
    fun provideBalancePagePresenter( view : BalancePageContract.View, repository: MainRepositoryImpl) : BalancePageContract.Presenter{
        return BalancePagePresenter(view,repository)
    }

    @Provides
    fun provideRemoteRepository(apiService: RetrofitApiService): MainRepository{
        return MainRemoteRepo(apiService)
    }
}