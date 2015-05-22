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
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


import com.example.administrator.qna.Database.DatabaseHelper;
import com.example.administrator.qna.Entity.Question;
import com.example.administrator.qna.Manager.QuestionManager;
import com.example.administrator.qna.R;

import java.util.List;

/**
 * Created by Administrator on 5/21/2015.
 */
public class HomeActivity extends Activity {

    private ListView QnsList;
    private DatabaseHelper databasehelper;
    private TextView askbtn,noqns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        final String username = i.getStringExtra("usernamesession");

        noqns = (TextView)findViewById(R.id.NoQuestions);

        askbtn = (TextView) findViewById(R.id.askbtn);
        QnsList = (ListView)findViewById(R.id.QnsListView);

        askbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AskQnsActivity.class);
                intent.putExtra("usernamesession", username);
                startActivityForResult(intent, 1);


            }

            ;


        });

        displayListView();

        QnsList.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                Cursor cursor = (Cursor) arg0.getItemAtPosition(position);
                int getID = cursor.getInt(0);
                int getAnswered = cursor.getInt(3);

                TextView viewusername = (TextView) v.findViewById(R.id.viewusername);
                TextView viewqns = (TextView) v.findViewById(R.id.viewqns);

                String selectedusername = viewusername.getText().toString();
                String selectedqns = viewqns.getText().toString();

                Intent intent = new Intent(HomeActivity.this, QuestionActivity.class);
                intent.putExtra("usernamesession" , username);
                intent.putExtra("questionIDsession",getID);
                intent.putExtra("questionsession", selectedqns);
                intent.putExtra("selectedusernamesession", selectedusername);
                intent.putExtra("getanswered", getAnswered);
                startActivityForResult(intent, 1);




            }

        });



    }



    private void displayListView(){

        QuestionManager qm = new QuestionManager(this);

        Cursor c = qm.fetchAllQuestions();



        if (c.getCount() != 0) {

            HomeAdapter adapter = new HomeAdapter(this, c);
            QnsList.setAdapter(adapter);

        }else{

            noqns.setVisibility(View.VISIBLE);

        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String username = data.getStringExtra("usernamesession");

            }
        }
    }


}
