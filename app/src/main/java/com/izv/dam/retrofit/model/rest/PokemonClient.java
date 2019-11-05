package com.izv.dam.retrofit.model.rest;

import com.izv.dam.retrofit.model.data.Pokemon;
import com.izv.dam.retrofit.model.data.Type;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PokemonClient {

    @DELETE("type/{id}")
    Call<Integer> deleteType(@Path("id") long id);

    @GET("type/{id}")
    Call<Type> getType(@Path("id") long id);

    @GET("type")
    Call<ArrayList<Type>> getTypes();

    @POST("type")
    Call<Long> postType(@Body Type type);

    @PUT("type/{id}")
    Call<Integer> putType(@Path("id") long id, @Body Type type);

    @DELETE("pokemon/{id}")
    Call<Integer> deletePokemon(@Path("id") long id);

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") long id);

    @GET("pokemon")
    Call<ArrayList<Pokemon>> getPokemons();

    @POST("pokemon")
    Call<Long> postPokemon(@Body Pokemon pokemon);

    @PUT("pokemon/{id}")
    Call<Integer> putPokemon(@Path("id") long id, @Body Pokemon pokemon);
}