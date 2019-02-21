package com.example.lucas.ejercicio_lab3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lucas.ejercicio_lab3.R;
import com.example.lucas.ejercicio_lab3.adapter.MyAdapter;
import com.example.lucas.ejercicio_lab3.modelo.Frutas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Frutas> frutas;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frutas = this.getAllFrutas();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        adapter = new MyAdapter(frutas, R.layout.recicler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Frutas fruta , int position) {
                //Toast.makeText(MainActivity.this, name + " - " + position, Toast.LENGTH_LONG).show();
            eliminar(position);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meni_item, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_name:
                this.addFruta(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Frutas> getAllFrutas() {
        return new ArrayList<Frutas>() {{
            add(new Frutas("Orange", "Orange description", R.drawable.orange_bg, R.mipmap.ic_naranja, 0));
            add(new Frutas("Apple", "Apple description", R.drawable.apple_bg, R.mipmap.ic_manzana, 0));
            add(new Frutas("Banana", "Banana description", R.drawable.banana_bg, R.mipmap.ic_banana, 0));

        }};
    }
    private void addFruta(int position) {
        frutas.add(position, new Frutas("nueva", "cualquiera", R.drawable.cherry_bg, R.mipmap.ic_naranja,0) );
        // Notificamos de un nuevo item insertado en nuestra colección
        adapter.notifyItemInserted(position);
        // Hacemos scroll hacia lo posición donde el nuevo elemento se aloja
        mLayoutManager.scrollToPosition(position);
    }

    private void eliminar (int position){
        frutas.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
