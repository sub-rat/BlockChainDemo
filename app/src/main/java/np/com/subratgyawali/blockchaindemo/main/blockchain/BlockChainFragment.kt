package np.com.subratgyawali.blockchaindemo.main.blockchain


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.BaseFragment
import np.com.subratgyawali.blockchaindemo.databinding.FragmentBlockChainBinding
import np.com.subratgyawali.blockchaindemo.domain.BlockChain
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class BlockChainFragment : BaseFragment(),BlockChainPageContract.View{

    lateinit var dataBinding : FragmentBlockChainBinding

    @Inject
    lateinit var presenter: BlockChainPageContract.Presenter

    companion object {
        fun newInstance():BlockChainFragment{
            return BlockChainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_block_chain,container,false)
        setHasOptionsMenu(false)
        return dataBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity!!.title ="Block chain"
        showLoading(dataBinding,"Getting Latest BockChain")
        presenter.start()
        dataBinding.swipeRefreshLayout.setOnRefreshListener {
            showLoading(dataBinding, "Getting Latest BockChain")
            presenter.start()
        }


    }

    override fun onBlockChainSuccess(blockChain: BlockChain) {
        dataBinding.swipeRefreshLayout.isRefreshing = false
        showData(dataBinding)
        dataBinding.rvBlockChain.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BlockChainParentAdapter(blockChain.chain, context)
        }
    }

    override fun onErrorGettingBlockChain(error: Throwable) {
        dataBinding.swipeRefreshLayout.isRefreshing = false
        showError(dataBinding,error.message?.let { it }?:"Error Getting Block Chain")
    }


}
