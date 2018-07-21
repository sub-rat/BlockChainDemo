package np.com.subratgyawali.blockchaindemo.network

import android.content.Context
import np.com.subratgyawali.blockchaindemo.utils.isNetworkAvaliable
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiInterceptor @Inject constructor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvaliable(context)){
            throw IOException()
        }

        synchronized(this){
            val requestBuilder = chain.request().newBuilder()
            val response = chain.proceed(requestBuilder.build())
            val responseBody = response.body()
            val responseString = responseBody?.string()
            val contentType = responseBody?.contentType()
           return response.newBuilder().body(ResponseBody.create(contentType, responseString!!)).build()
        }
    }
}