package np.com.subratgyawali.blockchaindemo.transaction

import np.com.subratgyawali.blockchaindemo.base.BasePresenter
import np.com.subratgyawali.blockchaindemo.base.BaseView
import np.com.subratgyawali.blockchaindemo.domain.CurrentTransaction

interface CurrentTransactionPageContract {

    interface View:BaseView<Presenter>{
        fun showCurrentTransaction(currentTransaction: CurrentTransaction?)
    }

    interface Presenter:BasePresenter{

    }
}