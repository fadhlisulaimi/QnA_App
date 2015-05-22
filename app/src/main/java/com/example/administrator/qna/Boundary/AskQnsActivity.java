package com.example.administrator.qna.Boundary;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.qna.Entity.Users;
import com.example.administrator.qna.Manager.QuestionManager;
import com.example.administrator.qna.Manager.UserManager;
import com.example.administrator.qna.R;


public class AskQnsActivity extends Activity {

    private TextView viewusername;
    private EditText asktextbox;
    private ImageView askbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_qns);

        Intent i = getIntent();
        final String username = i.getStringExtra("usernamesession");


        asktextbox = (EditText) findViewById(R.id.ask_qns_textfield);
        asktextbox.setGravity(Gravity.TOP);
        asktextbox.setGravity(Gravity.LEFT);
        askbtn = (ImageView) findViewById(R.id.askbtn);

        viewusername = (TextView) findViewById(R.id.viewusername);
        viewusername.setText("Hi "+username);


        final QuestionManager qm = new QuestionManager(this);

        askbtn.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v) {

                String question = asktextbox.getText().toString();
                qm.addQuestion(question,username,0);

                Intent intent = new Intent(AskQnsActivity.this, HomeActivity.class);
                intent.putExtra("usernamesession" , username);
                startActivity(intent);
                finish();

            };


        });

    }

    @Override
    public void onBackPressed() {

        Intent intent = getIntent();
        String username = intent.getStringExtra("usernamesession");

        Intent i = new Intent(AskQnsActivity.this, HomeActivity.class);
        i.putExtra("usernamesession", username);
        setResult(RESULT_OK, i);
        finish();

    }






}
