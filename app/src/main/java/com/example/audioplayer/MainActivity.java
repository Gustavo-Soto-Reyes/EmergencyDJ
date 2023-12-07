package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3, button4, button5, button6, button7 ;
    int[] samples = {R.raw.music, R.raw.dance, R.raw.dance2};
    int currentTrack = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaySounds(samples[currentTrack]);
                currentTrack = (currentTrack+1)%3;
            }
        });

    }

    @Override
    public void onClick(View view) {
        int clickedButton = view.getId();
        if (clickedButton == R.id.button1){
            PlaySounds(R.raw.music);
        }
        if (clickedButton == R.id.button2){
            PlaySounds(R.raw.horn);
        }

        if (clickedButton == R.id.button3){
            PlaySounds(R.raw.beep);
        }
        if (clickedButton == R.id.button4){
            PlaySounds(R.raw.explosion);
        }

        if (clickedButton == R.id.button5){
            PlaySounds(R.raw.scream);
        }

        if (clickedButton == R.id.button6){
            PlaySounds(R.raw.siren);
        }

        if (clickedButton == R.id.button7){
            PlaySounds(R.raw.wow);
        }
    }

    public void PlaySounds(int id){
        MediaPlayer mediaPlayer =  MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}