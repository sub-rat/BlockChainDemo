package np.com.subratgyawali.blockchaindemo.createtransaction

import dagger.Module
import dagger.Provides
import np.com.subratgyawali.blockchaindemo.data.MainRepositoryImpl
import np.com.subratgyawali.blockchaindemo.data.remote.MainRemoteRepo
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.di.scope.ActivityScoped
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService

@Module
class CreateTransactionActivityModule {

    @ActivityScoped
    @Provides
    fun provideCreateTransactionActivity(createTransactionActivity: CreateTransactionActivity): CreateTransactionPageContract.View{
        return createTransactionActivity
    }

    @ActivityScoped
    @Provides
    fun provideCreateTransactionPagePresenger(view: CreateTransactionPageContract.View, repository: MainRepositoryImpl) : CreateTransactionPageContract.Presenter{
        return CreateTransactionPagePresenter(view, repository)
    }

    @Provides
    fun provideMainRemoteData(retrofitApiService: RetrofitApiService): MainRepository {
        return MainRemoteRepo(retrofitApiService)
    }
}