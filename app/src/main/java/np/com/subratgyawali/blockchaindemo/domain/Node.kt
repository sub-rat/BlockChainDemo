package np.com.subratgyawali.blockchaindemo.domain

import com.google.gson.annotations.SerializedName

class Node (
        @SerializedName("nodes")
        var nodes :List<String>?
)