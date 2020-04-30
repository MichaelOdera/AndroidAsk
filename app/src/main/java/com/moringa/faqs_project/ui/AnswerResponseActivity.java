package com.moringa.faqs_project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringa.faqs_project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnswerResponseActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backToQuestion)
    Button mBackToQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_response);
        ButterKnife.bind(this);
        mBackToQuestionButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == mBackToQuestionButton){
            startActivity(new Intent(AnswerResponseActivity.this, MainActivity.class));
        }

    }
}
