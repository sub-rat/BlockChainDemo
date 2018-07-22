package np.com.subratgyawali.blockchaindemo.main.blockchain

import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import javax.inject.Inject


class BlockChainPagePresenter @Inject constructor(var view: BlockChainPageContract.View, var repository: MainRepository) : BlockChainPageContract.Presenter{
    override fun start() {
        repository.getBlockChain().subscribe(
                {
                    view.onBlockChainSuccess(it)
                },
                {
                    it.printStackTrace()
                    view.onErrorGettingBlockChain(it)
                },
                {

                }
        )
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
