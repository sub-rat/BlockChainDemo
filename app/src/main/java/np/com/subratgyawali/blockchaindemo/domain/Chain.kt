package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Chain (
    @SerializedName("index")
    @Expose
    var index: Int?,
    @SerializedName("previous_hash")
    @Expose
    var previousHash: String?,
    @SerializedName("proof")
    @Expose
    var proof: Int?,
    @SerializedName("timestamp")
    @Expose
    var timestamp: Double,
    @SerializedName("transactions")
    @Expose
    var transactions: List<TransactionModel>? = null

)