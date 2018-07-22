package np.com.subratgyawali.blockchaindemo.data.remote

import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.domain.BlockChain
import np.com.subratgyawali.blockchaindemo.domain.CurrentTransaction
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService
import javax.inject.Inject

class MainRemoteRepo @Inject constructor(var apiService: RetrofitApiService) : MainRepository{
    override fun getBlockChain(): Observable<BlockChain> {
        return apiService.getBlockChain()
    }

    override fun getCurrentTransaction(): Observable<CurrentTransaction> {
       return apiService.getTransactions()
    }
}