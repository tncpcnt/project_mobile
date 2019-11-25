package com.example.hidden;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_inputUser extends AppCompatActivity {
    private Button btnGo ;
    private Button btnScore ;
    private Database database;
    private TextView name;
    private ProgressDialog progressDialog;
    private Intent intent;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);
        initProgressDialog();

        name = (TextView) findViewById(R.id.inputName);
//        btnGo = (Button)findViewById(R.id.start);
//        btnScore = (Button)findViewById(R.id.score);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_inputUser.this, UserListShow.class);
                if (name.getText().length() != 0) {
                    user = new User(0, name.getText().toString(), 0);
                    user = database.getUserById(getIntent().getLongExtra("id", 0));
                }

                startActivity(intent);
            }
        });

}
    private void createUser() {
        long id = new Database(this).createUser(user, this, 100);
        intent.putExtra("id", id);
        progressDialog.dismiss();
        startActivity(intent);
        finish();
    }

    private void initProgressDialog() {
        progressDialog = new ProgressDialog(Activity_inputUser.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (progressDialog != null && progressDialog.isShowing()) {
//            progressDialog.cancel();
//        }
//    }



}
