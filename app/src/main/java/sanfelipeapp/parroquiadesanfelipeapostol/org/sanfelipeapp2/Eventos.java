package sanfelipeapp.parroquiadesanfelipeapostol.org.sanfelipeapp2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Eventos extends AppCompatActivity {

    SQLiteDatabase db;
    ListView lista;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_eventos);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            MySQLiteHelper db = new MySQLiteHelper(this);
            List<Evento> lEventos = db.getAllEventos();

            lista = (ListView) findViewById(R.id.listaNotificaciones);
            //Inicializar el adaptador con la fuente de datos
            adaptador = new EventoArrayAdapter(this, lEventos);
            //Relacionando la lista con el adaptador
            lista.setAdapter(adaptador);
        }catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
