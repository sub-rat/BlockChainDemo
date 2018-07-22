package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BlockChain (
    @SerializedName("chain")
    @Expose
    var chain: List<Chain>,
    @SerializedName("length")
    @Expose
    var length: Int
)