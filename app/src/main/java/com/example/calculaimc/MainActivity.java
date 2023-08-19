package com.example.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        limpar = findViewById(R.id.limpar);
        resultado = findViewById(R.id.resultado);
        limpar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Limpa os componentes", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public void calcularOnClick(View v) {
        if (peso.getText().toString().equals("")) {
            peso.setError("Campo deve ser preenchido");
            peso.requestFocus();
            return;
        }

        if (altura.getText().toString().equals("")) {
            altura.setError("Campo deve ser preenchido");
            altura.requestFocus();
            return;
        }
        double numPeso = Double.parseDouble(peso.getText().toString());
        double numAltura = Double.parseDouble(altura.getText().toString());

        double numImc = numPeso / Math.pow(numAltura, 2);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        resultado.setText(decimalFormat.format(numImc));
    }

    public void limparOnClick(View v) {
        resultado.setText("0");
        peso.setText("");
        altura.setText("");
        peso.requestFocus();
    }
}