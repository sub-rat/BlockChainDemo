package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.SerializedName

class Addresses (
    @SerializedName("addresses")
    var addresses : List<String>
)