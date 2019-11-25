package com.example.hidden;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.hidden.Adapter;
import com.example.hidden.User;
import com.example.hidden.Database;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UserListShow extends Activity {
    private ListView listView;
    private ArrayList<User> userArrayList;
    private Adapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userArrayList = new Database(this).getAllUser();
        listView = findViewById(R.id.user_list);

        userAdapter = new Adapter(UserListShow.this, userArrayList);
        listView.setAdapter(userAdapter);

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

