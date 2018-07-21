package np.com.subratgyawali.blockchaindemo.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by subrat on 3/24/18.
 */
abstract class BaseViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(obj: T)
}