package com.example.imene.devoir_tp_apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_splash_screen );
        getSupportActionBar().hide();
        Splash s = new Splash();
        s.start();
    }
    private  class Splash extends Thread{
    public void run(){
        try{
            sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Intent in = new Intent(SplashScreen.this, MainActivity.class);
        startActivity( in );
        SplashScreen.this.finish();
    }
    }
}
