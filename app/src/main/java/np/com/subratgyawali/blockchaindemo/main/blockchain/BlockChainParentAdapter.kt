package np.com.subratgyawali.blockchaindemo.main.blockchain

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.SelectableRecyclerViewAdapter
import np.com.subratgyawali.blockchaindemo.databinding.ItemBlockChainHeaderBinding
import np.com.subratgyawali.blockchaindemo.domain.Chain
import np.com.subratgyawali.blockchaindemo.main.transaction.CurrentTransactionAdapter

class BlockChainParentAdapter(override val dataList: List<Chain>, override val context: Context) : SelectableRecyclerViewAdapter<BlockChainParentAdapter.MyViewHolder,Chain>(dataList) {
    override fun getViewHolder(binding: ViewDataBinding, viewType: Int): MyViewHolder {
        return MyViewHolder(binding as ItemBlockChainHeaderBinding)
    }

    override fun getItemLayoutResource(viewType: Int): Int {
        return R.layout.item_block_chain_header
    }

    override fun onBindCustomViewHolder(holder: MyViewHolder, position: Int) {
        var chain = dataList[position]
        holder.bind(chain)
        chain.transactions?.let {
            holder.viewBinding.rvBlockChainChild.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CurrentTransactionAdapter(it, context)
            }
        }
    }

    override fun addMoreData(list: List<Chain>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MyViewHolder(var viewBinding: ItemBlockChainHeaderBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item :Chain){
            viewBinding.tvIndex.text = String.format("index:%s",item.index)
            viewBinding.tvPreviousHash.text = String.format("previous hash:%s",item.previousHash)
            viewBinding.tvProof.text = String.format("proof:%s",item.proof)
            viewBinding.tvTimestamp.text = String.format("timestamp:%s",item.timestamp)
        }
    }
}