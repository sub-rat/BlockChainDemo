package np.com.subratgyawali.blockchaindemo.createtransaction

import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel
import javax.inject.Inject

class CreateTransactionPagePresenter @Inject constructor(val view:CreateTransactionPageContract.View, val repository: MainRepository) : CreateTransactionPageContract.Presenter{

    override fun start() {
       repository.getAddress()
               .subscribe(
                       {
                           view.onGetImageSuccess(it)
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


    override fun getMyAddress() {
        repository.getMyAddress()
                .subscribe(
                        {
                            view.onMyAddressSuccess(it)
                        },
                        {
                            it.printStackTrace()
                        },
                        {}

                )
    }

    override fun createTransaction(data: TransactionModel) {
       repository.createTransaction(data)
               .subscribe(
                       {
                           view.onCreateTransactionSuccess(it)
                       },
                       {
                           it.printStackTrace()
                           view.errorResponse(it)
                       },
                       {

                       }

               )
    }


}