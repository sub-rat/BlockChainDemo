package np.com.subratgyawali.blockchaindemo.base

/**
 * Created by subrat on 3/24/18.
 */
interface OnRecyclerViewItemClickListener<in T> {
    fun onRecyclerViewItemClick(selectedItem: T, position : Int)
}