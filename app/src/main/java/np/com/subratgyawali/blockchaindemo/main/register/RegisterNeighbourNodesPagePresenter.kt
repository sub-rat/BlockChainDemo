package np.com.subratgyawali.blockchaindemo.main.register


import np.com.subratgyawali.blockchaindemo.data.repository.MainRepository
import javax.inject.Inject


class RegisterNeighbourNodesPagePresenter @Inject constructor(val view:RegisterNeighbourNodesPageContract.View, val repository: MainRepository): RegisterNeighbourNodesPageContract.Presenter {

    override fun start() {
        repository.getNodes()
                .subscribe(
                        {
                            view.showNodes(it.nodes)
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

    override fun registerNode(node:String) {
        repository.registerNode(node)
                .subscribe(
                        {
                            view.registerSuccessfull()
                        },
                        {
                            it.printStackTrace()
                        }
                )
    }

}
