package com.desarrollo.pacticadirigidamusicaonlineaquino;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.desarrollo.pacticadirigidamusicaonlineaquino.MainActivity.musicFiles;

public class PlayerActivity extends AppCompatActivity {
TextView song_name,artist_name,duration_played,duration_total;
ImageView cover_art,nextbtn,prevbtn,backbtn,shuffbtn,repeatbtn;
FloatingActionButton playpausebtn;
SeekBar seekBar;
int position=-1;
static ArrayList<MusicFiles> listSongs =new ArrayList<>();
static Uri uri;
static MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initViews();
        getIntenthod();
    }

    private void getIntenthod() {
    position=getIntent().getIntExtra("position",-1);
    listSongs=musicFiles;
    if (listSongs !=null){
        playpausebtn.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
        uri=Uri.parse(listSongs.get(position).getPath());
     }
    if(mediaPlayer !=null){
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);
        mediaPlayer.start();

    }
    else {
        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);
        mediaPlayer.start();
    }

    }

    private void initViews() {
        song_name=findViewById(R.id.song_name);
        artist_name=findViewById(R.id.song_name);
        duration_played=findViewById(R.id.durationplayed);
        duration_total=findViewById(R.id.durationtotal);
        cover_art=findViewById(R.id.cover_art);
        nextbtn=findViewById(R.id.id_next);
        prevbtn=findViewById(R.id.id_prev);
        backbtn=findViewById(R.id.back_btn);
        shuffbtn=findViewById(R.id.id_shuffle);
        repeatbtn=findViewById(R.id.id_repeat);
        playpausebtn=findViewById(R.id.play_pause);
       seekBar=findViewById(R.id.seekbar);

    }
}