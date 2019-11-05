package com.izv.dam.retrofit;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.izv.dam.retrofit.model.data.Type;
import com.izv.dam.retrofit.view.MainAdapter;
import com.izv.dam.retrofit.view.MainViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "xyz" + MainActivity.class.getCanonicalName();

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        RecyclerView rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        final MainAdapter mainAdapter = new MainAdapter(this);
        rvList.setAdapter(mainAdapter);

        viewModel.getLiveTypeList().observe(this, new Observer<ArrayList<Type>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Type> types) {
                mainAdapter.setTypes(types);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Type> typeList = viewModel.getTypeList();
                for(Type t: typeList) {
                    Log.v(TAG, t.toString());
                }
                Random random = new Random();
                Type type = new Type();
                type.setType("type " + random.nextInt(1000));
                viewModel.add(type);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}