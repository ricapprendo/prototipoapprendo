package com.apprendo.apprendodemo1;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import com.apprendo.apprendodemo1.data.Dinamica;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
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
        LinearLayout listadirigido = findViewById(R.id.listaDirigido);
        for(int i=0;i<objDinamica.dirigidoa.length;i++) {
            String strEje = objDinamica.dirigidoa[i];
            TextView txtEje = new TextView(this,null,0,R.style.pillTag);
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(5,5,5,5);
            txtEje.setLayoutParams(params);
            txtEje.setText(strEje);
            listadirigido.addView(txtEje);
        }
        LinearLayout listaejes = findViewById(R.id.listaEjes);
        for(int i=0;i<objDinamica.ejetematico.length;i++) {
            String strEje = objDinamica.ejetematico[i];
            TextView txtEje = new TextView(this,null,0,R.style.pillTag);
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(5,5,5,5);
            txtEje.setLayoutParams(params);
            txtEje.setText(strEje);
            listaejes.addView(txtEje);
        }
        //txtDirigidoa.setText();
        LinearLayout listaRecursos = findViewById(R.id.listaRecursos);
        for(int i=0;i<objDinamica.recursos.length;i++) {
            String strEje = objDinamica.recursos[i];
            TextView txtEje = new TextView(this,null,0,R.style.pillTag);
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(5,5,5,5);
            txtEje.setLayoutParams(params);
            txtEje.setText(strEje);
            listaRecursos.addView(txtEje);
        }
        TextView txtTiempo = findViewById(R.id.txtTiempo);
        txtTiempo.setText(objDinamica.tiempo);
        /*TextView txtEje = findViewById(R.id.txtEje);
        txtEje.setText(objDinamica.ejetematico);*/


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
