package np.com.subratgyawali.blockchaindemo.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by subrat on 3/24/18.
 */

/**
 * recycler view to handle item click event
 *
 * @param <T> ViewHolder required for recycler view
 * @param <S> To be returned model when item is clicked
</S></T> */
abstract class SelectableRecyclerViewAdapter<T : RecyclerView.ViewHolder, S>(
        internal var list: List<S>) : BaseRecyclerViewAdapter<T>() {
    private var onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener<S>? = null
    private var loadMoreListener: LoadMoreListener? = null

    /**
     * Gets to list of data from which clicked model is to be returned
     *
     * @return list of models for recycler view
     */
    abstract val dataList: List<S>?

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.itemView.setOnClickListener { _ ->
            if(onRecyclerViewItemClickListener != null && dataList != null){
                        onRecyclerViewItemClickListener?.
                                onRecyclerViewItemClick(dataList!![holder.adapterPosition], position)
                    }
        }

        onBindCustomViewHolder(holder, position)
    }

    abstract fun getViewHolder(binding: ViewDataBinding, viewType: Int) : T
    protected abstract fun getItemLayoutResource(viewType: Int): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context),getItemLayoutResource(viewType),parent,false)
        return getViewHolder(viewDataBinding,viewType)
    }

    protected abstract fun onBindCustomViewHolder(holder: T, position: Int)
    abstract fun addMoreData(list: List<S>)


    fun setOnRecycleViewItemClickListener(onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener<S>) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    fun setLoadMoreListeners(loadMoreListener: LoadMoreListener){
        this.loadMoreListener = loadMoreListener
    }

    interface LoadMoreListener{
        fun onLoadMore()
    }

}