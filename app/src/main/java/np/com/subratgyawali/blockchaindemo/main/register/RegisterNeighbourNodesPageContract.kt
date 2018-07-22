package np.com.subratgyawali.blockchaindemo.main.register

import np.com.subratgyawali.blockchaindemo.base.BasePresenter
import np.com.subratgyawali.blockchaindemo.base.BaseView


interface RegisterNeighbourNodesPageContract {

    interface View:BaseView<Presenter>{
        fun showNodes(nodes: List<String>?)
        fun registerSuccessfull()

    }

    interface Presenter:BasePresenter{
        fun registerNode(node:String)

    }

}
