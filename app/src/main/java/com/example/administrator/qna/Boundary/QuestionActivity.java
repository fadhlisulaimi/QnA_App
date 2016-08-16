package com.example.administrator.qna.Boundary;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


import com.example.administrator.qna.Database.DatabaseHelper;
import com.example.administrator.qna.Entity.Question;
import com.example.administrator.qna.Manager.AnswerManager;
import com.example.administrator.qna.Manager.QuestionManager;
import com.example.administrator.qna.R;

import java.util.List;

/**
 * Created by Administrator on 5/21/2015.
 */
public class QuestionActivity extends Activity {

    private TextView QnsDescription,QnsID,answerbtn,allanswers,noanswers;
    private ListView AnsList;
    private ListView AnsListTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent i = getIntent();
        final String username = i.getStringExtra("usernamesession");
        final int selectedquestionID = i.getIntExtra("questionIDsession", 0);
        final String selectedquestion = i.getStringExtra("questionsession");
        final String selectedusername = i.getStringExtra("selectedusernamesession");
        final int getAnswered = i.getIntExtra("getanswered", 0);

        AnsList = (ListView)findViewById(R.id.anslistView);

        QnsID = (TextView) findViewById(R.id.question);
        QnsID.setText("Question No "+selectedquestionID);

        QnsDescription = (TextView) findViewById(R.id.questiondescription);
        QnsDescription.setText(selectedquestion);

        answerbtn = (TextView) findViewById(R.id.ansbtn);

        allanswers = (TextView) findViewById(R.id.allanswers);
        allanswers.setText("All Answers ("+getAnswered+")");

        noanswers = (TextView) findViewById(R.id.NoAnswers);

        displayAnswerListView(selectedquestionID);

        answerbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivity.this, AnswerActivity.class);
                intent.putExtra("usernamesession", username);
                intent.putExtra("questionIDsession", selectedquestionID);
                intent.putExtra("questionsession", selectedquestion);
                intent.putExtra("selectedusernamesession", selectedusername);
                intent.putExtra("getanswered", getAnswered);
                startActivityForResult(intent, 1);


            }

            ;


        });


    }

    private void displayAnswerListView(int ID){

        AnswerManager am = new AnswerManager(this);

        Cursor c = am.fetchAnswersById(ID);

        if (c.getCount() != 0) {

            AnswerAdapter adapter = new AnswerAdapter(this, c);
            AnsList.setAdapter(adapter);
        }else{
            allanswers.setVisibility(View.INVISIBLE);
            noanswers.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(QuestionActivity.this, HomeActivity.class);
        setResult(RESULT_OK, i);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String questiondescrip = data.getStringExtra("questiondescripsession");
                QnsDescription.setText(questiondescrip);
            }
        }
    }



}
