package com.unama.gasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText modeloAutomovelWidget;
    private EditText distanciaWidget;
    private EditText potenciaWidget;
    private EditText valorGasolinaWidget;
    private Button buttonCalcularWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeloAutomovelWidget = findViewById(R.id.modeloAutomovel);
        distanciaWidget = findViewById(R.id.distancia);
        potenciaWidget = findViewById(R.id.potencia);
        valorGasolinaWidget = findViewById(R.id.valorGasolina);
        buttonCalcularWidget = findViewById(R.id.buttonCalcular);

        buttonCalcularWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modeloAutomovel = modeloAutomovelWidget.getText().toString();
                double distancia = Double.parseDouble(distanciaWidget.getText().toString());
                double potencia = Double.parseDouble(potenciaWidget.getText().toString());
                double valorGasolina = Double.parseDouble(valorGasolinaWidget.getText().toString());

                double multiplicador = 0.0;

                if (potencia <= 1.0) {
                    multiplicador = 13.0;
                } else if (potencia > 1.0 && potencia <= 1.4) {
                    multiplicador = 11.0;
                } else if (potencia > 1.4 && potencia <= 1.9) {
                    multiplicador = 9.5;
                } else if (potencia > 1.9) {
                    multiplicador = 7.75;
                }

                double litrosNecessarios = (distancia * 1) / multiplicador;
                double valorTotalGasolina = litrosNecessarios * valorGasolina;

                Intent i = new Intent(getApplicationContext(), ResultadoActivity.class);
                i.putExtra("modeloAutomovel", modeloAutomovel);
                i.putExtra("distancia", distancia);
                i.putExtra("potencia", potencia);
                i.putExtra("valorGasolina", valorGasolina);
                i.putExtra("valorTotalGasolina", valorTotalGasolina);
                startActivity(i);
            }
        });
    }

}
