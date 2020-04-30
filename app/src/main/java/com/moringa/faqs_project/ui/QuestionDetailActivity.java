package com.moringa.faqs_project.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringa.faqs_project.Network.Faq_Client;
import com.moringa.faqs_project.Network.M_faq_Interface;
import com.moringa.faqs_project.R;
import com.moringa.faqs_project.adapters.AnswerListAdapter;
import com.moringa.faqs_project.models.Answer;
import com.moringa.faqs_project.models.QuestionSearchResponse;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionDetailActivity extends AppCompatActivity {

    private AnswerListAdapter mAdapter;

    private QuestionSearchResponse question;
    private List<Answer> answers;
    @BindView(R.id.questionId)
    TextView mQuestionId;
    @BindView(R.id.questionTitle)
    TextView mQuestionTitle;
    @BindView(R.id.questionBody)
    TextView mQuestionBody;
    @BindView(R.id.addAnswerButton)
    FloatingActionButton mAddAnswer;
    @BindView(R.id.questionPostedBy)
    TextView mQuestionPostedBy;
    @BindView(R.id.questionPostedAt)
    TextView mQuestionPostedAt;

    @BindView(R.id.answersRecyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        ButterKnife.bind(this);

        mAddAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = Parcels.unwrap(getIntent().getParcelableExtra("question"));
                assert question != null;
                int questionId = question.getId();
                Intent intent = new Intent(QuestionDetailActivity.this, PostAnswerActivity.class);
                intent.putExtra("questionId", questionId);
                startActivity(intent);
                Toast.makeText(QuestionDetailActivity.this , "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        question = Parcels.unwrap(getIntent().getParcelableExtra("question"));
        mQuestionId.setText(question.getId().toString());
        mQuestionTitle.setText(question.getTitle());
        mQuestionBody.setText(question.getBody());
        //mQuestionPostedBy.setText(question.getPoster());
        mQuestionPostedAt.setText(question.getCreated().substring(0, 10));

        M_faq_Interface client = Faq_Client.getClient();
        Call<List<Answer>> call = client.getAnswer();
        call.enqueue(new Callback<List<Answer>>() {
            @Override
            public void onResponse(Call<List<Answer>> call, Response<List<Answer>> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    answers= response.body();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(QuestionDetailActivity.this);
                    mAdapter = new AnswerListAdapter(QuestionDetailActivity.this, answers);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                }
            }
            @Override
            public void onFailure(Call<List<Answer>> call, Throwable t) {
            }
        });

    }

    private void showAnswers() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }
}
