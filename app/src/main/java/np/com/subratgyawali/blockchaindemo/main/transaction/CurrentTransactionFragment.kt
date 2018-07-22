package np.com.subratgyawali.blockchaindemo.main.transaction

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.BaseFragment
import np.com.subratgyawali.blockchaindemo.databinding.FragmentCurrentTransactionBinding
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel
import javax.inject.Inject


class CurrentTransactionFragment : BaseFragment(),CurrentTransactionPageContract.View {

    lateinit var dataBinding:FragmentCurrentTransactionBinding

    @Inject
    lateinit var presenter: CurrentTransactionPageContract.Presenter


    companion object {
        fun newInstance(): CurrentTransactionFragment{
            return CurrentTransactionFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_transaction, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title = "Current Transactions"
        showLoading(dataBinding,"Getting Current transactions")
        presenter.start()
        dataBinding.swipeRefreshLayout.setOnRefreshListener {
            showLoading(dataBinding, "GettingCurrentTransactions")
            presenter.start()
        }
        dataBinding.btnSync.isEnabled = false
        dataBinding.btnClear.isEnabled = false
        dataBinding.mine.setOnClickListener {
            showLoading(dataBinding,"Mining...")
            presenter.mine()
        }

        dataBinding.btnSync.setOnClickListener {
            presenter.syncTransactions()
        }

        dataBinding.btnClear.setOnClickListener {
            presenter.clearTransactions()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun showCurrentTransaction(currentTransaction: List<TransactionModel>?) {
        dataBinding.swipeRefreshLayout.isRefreshing = false
        showData(dataBinding)

        currentTransaction?.let {
            if(it.isEmpty()) {
                showError(dataBinding, "No Transactions Are Available Now")
                dataBinding.btnSync.isEnabled = true
            }else{
                dataBinding.btnSync.isEnabled = false
                dataBinding.btnClear.isEnabled = true
            }

            dataBinding.rvCurrentTransaction.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = CurrentTransactionAdapter(it, activity!!.applicationContext)
            }
        }?: showError(dataBinding,"No Transactions Are Available Now")
    }

    override fun onErrorGettingCurrentTransaction(error: Throwable) {
        dataBinding.swipeRefreshLayout.isRefreshing = false
        showError(dataBinding,error.message?.let { it }?:"Failed To Get Transaction")
    }

    override fun onSuccessTransaction() {
        presenter.start()
    }

    override fun onSuccessClearTransactions() {
       presenter.start()
    }

    override fun hideLoading() {
        showData(dataBinding)
    }

    override fun onMiningSuccess() {
       presenter.start()
    }


}
