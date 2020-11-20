package com.example.calculadorasencilla;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1= findViewById(R.id.txtNumeroUno);
        num2= findViewById(R.id.txtNumeroDos);
        resultado= findViewById(R.id.lblResultado);
    }

    public void calcular(View v){
        double n1, n2, suma;
        if (validar()) {
            n1 = Double.parseDouble(num1.getText().toString());
            n2 = Double.parseDouble(num2.getText().toString());
            suma = n1 + n2;
            resultado.setText("" + suma);
            //resultado.setText(String.valueOf(suma));
        }
    }

    public boolean validar(){
        if (num1.getText().toString().isEmpty()){
            num1.setError(getString(R.string.mensaje_error_numero_uno));
            num1.requestFocus();
            return false;
        }
        if (num2.getText().toString().isEmpty()){
            num2.setError(getString(R.string.mensaje_error_numero_dos));
            num1.requestFocus();
            return false;
        }

        return true;
    }
    public void limpiar(View v){
        num1.setText("");
        num2.setText("");
        resultado.setText("");
        num1.requestFocus();
    }
}