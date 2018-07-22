package np.com.subratgyawali.blockchaindemo.data.repository

import io.reactivex.Completable
import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.domain.*

interface MainRepository {
    fun getCurrentTransaction(): Observable<CurrentTransaction>
    fun getBlockChain() : Observable<BlockChain>
    fun getNodes(): Observable<Node>
    fun registerNode(node: String): Completable
    fun getAddress():Observable<Addresses>
    fun getMyAddress():Observable<MyAddress>
    fun createTransaction(data: TransactionModel): Observable<Response>
    fun mine():Completable
    fun clearTransactions():Completable
    fun syncTransactions(): Completable
}