package com.example.fengxinlin.project0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button movie_btn = (Button) findViewById(R.id.btn_movie);
        final Button stock_btn = (Button) findViewById(R.id.btn_stock);
        final Button reader_btn = (Button) findViewById(R.id.btn_reader);
        final Button news_btn = (Button) findViewById(R.id.btn_news);
        final Button cap_btn = (Button) findViewById(R.id.btn_capstone);

        movie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lunch Appication : Popular Movie.", Toast.LENGTH_SHORT).show();
            }
        });

        stock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lunch Appication : Stock Hawk.", Toast.LENGTH_SHORT).show();
            }
        });

        reader_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lunch Appication : XYZ reader.", Toast.LENGTH_SHORT).show();
            }
        });

        news_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lunch Appication : ZUI News.", Toast.LENGTH_SHORT).show();
            }
        });

        cap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lunch Appication : Capstone.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
