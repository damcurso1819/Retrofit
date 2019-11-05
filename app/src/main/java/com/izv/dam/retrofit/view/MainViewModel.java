package com.izv.dam.retrofit.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.izv.dam.retrofit.model.Repository;
import com.izv.dam.retrofit.model.data.Type;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public void add(Type type) {
        repository.saveType(type);
    }

    public LiveData<ArrayList<Type>> getLiveTypeList() {
        return repository.getLifeTypeList();
    }

    public List<Type> getTypeList() {
        return repository.getTypeList();
    }

}