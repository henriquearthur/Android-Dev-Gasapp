package com.unama.gasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private TextView resultadoWidget;
    private Button buttonCompartilharWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //setTitle("Resultado");

        resultadoWidget = findViewById(R.id.resultado);
        buttonCompartilharWidget = findViewById(R.id.buttonCompartilhar);

        // Mostrar resultado
        Bundle dados = getIntent().getExtras();
        String modeloAutomovel = dados.getString("modeloAutomovel");
        double distancia = dados.getDouble("distancia");
        double potencia = dados.getDouble("potencia");
        double valorGasolina = dados.getDouble("valorGasolina");
        double valorTotalGasolina = dados.getDouble("valorTotalGasolina");

        resultadoWidget.setText(modeloAutomovel + " " + potencia + " gasta R$ " + valorTotalGasolina + " para percorrer " + distancia + "km pagando gasolina a R$ " + valorGasolina + " por litro.");

        // Compartilhar
        buttonCompartilharWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                startActivity( Intent.createChooser( i, "Compartilhar" ) );
            }
        });
    }
}
