package com.example.laba9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            myButton.setVisibility(View.INVISIBLE) ;
            constraintLayout.setBackground(getDrawable(R.drawable.online));
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Подключение есть \nДобро пожаловать в приложение!", Toast.LENGTH_LONG);
            toast1.show();
        } else {
            myButton.setVisibility(View.INVISIBLE);
            constraintLayout.setBackground(getDrawable(R.drawable.offline));
            Toast toast2 = Toast.makeText(getApplicationContext(),
                    "Нет подключения \nРазрешите доступ и повторите попытку", Toast.LENGTH_LONG);
            toast2.show();
        }
    }
}