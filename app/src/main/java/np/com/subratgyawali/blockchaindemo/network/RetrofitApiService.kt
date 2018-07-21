package np.com.subratgyawali.blockchaindemo.network

import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.domain.CurrentTransaction
import retrofit2.http.GET

interface RetrofitApiService {

    @GET("/transaction/current")
    fun getTransactions() : Observable<CurrentTransaction>

    @GET("/chain")
    fun getBlockChain()

}