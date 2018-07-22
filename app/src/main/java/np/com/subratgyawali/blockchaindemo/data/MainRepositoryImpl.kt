package np.com.subratgyawali.blockchaindemo.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.domain.BlockChain
import np.com.subratgyawali.blockchaindemo.domain.CurrentTransaction
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor( var remoteRepository: MainRepository) : MainRepository {
    override fun getBlockChain(): Observable<BlockChain> {
        return remoteRepository.getBlockChain()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getCurrentTransaction(): Observable<CurrentTransaction> {
        return remoteRepository.getCurrentTransaction()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}