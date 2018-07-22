package np.com.subratgyawali.blockchaindemo.main.transaction

import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import javax.inject.Inject

class CurrentTransactionPagePresenter @Inject constructor(val view: CurrentTransactionPageContract.View, val repository: MainRepository) : CurrentTransactionPageContract.Presenter {

    override fun start() {
        repository.getCurrentTransaction()
                .subscribe(
                        {
                           view.showCurrentTransaction(it.currentTransactions)
                        },
                        {
                            it.printStackTrace()
                            view.onErrorGettingCurrentTransaction(it)
                        },
                        {

                        }
                )
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mine() {
        repository.mine().subscribe({},{it.printStackTrace()})
    }

    override fun clearTransactions() {
       repository.clearTransactions()
               .subscribe(
                       {
                           view.onSuccessClearTransactions()
                       },
                       {
                           it.printStackTrace()
                       }
               )
    }

    override fun syncTransactions() {
        repository.syncTransactions()
                .subscribe(
                        {
                            view.onSuccessTransaction()
                        },
                        {
                            it.printStackTrace()
                        }
                )
    }


}