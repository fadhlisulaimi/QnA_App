package com.example.administrator.qna.Boundary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;

import com.example.administrator.qna.R;
import com.example.administrator.qna.Manager.UserManager;

/**
 * Created by Administrator on 5/21/2015.
 */
public class NameActivity extends Activity {

    private EditText usernameinput;
    private ImageView submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        submitbtn = (ImageView) findViewById(R.id.submitbtn);
        usernameinput = (EditText) findViewById(R.id.nick_name);
        usernameinput.setGravity(Gravity.CENTER);
    }

    public void onClick(View v) {


        if(v==submitbtn) {

            String username = usernameinput.getText().toString();

            UserManager um = new UserManager(this);
            um.addName(username);

            Intent intent = new Intent(NameActivity.this, HomeActivity.class);
            intent.putExtra("usernamesession" , username);
            startActivity(intent);
            finish();
            Log.i("Submit button press ", " App layout ");
        }
    }
}
