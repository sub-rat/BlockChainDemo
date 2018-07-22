package np.com.subratgyawali.blockchaindemo.data.repository

import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.domain.BlockChain
import np.com.subratgyawali.blockchaindemo.domain.CurrentTransaction

interface MainRepository {
    fun getCurrentTransaction(): Observable<CurrentTransaction>
    fun getBlockChain() : Observable<BlockChain>
}