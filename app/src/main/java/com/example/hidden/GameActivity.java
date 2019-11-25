package com.example.hidden;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int score;
    private int level;
    private float time;
    private CountDownTimer countDownTimer;
    private long timeInterval;
    private TextView timeTextView;
    private TextView levelTextView;
    private TextView scoreTextView;
    private ImageView image;
    private RelativeLayout choice1;
    private RelativeLayout choice2;
    private TextView choice1TextView;
    private TextView choice2TextView;
    private int time2;
    private ArrayList<Game> gameArrayList = Game.createGame();
    private Game game;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Objects.requireNonNull(getSupportActionBar()).hide();
        timeInterval = 5000;
        time2 = 5;
        level = 1;
        score = 0;
        user = new Database(this).getUserById(getIntent().getLongExtra("id", 0));
        setUI();
        startTime();
        setOnClick();
        setGame();
    }

    private void setUI() {
        image = (ImageView) findViewById(R.id.image);
        levelTextView = (TextView) findViewById(R.id.level);
        scoreTextView = (TextView) findViewById(R.id.score);
        timeTextView = (TextView) findViewById(R.id.time);
        scoreTextView.setText(String.valueOf(0));
        levelTextView.setText(String.valueOf(level));
        choice1TextView = (TextView) findViewById(R.id.choice);
        choice2TextView = (TextView) findViewById(R.id.choice2);
        choice1 = (RelativeLayout) findViewById(R.id.choiceButton);
        choice2 = (RelativeLayout) findViewById(R.id.choiceButton2);
    }

    private void startTime() {
        if (level < 10) {
            timeInterval = 5000;
            time2 = 5;
        }
        if (level > 10) {
            timeInterval = 3000;
            time2 = 3;
        }
        if (level > 15) {
            timeInterval = 2000;
            time2 = 2;
        }
        if (level > 20) {
            timeInterval = 1000;
            time2 = 1;
        }
        countDownTimer = new CountDownTimer(timeInterval, 1000) {
            public void onTick(long millisUntilFinished) {
                timeTextView.setText(String.valueOf(time2));
                time2 = (time2 - 1);
            }

            public void onFinish() {
                timeTextView.setText(String.valueOf(0));
                endGame();
            }
        }.start();
    }

    private void endGame() {
        user.setScore(score);
        new Database(this).updateScore(user);
        countDownTimer.cancel();
        finish();
        startActivity(new Intent(this, UserListShow.class));
    }

    private void setOnClick() {
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game.getAnswer().equalsIgnoreCase(choice1TextView.getText().toString())) {
                    nextLevel();
                } else {
                    endGame();
                }
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (game.getAnswer().equalsIgnoreCase(choice2TextView.getText().toString())) {
                    nextLevel();
                } else {
                    endGame();
                }
            }
        });
    }

    private void nextLevel() {
        level++;
        countDownTimer.cancel();
        if (level == gameArrayList.size()) {
            endGame();
        }
        setGame();
        score = level * time2;
        scoreTextView.setText(String.valueOf(score));
        levelTextView.setText(String.valueOf(level));
        startTime();
    }

    private void setGame() {
        int rand = new Random().nextInt(2);
        game = gameArrayList.get(level - 1);
        image.setImageDrawable(ContextCompat.getDrawable(this, game.getImage()));
        if (rand == 0) {
            int randChoice = new Random().nextInt(game.getChoice().length);
            choice1TextView.setText(game.getAnswer());
            choice2TextView.setText(game.getChoice()[randChoice]);
        } else {
            int randChoice = new Random().nextInt(game.getChoice().length);
            choice1TextView.setText(game.getChoice()[randChoice]);
            choice2TextView.setText(game.getAnswer());
        }
    }
}
