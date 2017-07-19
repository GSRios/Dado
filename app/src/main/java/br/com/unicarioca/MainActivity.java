package br.com.unicarioca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.jogar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motor();
            }
        });

        Button restartBt = (Button) findViewById(R.id.restart);
        restartBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DadoHelper.reinicia(MainActivity.this);
            }
        });

    }

    private void motor() {
        Calendar c = Calendar.getInstance();
        Random r = new Random(c.get(Calendar.MILLISECOND));
        int d1 = r.nextInt(7 - 1) + 1;
        DadoHelper.alteraPontos(d1, "S", this);
        int d2 = r.nextInt(7 - 1) + 1;
        DadoHelper.alteraPontos(d2, "N", this);
        DadoHelper.putPontos(this, d1+d2);

    }
}
