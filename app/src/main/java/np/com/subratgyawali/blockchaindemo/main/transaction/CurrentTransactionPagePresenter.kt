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
        repository.mine().subscribe(
                {
                    view.onMiningSuccess()
                    view.hideLoading()
                },
                {
                    it.printStackTrace()
                    view.hideLoading()
                })
    }

    override fun clearTransactions() {
        repository.clearTransactions()
                .subscribe(
                        {
                            view.hideLoading()
                            view.onSuccessClearTransactions()
                        },
                        {
                            it.printStackTrace()
                            view.hideLoading()
                        }
                )
    }

    override fun syncTransactions() {
        repository.syncTransactions()
                .subscribe(
                        {
                            view.onSuccessTransaction()
                            view.hideLoading()
                        },
                        {
                            it.printStackTrace()
                            view.hideLoading()
                        }
                )
    }


}