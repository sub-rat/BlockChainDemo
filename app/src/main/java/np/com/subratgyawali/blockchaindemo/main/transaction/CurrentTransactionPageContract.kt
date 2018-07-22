package np.com.subratgyawali.blockchaindemo.main.transaction

import np.com.subratgyawali.blockchaindemo.base.BasePresenter
import np.com.subratgyawali.blockchaindemo.base.BaseView
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel

interface CurrentTransactionPageContract {

    interface View:BaseView<Presenter>{
        fun showCurrentTransaction(currentTransaction: List<TransactionModel>?)
        fun onErrorGettingCurrentTransaction(error: Throwable)
        fun onSuccessTransaction()
        fun onSuccessClearTransactions()
    }

    interface Presenter:BasePresenter{
        fun mine()
        fun clearTransactions()
        fun syncTransactions()

    }
}