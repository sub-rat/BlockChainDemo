package np.com.subratgyawali.blockchaindemo.blockchain


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 *
 */
class BlockChainFragment : BaseFragment() {

    companion object {
        fun newInstance():BlockChainFragment{
            return BlockChainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_block_chain, container, false)
    }


}
