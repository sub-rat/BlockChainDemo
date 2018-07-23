package np.com.subratgyawali.blockchaindemo.balance

import np.com.subratgyawali.blockchaindemo.base.BasePresenter
import np.com.subratgyawali.blockchaindemo.base.BaseView
import np.com.subratgyawali.blockchaindemo.domain.Balance

interface BalancePageContract {

    interface View:BaseView<Presenter>{
        fun showBalance(balance: Balance)

    }

    interface Presenter:BasePresenter{

    }
}