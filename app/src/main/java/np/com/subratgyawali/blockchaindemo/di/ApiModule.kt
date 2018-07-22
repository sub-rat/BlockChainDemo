package np.com.subratgyawali.blockchaindemo.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import np.com.subratgyawali.blockchaindemo.network.ApiInterceptor
import np.com.subratgyawali.blockchaindemo.network.RetrofitApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideGson() : Gson{
        return Gson()
    }

    @Singleton
    @Provides
    fun getHttpClient(apiInterceptor : ApiInterceptor) : OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(apiInterceptor)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    @Singleton
    @Provides
    fun remoteRepo(gson: Gson, client: OkHttpClient) : RetrofitApiService {
        return Retrofit.Builder()
                .baseUrl("https://protected-river-83779.herokuapp.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build().create(RetrofitApiService::class.java)
    }

}