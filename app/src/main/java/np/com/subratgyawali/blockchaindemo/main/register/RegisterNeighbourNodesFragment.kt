package np.com.subratgyawali.blockchaindemo.main.register


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.*

import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.BaseFragment
import np.com.subratgyawali.blockchaindemo.databinding.FragmentRegisterNeighbourNodesBinding
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterNeighbourNodesFragment : BaseFragment(), RegisterNeighbourNodesPageContract.View {

    lateinit var dataBinding: FragmentRegisterNeighbourNodesBinding

    @Inject
    lateinit var presenter: RegisterNeighbourNodesPageContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_register_neighbour_nodes, container, false)
        setHasOptionsMenu(false)
        return  dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.start()
        activity!!.title = "Register Node"
        dataBinding.btnRegister.setOnClickListener {
            val node = dataBinding.editNode.text.toString()
            if(node.isNotEmpty()){
                presenter.registerNode(node)
            }else{
                dataBinding.editNode.error = "Node is Empty"
            }
        }
    }

    override fun showNodes(nodes: List<String>?) {
        nodes?.let {
            dataBinding.rvNodes.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = RegisterNeighbourNOdesAdapter(nodes, context)

            }
        }
    }

    override fun registerSuccessfull() {
        presenter.start()
        Toast.makeText(context,"NodeRegistered Succesfully",Toast.LENGTH_SHORT).show()
    }



}
