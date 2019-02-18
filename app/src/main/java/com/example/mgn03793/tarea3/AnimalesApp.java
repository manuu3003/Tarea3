package com.example.mgn03793.tarea3;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class AnimalesApp extends Application {
    private List<Animal> listAnimales;
    @Override
    public void onCreate() {
        super.onCreate();
        listAnimales = new ArrayList<Animal>();
    }

    public void insertaAnimal(Animal Animal) {
        listAnimales.add(Animal);
    }

    public List<Animal> getListAnimales() {
        return listAnimales;
    }
}