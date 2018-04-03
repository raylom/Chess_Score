package com.example.android.courtcounter;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * The code below sets scoreTeamA and team_b_score as global variable
     *
     */
    int scoreTeamA = 0;
    int team_b_score = 0;



    /**
     * The code below sets the  Team A timer as a global variable
     *
     */
    private static final long START_TIME_IN_MILLIS_A = 600000;

    private TextView mTextViewCountDown_A;
    private Button mButtonStartPause_A;
    private Button mButtonReset_A;
    private CountDownTimer mCountDownTimer_A;
    private boolean mTimerRunning_A;
    private long mTimeLeftInMillis_A = START_TIME_IN_MILLIS_A;




    /**
     * The code below sets the  Team B timer as a global variable
     *
     */

    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Variables for Team A Timer
        mTextViewCountDown_A = findViewById(R.id.text_view_countdown_A);

        mButtonStartPause_A = findViewById(R.id.button_start_pause_A);

        mButtonReset_A = findViewById(R.id.button_reset_A);

        mButtonStartPause_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning_A){
                    pauseTimer_A();
                } else{
                    startTimer_A();
                }
            }
        });


        mButtonReset_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer_A();
            }
        });
        updateCountDownText_A();


        //Variables for Team B timer

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);

        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning){
                    pauseTimer();
                } else{
                    startTimer();
                }
            }
        });


        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

//Methods for Team A timer



    private  void startTimer_A(){
        mCountDownTimer_A = new CountDownTimer(mTimeLeftInMillis_A, 1000) {
            @Override
            public void onTick(long millisUntilFinished_A) {
                mTimeLeftInMillis_A = millisUntilFinished_A;
                updateCountDownText_A()
                ;
            }

            @Override
            public void onFinish() {
                mTimerRunning_A = false;
                mButtonStartPause_A.setText("Start");
                mButtonStartPause_A.setVisibility(View.INVISIBLE);
                mButtonReset_A.setVisibility(View.VISIBLE);
            }


        } .start();

        mTimerRunning_A = true;
        mButtonStartPause_A.setText("pause");
        mButtonReset_A.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer_A() {
        mCountDownTimer_A.cancel();
        mTimerRunning_A = false;
        mButtonStartPause_A.setText("Start");
        mButtonReset_A.setVisibility(View.VISIBLE);
    }

    private void resetTimer_A() {
        mTimeLeftInMillis_A = START_TIME_IN_MILLIS_A;
        updateCountDownText_A();
        mButtonReset_A.setVisibility(View.INVISIBLE);
        mButtonStartPause_A.setVisibility(View.VISIBLE);

    }

    private void updateCountDownText_A(){
        int minutes = (int) (mTimeLeftInMillis_A / 1000) /60;
        int seconds = (int) (mTimeLeftInMillis_A/1000) % 60;

        String timeLeftFormatted_A = String.format("%02d:%02d", minutes, seconds);

        mTextViewCountDown_A.setText(timeLeftFormatted_A);

    }








    //Methods for Team B timer



    private  void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText()
;
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);

            }
        } .start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);

    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) /60;
        int seconds = (int) (mTimeLeftInMillis/1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);

    }
    /**
     *
     * These four methods display score based on button pressed for Team A
     */

    public void addNineForTeamA(View view) {
        scoreTeamA = scoreTeamA + 9;
        displayForTeamA(scoreTeamA);

    }

    public void addFiveForTeamA(View view) {
        scoreTeamA = scoreTeamA + 5;
        displayForTeamA(scoreTeamA);

    }
    public void addThreeForTeamA(View view){
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }


    public void resetScore(View view) {
        scoreTeamA = 0;
        team_b_score = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(team_b_score);

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamA);
        scoreView.setText(String.valueOf(score));
    }

    /**
     *
     * These three methods display score based on button pressed for Team B
     *
     */

    public void addNineForTeamB(View view){
        team_b_score = team_b_score + 9;
        displayForTeamB(team_b_score);
    }

    public void addFiveForTeamB(View view) {
        team_b_score = (team_b_score) + 5;
        displayForTeamB(team_b_score);

    }
    public void addThreeForTeamB(View view) {
       team_b_score = (team_b_score) + 3;
       displayForTeamB(team_b_score);
    }


    public void addOneForTeamB(View view) {
        team_b_score = (team_b_score) + 1;
        displayForTeamB(team_b_score);
    }



    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


    @Override
    public void onClick(View view) {

    }
}

