package np.com.subratgyawali.blockchaindemo.data

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.domain.*
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor( var remoteRepository: MainRepository) : MainRepository {
    override fun clearTransactions(): Completable {
        return remoteRepository.clearTransactions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun syncTransactions(): Completable {
       return remoteRepository.syncTransactions()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }

    override fun mine(): Completable {
        return remoteRepository.mine()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun createTransaction(data: TransactionModel): Observable<Response> {
        return remoteRepository.createTransaction(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getAddress(): Observable<Addresses> {
        return remoteRepository.getAddress()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getMyAddress(): Observable<MyAddress> {
        return remoteRepository.getMyAddress()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun registerNode(node: String): Completable {
        return remoteRepository.registerNode(node)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getNodes(): Observable<Node> {
        return remoteRepository.getNodes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

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