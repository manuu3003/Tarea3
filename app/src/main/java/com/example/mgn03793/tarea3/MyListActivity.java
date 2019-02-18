package com.example.mgn03793.tarea3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MyListActivity extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = findViewById(R.id.list_animales);
        lista.setAdapter(new AnimalesAdapter(this, ((AnimalesApp)getApplication()).getListAnimales()));
    }
}