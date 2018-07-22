package np.com.subratgyawali.blockchaindemo.network

import io.reactivex.Completable
import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.domain.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApiService {

    @GET("/transactions/current")
    fun getTransactions() : Observable<CurrentTransaction>

    @GET("/chain")
    fun getBlockChain() :Observable<BlockChain>

    @GET("/nodes")
    fun getNodes(): Observable<Node>

    @POST("/nodes/register")
    fun registerNodes(@Body nodes:Node) : Completable

    @GET("/addresses")
    fun getAddress(): Observable<Addresses>

    @GET("/who-am-i")
    fun getMyAddress():Observable<MyAddress>

    @POST("/transactions/new")
    fun createTransaction(@Body data: TransactionModel): Observable<Response>

    @GET("/mine")
    fun mine():Completable

    @GET("/transactions/clear")
    fun clearTransactions(): Completable

    @GET("/sync/transactions")
    fun syncTransaction(): Completable

}