package com.example.imene.devoir_tp_apps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
private Button button1, button2,button3;
private TextView textView;
private SqlLite a;
private ConstraintLayout constraintLayout;
public static int globalPage = 0;
String[] list_text;
int[] list_bg;
//private int position = 1;

    @SuppressLint("Recycle")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        a = new SqlLite( this );
        getSupportActionBar().hide();


        //SqlLite mydatabase = new
               // SqlLite(this, 1);
        //SqlLite histoire1 = new SqlLite(this, 1);

        button1 = findViewById( R.id.imageButton1 );
        button2 = findViewById( R.id.imageButton2 );
        button3 = findViewById( R.id.button3 );
        textView = findViewById( R.id.history );
        constraintLayout = findViewById( R.id.cosHis );
        Intent i = getIntent();

        if(i != null){

            String str ="";
            if (i.hasExtra("id")){

                int id = Integer.parseInt(i.getStringExtra("id")) + 1;

                SQLiteDatabase db = openOrCreateDatabase("histoire.db", MODE_PRIVATE, null);


                Cursor cursor = db.rawQuery("SELECT culumn_image FROM Page WHERE id_his=" + id + ";", null);

                cursor.moveToFirst();

                cursor = db.rawQuery("SELECT COUNT(culumn_image) FROM Page WHERE id_his=" + id + " ORDER BY id_his ASC;", null);

                cursor.moveToFirst();
                int leng = cursor.getInt(cursor.getColumnIndex("COUNT(culumn_image)"));
                list_text = new String[leng];
                list_bg =  new int[leng];
                cursor = db.rawQuery("SELECT getCulumn_his,culumn_image FROM Page WHERE id_his=" + id + " ORDER BY id_his ASC;", null);
                cursor.moveToFirst();
                int k = 0;

                do {
                    int bg = cursor.getInt(cursor.getColumnIndex("culumn_image"));
                    String textPage = cursor.getString(cursor.getColumnIndex("getCulumn_his"));
                    list_text[k] = "" + textPage;
                    list_bg[k] = bg;
                    k++;
                } while (cursor.moveToNext());

                cursor.close();
                db.close();
                constraintLayout.setBackgroundResource(list_bg[0]);

                textView.setText( list_text[0] );
                //textView.setText( list_text[0] );
                globalPage = 0;

            }}

            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (globalPage>=0){
                        globalPage--;
                        textView.setText(""+list_text[globalPage]);
                        constraintLayout.setBackgroundResource(list_bg[globalPage]);}
                    if (globalPage<list_text.length){// tant que ce n'est pas la dernière page, le bouton next sera visible
                        button2.setVisibility(View.VISIBLE);
                    }
                    if (globalPage==0){// tant qu'on est dans la première page, le boutton previous sera invisible
                        button1.setVisibility(View.INVISIBLE);
                    }
                }
            } );
            button1.setVisibility(View.INVISIBLE);

            button2.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (globalPage<list_text.length){
                        globalPage++;
                        textView.setText(""+list_text[globalPage]);
                        constraintLayout.setBackgroundResource(list_bg[globalPage]);}
                    if (globalPage==list_text.length-1){// c'est la dernière page, on cache le boutton next
                        button2.setVisibility(View.INVISIBLE);
                    }
                    if (globalPage!=0){// tant que ce n'est pas la dernière page
                        button1.setVisibility(View.VISIBLE);
                    }

                }
            } );
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.VISIBLE);
                return false;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.VISIBLE);
                button3.setVisibility(View.INVISIBLE);
            }
        });
        button3.setVisibility(View.INVISIBLE);
        }



    }

