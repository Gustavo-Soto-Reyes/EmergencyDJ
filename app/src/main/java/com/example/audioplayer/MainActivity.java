package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    private int[] musicResources = {R.raw.music, R.raw.dance, R.raw.dance2};
    private Button[] buttons;
    private int[] soundResources = {
            R.raw.horn,
            R.raw.beep, R.raw.explosion, R.raw.scream,
            R.raw.siren, R.raw.wow
    };
    private MediaPlayer[] soundPlayers;
    private MediaPlayer audioPlayer;

    int currentTrack = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[]{
                findViewById(R.id.button2),
                findViewById(R.id.button3), findViewById(R.id.button4),
                findViewById(R.id.button5), findViewById(R.id.button6),
                findViewById(R.id.button7)
        };

        soundPlayers = new MediaPlayer[buttons.length];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(view -> {
                int buttonIndex = getButtonIndex(view);
                playSound(soundResources[buttonIndex], buttonIndex);
            });
        }
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            if (audioPlayer != null){
                audioPlayer.release();
            }
            audioPlayer = MediaPlayer.create(getApplicationContext(), musicResources[currentTrack]);
            audioPlayer.start();

            currentTrack = (currentTrack+1)%3;
        });
    }
    private int getButtonIndex(View view) {
        for (int i = 0; i < buttons.length; i++) {
            if (view.getId() == buttons[i].getId()) {
                return i;
            }
        }
        return -1;
    }
    private void playSound(int soundResource, int mediaPlayerIndex) {
        stopMedia(mediaPlayerIndex);

        soundPlayers[mediaPlayerIndex] = MediaPlayer.create(this, soundResource);
        soundPlayers[mediaPlayerIndex].start();
    }

    private void stopMedia(int mediaPlayerIndex) {
        if (soundPlayers[mediaPlayerIndex] != null) {
            soundPlayers[mediaPlayerIndex].stop();
            soundPlayers[mediaPlayerIndex].release();
            soundPlayers[mediaPlayerIndex] = null;
        }
    }
}