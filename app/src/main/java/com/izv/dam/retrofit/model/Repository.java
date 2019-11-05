package com.izv.dam.retrofit.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.izv.dam.retrofit.model.data.Type;
import com.izv.dam.retrofit.model.rest.PokemonClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.izv.dam.retrofit.MainActivity.TAG;


public class Repository {

    //https://stackoverflow.com/questions/51780696/how-to-make-retrofit-api-call-using-viewmodel-and-livedata

    private PokemonClient apiClient;

    private final String url = "18.206.115.47";

    private ArrayList<Type> typeList = new ArrayList<>();
    private MutableLiveData<ArrayList<Type>> liveTypeList = new MutableLiveData<>();

    public Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + url + "/web/psp/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiClient = retrofit.create(PokemonClient.class);
        fetchTypeList();
    }

    public void fetchTypeList() {
        Call<ArrayList<Type>> call = apiClient.getTypes();
        call.enqueue(new Callback<ArrayList<Type>>() {
            @Override
            public void onResponse(Call<ArrayList<Type>> call, Response<ArrayList<Type>> response) {
                Log.v(TAG, "1:" + response.body().toString());
                typeList = response.body();
                liveTypeList.setValue(typeList);
            }
            @Override
            public void onFailure(Call<ArrayList<Type>> call, Throwable t) {
                Log.v(TAG, "1:" + t.getLocalizedMessage());
                typeList = new ArrayList<>();
            }
        });
    }

    public MutableLiveData<ArrayList<Type>> getLifeTypeList() {
        return liveTypeList;
    }

    public ArrayList<Type> getTypeList() {
        return typeList;
    }

    public void saveType(Type type) {
        Call<Long> call = apiClient.postType(type);
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(Call<Long> call, Response<Long> response) {
                Log.v(TAG, response.body().toString());
                fetchTypeList();
            }
            @Override
            public void onFailure(Call<Long> call, Throwable t) {
                Log.v(TAG, t.getLocalizedMessage());
                typeList = new ArrayList<>();
            }
        });
    }
}