package com.example.cya.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //esta é uma textview da segunda activity
        t1 = (TextView) findViewById(R.id.txt1);

        //criaremos uma intent que recebe a intent da activity que a invocou
        Intent it = getIntent();

        /*criamos um objeto do tipo bundle que vai receber o bundle presente
        na intent*/
        Bundle b = it.getExtras();

        /* Agora receberemos os valores do bundle  */
        String mensagem = b.getString("idMsg"); //receberá o conteúdo referente ao id idMsg

        //mostra a mensagem no textview t1
        t1.setText(mensagem);

        //finish();

    }
}
