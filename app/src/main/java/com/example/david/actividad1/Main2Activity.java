package com.example.david.actividad1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button button3;
    private EditText ediEdad;

    TextView etiNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etiNombre = (TextView) findViewById( R.id.eti_Nombre );

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre

            etiNombre.setText("Hola "+datoNombre+", indica el siguiente dato:");

        }

        button3=(Button)findViewById(R.id.button3);
        ediEdad = (EditText) findViewById( R.id.edi_Edad );

        button3.setOnClickListener(this);
    }

    public void onClick(View v) {

        Intent explicit_intent;//Declaro el Intent

        //Instanciamos el Intent dandole:
        // el contexto y la clase a la cual nos deseamos dirigir
        explicit_intent = new Intent(this,MainActivity.class);
        String auxEdiEdad=ediEdad.getText().toString();

        explicit_intent.putExtra("edad",auxEdiEdad);//Guardamos una cadena

        //lo iniciamos pasandole la intencion, con todos sus parametros guardados
        startActivity(explicit_intent);
    }

}
