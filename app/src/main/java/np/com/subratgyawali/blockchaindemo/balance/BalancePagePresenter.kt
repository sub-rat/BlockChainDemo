package np.com.subratgyawali.blockchaindemo.balance

import np.com.subratgyawali.blockchaindemo.data.MainRepositoryImpl
import javax.inject.Inject

class BalancePagePresenter @Inject constructor(val view: BalancePageContract.View, val repository: MainRepositoryImpl) : BalancePageContract.Presenter {
    override fun start() {
       repository.getBalance()
               .subscribe(
                       {
                           view.showBalance(it)
                       },
                       {
                           it.printStackTrace()
                       },
                       {

                       }

               )
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}