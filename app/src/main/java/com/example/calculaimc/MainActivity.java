package com.example.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText peso, altura;
    private Button calcular, limpar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        calcular = findViewById(R.id.calcular);
        limpar = findViewById(R.id.limpar);
        resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double numPeso = Double.parseDouble(peso.getText().toString());
                double numAltura = Double.parseDouble(altura.getText().toString());

                double numImc = numPeso / Math.pow(numAltura, 2);

                DecimalFormat decimalFormat = new DecimalFormat("0.00");

                resultado.setText(decimalFormat.format(numImc));
            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("0");
                peso.setText("");
                altura.setText("");
                peso.requestFocus();
            }
        });
    }
}