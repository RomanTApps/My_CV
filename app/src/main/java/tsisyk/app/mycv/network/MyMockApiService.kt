package tsisyk.app.mycv.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import tsisyk.app.mycv.network.response.InfoResponce

//http://server452015.nazwa.pl/test_cv_app/info.json

interface MyMockApiService {

    @GET("info.json")
    fun getPrimaryInformation(): Deferred<InfoResponce>

    companion object{
        operator fun invoke( connectivityInterceptor: ConnectivityInterceptor): MyMockApiService{

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://server452015.nazwa.pl/test_cv_app/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyMockApiService::class.java)
        }
    }
}