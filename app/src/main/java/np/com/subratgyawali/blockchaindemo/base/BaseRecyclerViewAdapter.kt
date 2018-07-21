package np.com.subratgyawali.blockchaindemo.base

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * Created by subrat on 3/24/18.
 */
abstract class BaseRecyclerViewAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {
    abstract val context: Context
}