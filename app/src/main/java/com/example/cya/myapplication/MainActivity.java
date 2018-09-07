package com.example.cya.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
Neste projeto, temos a classe MainActivity.java como ACTIVITY1 e
Activity2 como sendo uma segunda Activity.

LÓGICA: O usuário digitará uma mensagem na primeira Activity. Quando
ele clicar em "OK", a primeira Activity chamará a segunda Activity, a qual
mostrará a mensagem digitada anteriormente.

O código encontra-se comentado para melhor estudo.
 */


public class MainActivity extends Activity {

    EditText caixaTexto; //criamos uma variável do tipo EditText

    /*
    Chamamos o método onCreate, ponto de partida de nossa aplicação.

    Note que o método onCreate recebe um parâmetro do tipo Bundle
    ele é responsável por guardar o estado da Activity quando ela é reiniciada,
    como se fosse um cache
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //configura o layout XML na nossa Activity

        /*
        findViewById busca e recupera as views dentro do layout que foi atribuído
        no setcontentview.
        No caso abaixo, estamos buscando o id texto1 (que referencia uma
        EditText e armazenando seu conteúdo em caixaTexto
         */
        caixaTexto = (EditText) findViewById(R.id.texto1);
    }

    /*
    "Proximo" é um método disparado pelo botão. Veja em activity_main.xml
    que existe um botão e, na ação onClick, há o método "Próximo"
     */
    public void Proximo(View view) {
        /*
            quando chamamos a Intent, dizemos ao SO do Android que temos
            a intenção de chamar outra activity
        */
        Intent it = new Intent(this, Activity2.class);

        /*
         Bundle guarda o estado de uma activity, então vamos criar
         um objeto do tipo Bundle
        */
        Bundle parametros = new Bundle();

        /*
        Agora vamos pegar o valor digitado na caixa de texto pelo usuário
        e colocar em uma string
         */
        String mm = caixaTexto.getText().toString();

        /*
            Nas duas linhas a seguir, nós pegamos o valor da string e
            armazenamos no bundle. Veja que em putString existem dois parâmetros:
            o primeiro é o identificador da string que estamos inserindo no
            bundle, e o segundo é o que desejamos inserir no bundle.
            Entenda o bundle como uma estrutura de dados tipo vetor. O primeiro
            parâmetro é o "indice" e o segundo atributo é o valor. podemos passar
            quantos valores desejarmos, dos tipos que desejarmos.
         */
        parametros.putString("idMsg", mm);
        /* parametros.putInt("codFuncionario", 123);
           parametros.putFloat("peso", 70.3);
           parametros.putBoolean("flag", true);*/

        /*após inserir todos os valores necessários, vamos passar o nosso objeto
          bundle como parâmetro na intent, utilizando o método putExtras()
        */
        it.putExtras(parametros);

        /*
        Por fim, chamamos a Activity2 com o método startActivity, passando
        a intent
         */
        startActivity(it);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){

    }

}
