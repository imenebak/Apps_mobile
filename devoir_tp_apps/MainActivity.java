package com.example.imene.devoir_tp_apps;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    ListView list;
    SqlLite sqlLite;
    String[] TitreHistoire={"Blanche Neige", "Hansel et Gretel","chat botté", "Le roi grenouille" };
    String[] Auteur={"Frères Grimm", "Frère Grimm", "Charles Perrault", "Frère Grimm"};
    String[] nb = {"2", "3", "6", "5"};
    int[] Images={R.drawable.his1, R.drawable.his2, R.drawable.his3, R.drawable.his4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        sqlLite = new SqlLite(this);

        sqlLite.insertAll();

        list= findViewById( R.id.listPrincipal );
        CustomerList c= new CustomerList( this, TitreHistoire, Auteur, Images, nb );
        list.setAdapter( c );


        list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                intent.putExtra("id", ""+i);
                startActivity(intent);

            }
        } );
    }
}
