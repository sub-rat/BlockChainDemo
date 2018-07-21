package np.com.subratgyawali.blockchaindemo.transaction

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import np.com.subratgyawali.blockchaindemo.R
import np.com.subratgyawali.blockchaindemo.base.SelectableRecyclerViewAdapter
import np.com.subratgyawali.blockchaindemo.databinding.ItemTransactionBinding
import np.com.subratgyawali.blockchaindemo.domain.TransactionModel

class CurrentTransactionAdapter(override val dataList: List<TransactionModel>, override val context: Context) : SelectableRecyclerViewAdapter<CurrentTransactionAdapter.MyViewHolder,TransactionModel>(dataList) {
    override fun getViewHolder(binding: ViewDataBinding, viewType: Int): MyViewHolder {
        return MyViewHolder(binding as ItemTransactionBinding)
    }

    override fun getItemLayoutResource(viewType: Int): Int {
        return R.layout.item_transaction
    }

    override fun onBindCustomViewHolder(holder: MyViewHolder, position: Int) {
        var transaction = dataList[position]
        holder.bind(transaction)
    }

    override fun addMoreData(list: List<TransactionModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MyViewHolder(var itemTransactionBinding: ItemTransactionBinding) : RecyclerView.ViewHolder(itemTransactionBinding.root) {

        fun bind(item :TransactionModel){
            itemTransactionBinding.tvAmount.text = item.amount.toString()
            itemTransactionBinding.tvRecipient.text = item.recipient
            itemTransactionBinding.tvSender.text = item.sender
        }
    }
}