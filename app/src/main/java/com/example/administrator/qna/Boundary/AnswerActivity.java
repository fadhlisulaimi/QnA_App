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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.qna.Entity.Users;
import com.example.administrator.qna.Manager.AnswerManager;
import com.example.administrator.qna.Manager.QuestionManager;
import com.example.administrator.qna.Manager.UserManager;
import com.example.administrator.qna.R;


public class AnswerActivity extends Activity {

    private TextView viewusernameandqns , qnsdescription;
    private EditText anstextbox;
    private ImageView ansbtn;
    private ImageView test;
    private EditText test;
    private EditText test2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Intent i = getIntent();
        final String username = i.getStringExtra("usernamesession");
        final int selectedquestionID = i.getIntExtra("questionIDsession", 0);
        final String selectedquestion = i.getStringExtra("questionsession");
        final String selectedusername = i.getStringExtra("selectedusernamesession");
        final int getAnswered = i.getIntExtra("getanswered", 0);


        qnsdescription = (TextView) findViewById(R.id.questiondescription);
        qnsdescription.setText(selectedquestion);

        viewusernameandqns = (TextView) findViewById(R.id.usernamenqns);
        viewusernameandqns.setText("Hi "+username+". What is your answer?");

        anstextbox = (EditText) findViewById(R.id.ans_textfield);
        anstextbox.setGravity(Gravity.TOP);
        anstextbox.setGravity(Gravity.LEFT);

        ansbtn = (ImageView) findViewById(R.id.ansbtn);


        final AnswerManager am = new AnswerManager(this);

        ansbtn.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v) {

                int newgetAnswered = getAnswered +1;

                String answer = anstextbox.getText().toString();
                am.addAnswer(selectedquestionID,answer,newgetAnswered,username);

                Intent intent = new Intent(AnswerActivity.this, QuestionActivity.class);
                intent.putExtra("usernamesession" , username);
                intent.putExtra("questionIDsession", selectedquestionID);
                intent.putExtra("questionsession", selectedquestion);
                intent.putExtra("selectedusernamesession", selectedusername);
                intent.putExtra("getanswered", newgetAnswered);
                startActivity(intent);
                finish();

            };


        });



    }


    @Override
    public void onBackPressed() {
        String questiondescrip = qnsdescription.getText().toString();

        Intent i = new Intent(AnswerActivity.this, QuestionActivity.class);
        i.putExtra("questiondescripsession", questiondescrip);
        setResult(RESULT_OK, i);
        finish();

    }



}
