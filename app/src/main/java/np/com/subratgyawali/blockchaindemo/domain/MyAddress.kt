package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.SerializedName

class MyAddress (
    @SerializedName("address")
    var address: String
)