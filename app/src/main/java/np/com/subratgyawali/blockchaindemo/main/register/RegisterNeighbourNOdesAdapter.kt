package np.com.subratgyawali.blockchaindemo.main.register

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.item_nodes.view.*
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.SelectableRecyclerViewAdapter
import np.com.subratgyawali.blockchaindemo.databinding.ItemNodesBinding
import np.com.subratgyawali.blockchaindemo.databinding.ItemTransactionBinding
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel

class RegisterNeighbourNOdesAdapter(override val dataList: List<String>, override val context: Context) : SelectableRecyclerViewAdapter<RegisterNeighbourNOdesAdapter.MyViewHolder,String>(dataList) {
    override fun getViewHolder(binding: ViewDataBinding, viewType: Int): MyViewHolder {
        return MyViewHolder(binding as ItemNodesBinding)
    }

    override fun getItemLayoutResource(viewType: Int): Int {
        return R.layout.item_nodes
    }

    override fun onBindCustomViewHolder(holder: MyViewHolder, position: Int) {
        val node = dataList[position]
        holder.bind(node)
    }

    override fun addMoreData(list: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MyViewHolder(var nodeBinding: ItemNodesBinding) : RecyclerView.ViewHolder(nodeBinding.root) {

        fun bind(item :String){
            nodeBinding.tvNodeName.text = String.format("%s",item)

        }
    }
}