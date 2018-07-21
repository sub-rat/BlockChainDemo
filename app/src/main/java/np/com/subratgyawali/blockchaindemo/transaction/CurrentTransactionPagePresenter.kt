package np.com.subratgyawali.blockchaindemo.transaction

import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import javax.inject.Inject

class CurrentTransactionPagePresenter @Inject constructor(val view: CurrentTransactionPageContract.View, val repository: MainRepository) : CurrentTransactionPageContract.Presenter {

    override fun start() {
        repository.getCurrentTransaction()
                .subscribe(
                        {
                           view.showCurrentTransaction(it)
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