package com.desarrollo.pacticadirigidamusicaonlineaquino;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button play_pause;
   Button  btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp [] = new MediaPlayer [3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.i);
        vectormp[1] = MediaPlayer.create(this, R.raw.m);
        vectormp[2] = MediaPlayer.create(this, R.raw.o);

    }


    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_circle_filled_24);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para el botón Stop
    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp[0] = MediaPlayer.create(this, R.raw.i);
            vectormp[1] = MediaPlayer.create(this, R.raw.m);
            vectormp[2] = MediaPlayer.create(this, R.raw.o);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
            iv.setImageResource(R.drawable.uno);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.ic_baseline_chevron_left_24);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;
        } else {
            btn_repetir.setBackgroundResource(R.drawable.ic_baseline_repeat_24);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    public void Siguiente(View view){
        if(posicion < vectormp.length -1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if(posicion == 0){
                    iv.setImageResource(R.drawable.uno);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.uno);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.uno);
                }

            } else {
                posicion++;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.uno);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.uno);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.uno);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para regresar a la canción anterior
    public void Anterior(View view){
        if(posicion >= 1){

            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.i);
                vectormp[1] = MediaPlayer.create(this, R.raw.m);
                vectormp[2] = MediaPlayer.create(this, R.raw.o);

                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.uno);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.uno);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.uno);
                }

                vectormp[posicion].start();

            } else {
                posicion--;

                if(posicion == 0){
                    iv.setImageResource(R.drawable.uno);
                } else if(posicion == 1){
                    iv.setImageResource(R.drawable.uno);
                }else if(posicion == 2){
                    iv.setImageResource(R.drawable.uno);
                }
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }

}