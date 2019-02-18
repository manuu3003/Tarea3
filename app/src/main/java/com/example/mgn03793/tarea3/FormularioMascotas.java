package com.example.mgn03793.tarea3;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormularioMascotas extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNombre, txtFecha;
    private RadioGroup rgTipo;
    private Button btnGrabar, btnConsultar;


    public FormularioMascotas() throws ParseException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_mascotas);
        txtNombre = findViewById(R.id.et_nombre);
        txtFecha = findViewById(R.id.et_fecha);
        rgTipo = findViewById(R.id.rg_tipo);
        btnGrabar = findViewById(R.id.btn_guardar);
        btnConsultar = findViewById(R.id.btn_consultar);

        btnGrabar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        Animal temp;
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_consultar :
                Toast.makeText(this,"Click sobre consultar", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, com.example.mgn03793.tarea3.MyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_guardar :
                temp = new Animal();
                temp.setNombre(txtNombre.getText().toString());
                temp.setFecha(txtFecha.getText().toString());
                int tipo = 0;
                /*  Metodo con IF... se utiliza en el siguiente bloque WHILE*/
                if (((RadioButton)rgTipo.getChildAt(0)).isChecked()) {
                    temp.setTipo(1);
                } else if (((RadioButton)rgTipo.getChildAt(1)).isChecked()) {
                    temp.setTipo(2);
                } else {
                    temp.setTipo(3);
                }

                txtNombre.setText("");
                txtFecha.setText("");
                ((RadioButton)rgTipo.getChildAt(0)).setChecked(true);
                ((AnimalesApp)getApplication()).insertaAnimal(temp); //Guardando en lista
                Toast.makeText(this,"Click sobre guardar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
