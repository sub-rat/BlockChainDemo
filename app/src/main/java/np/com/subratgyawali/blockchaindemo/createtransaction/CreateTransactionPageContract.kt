package np.com.subratgyawali.blockchaindemo.createtransaction

import np.com.subratgyawali.blockchaindemo.base.BasePresenter
import np.com.subratgyawali.blockchaindemo.base.BaseView
import np.com.subratgyawali.blockchaindemo.domain.Addresses
import np.com.subratgyawali.blockchaindemo.domain.MyAddress
import np.com.subratgyawali.blockchaindemo.domain.Response
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel

interface CreateTransactionPageContract {

    interface View:BaseView<Presenter>{
        fun onGetAddressSuccess(address: Addresses)
        fun onMyAddressSuccess(address: MyAddress)
        fun onCreateTransactionSuccess(response: Response)
        fun errorResponse(response: Throwable)
        fun onSyncAddressSuccess(address: Addresses)

    }

    interface Presenter:BasePresenter{
        fun getMyAddress()
        fun createTransaction(data: TransactionModel)
        fun syncAddress()

    }
}