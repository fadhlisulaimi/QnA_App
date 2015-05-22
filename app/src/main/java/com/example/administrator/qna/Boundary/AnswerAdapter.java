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
public class AnswerAdapter extends CursorAdapter{
    public AnswerAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.ans_list, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView username = (TextView) view.findViewById(R.id.viewusername);
        TextView answer = (TextView) view.findViewById(R.id.viewans);

        // Extract properties from cursor
        String getusername = cursor.getString(2);
        String getanswer = cursor.getString(1);

        // Populate fields with extracted properties
        username.setText("Answered By : "+getusername);
        answer.setText(getanswer);

    }

}
