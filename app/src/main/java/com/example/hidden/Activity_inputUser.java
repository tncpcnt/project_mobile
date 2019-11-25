package com.example.hidden;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.Objects;

public class Activity_inputUser extends AppCompatActivity {
    private ImageView btnGo;
    private ImageView back;
    private Database database;
    private TextView name;
    private ProgressDialog progressDialog;
    private Intent intent;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);
        Objects.requireNonNull(getSupportActionBar()).hide();
        name = (TextView) findViewById(R.id.inputName);
        btnGo = (ImageView) findViewById(R.id.imageView);
        back = (ImageView) findViewById(R.id.imageView2);
        database = new Database(this);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inputUser.this, GameActivity.class);
                if (name.getText().length() != 0) {
                    user = new User(0, name.getText().toString(), 0);
                    long id  = database.createUser(user);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
