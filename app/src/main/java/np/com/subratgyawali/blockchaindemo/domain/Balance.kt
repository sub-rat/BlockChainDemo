package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Balance (
    @SerializedName("net_amount")
    @Expose
    var netAmount: Int,
    @SerializedName("received_amount")
    @Expose
    var receivedAmount: Int,
    @SerializedName("sent_amount")
    @Expose
    var sentAmount: Int
)