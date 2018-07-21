package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TransactionModel (
    @SerializedName("amount")
    @Expose
    var amount: Int? = null,
    @SerializedName("recipient")
    @Expose
    var recipient: String? = null,
    @SerializedName("sender")
    @Expose
    var sender: String? = null
)