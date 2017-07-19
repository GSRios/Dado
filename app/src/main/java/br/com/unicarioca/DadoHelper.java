package br.com.unicarioca;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DadoHelper {

    public static Integer CONTADOR = 0;

    public static void alteraPontos(int pts, String primeiraVez, MainActivity activity){
        ImageView imagem = null;
        if("S".equals(primeiraVez)){
            imagem =  (ImageView) activity.findViewById(R.id.dado1);
        }else{
            imagem =  (ImageView) activity.findViewById(R.id.dado2);
        }
        switch (pts){
            case 1:
                imagem.setImageResource(R.drawable.um);
                break;
            case 2:
                imagem.setImageResource(R.drawable.dois);
                break;
            case 3:
                imagem.setImageResource(R.drawable.tres);
                break;
            case 4:
                imagem.setImageResource(R.drawable.quatro);
                break;
            case 5:
                imagem.setImageResource(R.drawable.cinco);
                break;
            case 6:
                imagem.setImageResource(R.drawable.seis);
                break;
        }
    }
    public static void geraResultado(MainActivity activity){
        TextView pontosPlayer1 = (TextView) activity.findViewById(R.id.pontos_jogador1);
        TextView pontosPlayer2 = (TextView) activity.findViewById(R.id.pontos_jogador2);

        try {
            String resultado = "";
            if (Integer.parseInt(pontosPlayer1.getText().toString()) > Integer.parseInt(pontosPlayer2.getText().toString())) {
                resultado = "O vencedor foi o Player 1";
            } else if (Integer.parseInt(pontosPlayer1.getText().toString()) < Integer.parseInt(pontosPlayer2.getText().toString())) {
                resultado=  "O vencedor foi o Player 2";
            } else {
                resultado = "Empate!!!";
            }

            Toast.makeText(activity, resultado, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(activity, "Ocorreu um erro!!", Toast.LENGTH_SHORT).show();

        }
    }

    public static void putPontos(MainActivity activity, int pontos){

        switch(CONTADOR.intValue()){
            case 0:
                TextView textoPlayer1 = (TextView) activity.findViewById(R.id.jogador1);
                TextView pontosPlayer1 = (TextView) activity.findViewById(R.id.pontos_jogador1);
                textoPlayer1.setText("Player 1 está com " + pontos + " pontos");
                pontosPlayer1.setText(String.valueOf(pontos));
                CONTADOR++;
                break;
            case 1:
                TextView textoPlayer2 = (TextView) activity.findViewById(R.id.jogador2);
                TextView pontosPlayer2 = (TextView) activity.findViewById(R.id.pontos_jogador2);
                textoPlayer2.setText("Player 2 está com " + pontos + " pontos");
                pontosPlayer2.setText(String.valueOf(pontos));
                geraResultado(activity);
                CONTADOR++;
                break;
            default: break;
        }
    }

    public static void reinicia(MainActivity activity){
        ImageView imagem = null;
        imagem =  (ImageView) activity.findViewById(R.id.dado1);
        imagem.setImageResource(R.drawable.cubos);
        imagem =  (ImageView) activity.findViewById(R.id.dado2);
        imagem.setImageResource(R.drawable.cubos);

        TextView textoPlayer1 = (TextView) activity.findViewById(R.id.jogador1);
        TextView pontosPlayer1 = (TextView) activity.findViewById(R.id.pontos_jogador1);
        textoPlayer1.setText("Player 1 ainda não jogou");
        pontosPlayer1.setText("0");

        TextView textoPlayer2 = (TextView) activity.findViewById(R.id.jogador2);
        TextView pontosPlayer2 = (TextView) activity.findViewById(R.id.pontos_jogador2);
        textoPlayer2.setText("Player 2 ainda não jogou");
        pontosPlayer2.setText(String.valueOf("0"));
        CONTADOR = 0;
    }
}
