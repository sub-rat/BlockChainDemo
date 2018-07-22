package np.com.subratgyawali.blockchaindemo.main.blockchain

import np.com.subratgyawali.blockchaindemo.base.BasePresenter
import np.com.subratgyawali.blockchaindemo.base.BaseView
import np.com.subratgyawali.blockchaindemo.domain.BlockChain


interface BlockChainPageContract {
    interface View:BaseView<Presenter>{
        fun onBlockChainSuccess(blockChain: BlockChain)
        fun onErrorGettingBlockChain(error: Throwable)

    }

    interface Presenter:BasePresenter{

    }
}
