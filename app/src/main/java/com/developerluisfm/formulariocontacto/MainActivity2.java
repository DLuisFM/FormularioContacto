package com.developerluisfm.formulariocontacto;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tnombre, tfecha, ttelefono, tcorreo, tdescripcion;
    private Button editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);


        tnombre = (TextView) findViewById(R.id.tnombre);
        tfecha = (TextView) findViewById(R.id.tfecha);
        ttelefono = (TextView) findViewById(R.id.ttelefono);
        tcorreo = (TextView) findViewById(R.id.tcorreo);
        tdescripcion = (TextView) findViewById(R.id.tdescripcion);

        editar = (Button) findViewById(R.id.editar);


        final Intent intent = getIntent();
        if (null != intent) { //Null Checking
            tnombre.setText(intent.getStringExtra(getResources().getString(R.string.nombre)));
            tfecha.setText(getResources().getString(R.string.fecha)+": "+intent.getStringExtra(getResources().getString(R.string.fecha)));
            ttelefono.setText(getResources().getString(R.string.telefono)+": "+intent.getStringExtra(getResources().getString(R.string.telefono)));
            tcorreo.setText(getResources().getString(R.string.correo)+": "+intent.getStringExtra(getResources().getString(R.string.correo)));
            tdescripcion.setText(getResources().getString(R.string.descripcion)+": "+intent.getStringExtra(getResources().getString(R.string.descripcion)));

        }

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_new = new Intent(getBaseContext(), MainActivity.class);
                intent_new.putExtra(getResources().getString(R.string.nombre), intent.getStringExtra(getResources().getString(R.string.nombre)));
                intent_new.putExtra(getResources().getString(R.string.fecha), intent.getStringExtra(getResources().getString(R.string.fecha)));
                intent_new.putExtra(getResources().getString(R.string.telefono), intent.getStringExtra(getResources().getString(R.string.telefono)));
                intent_new.putExtra(getResources().getString(R.string.correo), intent.getStringExtra(getResources().getString(R.string.correo)));
                intent_new.putExtra(getResources().getString(R.string.descripcion), intent.getStringExtra(getResources().getString(R.string.descripcion)));
                startActivity(intent_new );
                finish();
            }
        });

    }
}
