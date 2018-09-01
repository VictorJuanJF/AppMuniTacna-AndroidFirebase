package com.example.jimenez.appmunitacna;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.jimenez.appmunitacna.objects.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements onItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;
    //App brus


    private categoriaAdapter adapter;
    List<Categoria> categorias = new ArrayList<>();

    public static final Categoria sCategoria=new Categoria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configToolbar();
        configAdapter();
        configRecyclerView();
        generateCategoria();



    }


    private void generateCategoria() {
        Categoria arrayCategoria[]=new Categoria[5];
        arrayCategoria[0]=new Categoria("Parques y Jardines","Pistas 1",R.drawable.ic_arboles);
        arrayCategoria[1]=new Categoria("Pistas y Veredas","Pistas 1",R.drawable.ic_pista);
        arrayCategoria[2]=new Categoria("Seguridad","Pistas 1",R.drawable.ic_seguridad);
        arrayCategoria[3]=new Categoria("Transporte Público","Pistas 1",R.drawable.ic_autobu);
        arrayCategoria[4]=new Categoria("Limpieza Pública","Pistas 1",R.drawable.ic_limpieza);

        for (int i=0;i<arrayCategoria.length;i++) {
            adapter.add(arrayCategoria[i]);
        }


    }

    private void configRecyclerView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    private void configAdapter() {
        adapter = new categoriaAdapter(categorias, this);
    }

    private void configToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /************
     * Metodos implementados por la interfaz OnItemClickListener*************/

    @Override
    public void onItemClick(Categoria categoria) {
        sCategoria.setNombre(categoria.getNombre());
        Intent intent=new Intent(MainActivity.this,MandarReporteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLongItemClick(Categoria categoria) {

    }


}

/***************************************************************************/
