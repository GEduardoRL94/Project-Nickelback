package com.isil.proyecto_ver01;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class SoundActivity extends Activity implements Runnable {

    private ImageButton startButton;
    private ImageButton stopButton;
    private ImageButton pauseButton;
    private Button videoButton;
    private MediaPlayer soundPlayer;
    private SeekBar soundSeekBar;
    private Thread soundThread;
    TextView txvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        asignarReferencias();
        String nombre = getIntent().getExtras().getString("nombre");
        txvNombre.setText(nombre);

        soundPlayer = MediaPlayer.create(this.getBaseContext(), R.raw.if_today_was_your_last_day);

        setupListener();

        soundThread = new Thread(this);
        soundThread.start();

    }

    public void asignarReferencias(){

        startButton = (ImageButton)findViewById(R.id.playButton);
        stopButton = (ImageButton)findViewById(R.id.stopButton);
        pauseButton = (ImageButton)findViewById(R.id.pauseButton);
        soundSeekBar = (SeekBar)findViewById(R.id.soundSeekBar);

        txvNombre = (TextView)findViewById(R.id.txvNombre);

    }

    private void setupListener(){

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPlayer.start();

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPlayer.pause();

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                soundPlayer.stop();
                soundPlayer = MediaPlayer.create(getBaseContext(), R.raw.if_today_was_your_last_day);

            }
        });

        soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(fromUser){

                    soundPlayer.seekTo(progress);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void run() {

        int currentPosition = 0;
        int soundTotal = soundPlayer.getDuration();
        soundSeekBar.setMax(soundTotal);

        while(soundPlayer != null && currentPosition < soundTotal){

            try {

                Thread.sleep(300);
                currentPosition = soundPlayer.getCurrentPosition();

            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (Exception e) {

                e.printStackTrace();

            }

            soundSeekBar.setProgress(currentPosition);

        }

    }
}


