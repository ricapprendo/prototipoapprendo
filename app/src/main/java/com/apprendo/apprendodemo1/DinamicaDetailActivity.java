package com.apprendo.apprendodemo1;

import android.content.Intent;
import android.os.Bundle;

import com.apprendo.apprendodemo1.data.Dinamica;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class DinamicaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamica_detail);

        Bundle data = getIntent().getExtras();
        final Dinamica objDinamica = (Dinamica)data.getParcelable("objActividad");

        TextView txtDescripcion = findViewById(R.id.txtDescripcion);
        txtDescripcion.setText(objDinamica.descripcion);
        TextView txtObjetivos = findViewById(R.id.txtObjetivos);
        txtObjetivos.setText(objDinamica.objetivos);
        TextView txtDirigidoa = findViewById(R.id.txtDirigidoa);
        txtDirigidoa.setText(objDinamica.dirigidoa);
        TextView txtRecursos = findViewById(R.id.txtRecursos);
        txtRecursos.setText(objDinamica.recursos);
        TextView txtTiempo = findViewById(R.id.txtTiempo);
        txtTiempo.setText(objDinamica.tiempo);
        TextView txtEje = findViewById(R.id.txtEje);
        txtEje.setText(objDinamica.ejetematico);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(objDinamica.titulo);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent juego = new Intent(view.getContext(),JuegoActivity.class);
                juego.putExtra("urlJuego",objDinamica.source);
                startActivity(juego);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
