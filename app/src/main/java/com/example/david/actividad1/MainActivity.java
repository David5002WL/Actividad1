package com.example.david.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private EditText ediNombre;

    TextView etiEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        ediNombre = (EditText) findViewById( R.id.edi_nombre );

        button.setOnClickListener(this);


        etiEdad = (TextView) findViewById( R.id.eti_Edad );

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoEdad=(String)extras.get("edad");//Obtengo la edad

            if(Integer.parseInt(datoEdad) >= 18 && Integer.parseInt(datoEdad) < 25){
                etiEdad.setText("Tienes "+datoEdad+" años. Eres mayor de edad.");
            }
            if(Integer.parseInt(datoEdad) >= 25 && Integer.parseInt(datoEdad) < 35){
                etiEdad.setText("Tienes "+datoEdad+" años. Estas en la flor de la vida.");
            }
            if(Integer.parseInt(datoEdad) >= 35){
                etiEdad.setText("Tienes "+datoEdad+" años. Ai...ai...ai.");
            }
            if(Integer.parseInt(datoEdad) < 18 ){
                etiEdad.setText("Tienes "+datoEdad+" años.");
            }
        }
    }


    public void onClick(View v) {

        Intent explicit_intent;//Declaro el Intent

        //Instanciamos el Intent dandole:
        // el contexto y la clase a la cual nos deseamos dirigir
        explicit_intent = new Intent(this,Main2Activity.class);
        String auxEdiNombre=ediNombre.getText().toString();

        explicit_intent.putExtra("nombre",auxEdiNombre);//Guardamos una cadena

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }

    public void onRadioButtonClicked(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        // hacemos un case con lo que ocurre cada vez que pulsemos un botón

        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    //
                    break;
            case R.id.radioButton2:
                if (checked)
                    //
                    break;
        }
    }
}
