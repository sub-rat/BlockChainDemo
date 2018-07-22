package np.com.subratgyawali.blockchaindemo.main.register


import dagger.Module
import dagger.Provides
import np.com.subratgyawali.blockchaindemo.data.MainRepositoryImpl
import np.com.subratgyawali.blockchaindemo.data.remote.MainRemoteRepo
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.di.scope.FragmentScoped
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService


@Module
class RegisterNeighbourNodesFragmentModule {

    @FragmentScoped
    @Provides
    fun provideRegisterNeighbourNodesFragment(registerNeighbourNodesFragment: RegisterNeighbourNodesFragment): RegisterNeighbourNodesPageContract.View{
        return registerNeighbourNodesFragment
    }

    @FragmentScoped
    @Provides
    fun provideRegisterNeighbourNodesPagePresenter(view: RegisterNeighbourNodesPageContract.View, repository: MainRepositoryImpl) : RegisterNeighbourNodesPageContract.Presenter{
        return RegisterNeighbourNodesPagePresenter(view, repository)
    }

    @Provides
    fun provideMainRemoteData(retrofitApiService: RetrofitApiService): MainRepository {
        return MainRemoteRepo(retrofitApiService)
    }

}
