package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Jorge Ballesteros
 */
public class MainActivity extends AppCompatActivity {
    operacion op;
    int puntos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView etNumero1 = findViewById(R.id.tvNumero1);
        TextView etNumero2 = findViewById(R.id.tvNumero2);
        TextView signo = findViewById(R.id.signo);
        TextView correccion = findViewById(R.id.correccion);
        TextView puntuacion = findViewById(R.id.marcador);

        EditText etResultado = findViewById(R.id.etResultado);

        Button btnjugar = findViewById(R.id.btnJugar);
        Button enviar = findViewById(R.id.btnEnviar);

        Spinner spn = findViewById(R.id.niveles);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                op = new operacion(spn.getSelectedItemPosition());

                Log.d("mensaje", op.toString());
                Log.d("mensaje", String.valueOf(spn.getSelectedItemPosition()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnjugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = new operacion(spn.getSelectedItemPosition());
                etNumero1.setText(String.valueOf(op.getNumero1()));
                etNumero2.setText(String.valueOf(op.getNumero2()));
                signo.setText(String.valueOf(op.getSimbolo()));
                etResultado.setText("");
                correccion.setText("");
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(etResultado.getText()))==op.getResultado()){
                    correccion.setText("Correcto");
                    puntos++;
                    puntuacion.setText(String.valueOf(puntos));
                    op = new operacion(spn.getSelectedItemPosition());
                    etNumero1.setText(String.valueOf(op.getNumero1()));
                    etNumero2.setText(String.valueOf(op.getNumero2()));
                    signo.setText(String.valueOf(op.getSimbolo()));
                }else
                    correccion.setText("Incorrecto");
                    etResultado.setText("");
            }
        });

    }
}