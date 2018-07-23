package np.com.subratgyawali.blockchaindemo.balance

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.BaseFragment
import np.com.subratgyawali.blockchaindemo.databinding.FragmentBalanceBinding
import np.com.subratgyawali.blockchaindemo.domain.Balance
import javax.inject.Inject

class BalanceFragment : BaseFragment(), BalancePageContract.View {

    lateinit var dataBinding:FragmentBalanceBinding

    @Inject
    lateinit var presenter: BalancePageContract.Presenter

    companion object {
        fun newInstance():BalanceFragment{
            return BalanceFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.start()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_balance,container,false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title = "Balance"
        presenter.start()
    }

    override fun showBalance(balance: Balance) {
        dataBinding.tvNetAmount.text = balance.netAmount.toString()
        dataBinding.tvReceivedAmount.text = balance.receivedAmount.toString()
        dataBinding.tvSenderAmount.text = balance.sentAmount.toString()
    }
}
