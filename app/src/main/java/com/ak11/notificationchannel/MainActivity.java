package com.ak11.notificationchannel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtWatchMovie;
    private NotificationHandler notificationHandler;

    private static final int WATCH_MOVIE_NOTIFICATION_ID=999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationHandler = new NotificationHandler(MainActivity.this);
        edtWatchMovie = findViewById(R.id.edtWatchMovie);
        findViewById(R.id.btnWatchMovie).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMovieSettings).setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnWatchMovie:
                postNotificationToUserDevice(WATCH_MOVIE_NOTIFICATION_ID,edtWatchMovie.getText().toString());
                break;
            case R.id.btnMovieSettings:
                break;




        }
    }

    private void postNotificationToUserDevice(int notificationID, String titleText){
        Notification.Builder notificationBuilder = null;

        switch (notificationID){
            case WATCH_MOVIE_NOTIFICATION_ID:
                notificationBuilder = notificationHandler.createAndReturnWatchMovieNotification(titleText,"This is Great!");
                break;
        }

        if(notificationBuilder!=null){
            notificationHandler.notifyTheUser(WATCH_MOVIE_NOTIFICATION_ID,notificationBuilder);
        }


    }
}