package be.vives.pokechamp.network

import be.vives.pokechamp.model.PokeBase
import be.vives.pokechamp.model.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://pokeapi.co/api/v2/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()

    .add(KotlinJsonAdapterFactory())
    .build()
/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface PokeApiService {
    /**
     * Returns a Coroutine [List] of (MarsProperty) which can be fetched in a Coroutine scope.
     * The @GET annotation indicates that the "realestate" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("pokemon?limit=151")
    suspend fun getName() : PokeBase

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name : String
    ) : Pokemon
}
/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object PokeApi {
    val retrofitService : PokeApiService by lazy { retrofit.create(PokeApiService::class.java) }
}