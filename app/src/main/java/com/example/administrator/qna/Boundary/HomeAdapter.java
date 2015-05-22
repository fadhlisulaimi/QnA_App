package com.example.administrator.qna.Boundary;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.administrator.qna.R;

/**
 * Created by Administrator on 5/21/2015.
 */
public class HomeAdapter extends CursorAdapter{
    public HomeAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.qns_list, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView username = (TextView) view.findViewById(R.id.viewusername);
        TextView question = (TextView) view.findViewById(R.id.viewqns);
        TextView answered = (TextView) view.findViewById(R.id.answered);

        // Extract properties from cursor
        String getusername = cursor.getString(1);
        String getquestion = cursor.getString(2);
        int getanswered = cursor.getInt(3);

        // Populate fields with extracted properties
        username.setText("Asked By : "+getusername);
        question.setText(getquestion);
        answered.setText(getanswered+" Answers");

    }

}
