package com.example.pryactividad04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtModelo, txtMarca, txtCosto;
    Spinner spnBuscar, spnOrdenar;
    TelefonoCelular obj;
    ColeccionDeObjetos cdo;
    ArrayList celulares;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnBuscar = (Spinner)findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.buscar_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnBuscar.setAdapter(adapter);

        spnOrdenar = (Spinner)findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.ordenar_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnOrdenar.setAdapter(adapter2);

        txtModelo = (EditText)findViewById(R.id.modelo);
        txtMarca = (EditText)findViewById(R.id.marca);
        txtCosto = (EditText)findViewById(R.id.costo);
        tabla = (TableLayout)findViewById(R.id.tableLayout);

        TelefonoCelular.porcGanancia = 0.30;
        cdo = new ColeccionDeObjetos();
        celulares = new ArrayList();
    }


    public void limpiar()
    {
        txtCosto.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtModelo.requestFocus();
    }
    public void mostrar()
    {
            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView tmarca = new TextView(this);
            TextView tmodelo = new TextView(this);
            TextView tprecio = new TextView(this);
            TextView tutilidad = new TextView(this);

            tmarca.setText("Marca");
            tmarca.setPadding(3, 3, 3, 3);
            tmodelo.setText("Modelo");
            tmodelo.setPadding(3, 3, 3, 3);
            tprecio.setText("Precio");
            tprecio.setPadding(3, 3, 3, 3);
            tutilidad.setText("Utilidad");
            tutilidad.setPadding(3, 3, 3, 3);
            row.addView(tmarca);
            row.addView(tmodelo);
            row.addView(tprecio);
            row.addView(tutilidad);
            tabla.addView(row,0);

            for (int i = 1; i <=celulares.size(); i++) {
                obj = (TelefonoCelular) celulares.get(i-1);
                row= new TableRow(this);
                lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                row.setLayoutParams(lp);
                tmarca = new TextView(this);
                tmodelo = new TextView(this);
                tprecio = new TextView(this);
                tutilidad = new TextView(this);
                tmarca.setText(obj.marca);
                tmarca.setPadding(3, 3, 3, 3);
                tmodelo.setText(obj.modelo);
                tmodelo.setPadding(3, 3, 3, 3);
                tprecio.setText(String.valueOf(obj.precio));
                tprecio.setPadding(3, 3, 3, 3);
                tutilidad.setText(String.valueOf(obj.calcularUtilidad()));
                tutilidad.setPadding(3, 3, 3, 3);
                row.addView(tmarca);
                row.addView(tmodelo);
                row.addView(tprecio);
                row.addView(tutilidad);
                tabla.addView(row,i);
            }
    }

    public void agregar(View d){
        int aux;
        obj = new TelefonoCelular();

        obj.modelo = txtModelo.getText().toString();
        obj.marca = txtMarca.getText().toString();
        obj.costo = Integer.parseInt(txtCosto.getText().toString());
        obj.calcularPrecio();

        celulares.add(obj);
        limpiar();
    }

    public void btnMostrar(View d){
        mostrar();

    }
}
