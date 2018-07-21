package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentTransaction (
        @SerializedName("current_transactions")
        @Expose
        var  currentTransactions : List<TransactionModel>?
)