package np.com.subratgyawali.blockchaindemo.data.remote

import io.reactivex.Completable
import io.reactivex.Observable
import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.domain.*
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService
import javax.inject.Inject

class MainRemoteRepo @Inject constructor(var apiService: RetrofitApiService) : MainRepository{
    override fun mine(): Completable {
        return apiService.mine()
    }

    override fun createTransaction(data: TransactionModel): Observable<Response> {
        return apiService.createTransaction(data)
    }

    override fun getMyAddress(): Observable<MyAddress> {
        return apiService.getMyAddress()
    }

    override fun getAddress(): Observable<Addresses> {
        return apiService.getAddress()
    }



    override fun registerNode(node: String): Completable {
        val list = mutableListOf<String>()
        list.add(node)
        return apiService.registerNodes(Node(nodes = list))
    }

    override fun getNodes(): Observable<Node> {
        return apiService.getNodes()
    }

    override fun getBlockChain(): Observable<BlockChain> {
        return apiService.getBlockChain()
    }

    override fun getCurrentTransaction(): Observable<CurrentTransaction> {
       return apiService.getTransactions()
    }
}