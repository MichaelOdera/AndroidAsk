package com.moringa.faqs_project.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.moringa.faqs_project.Network.Faq_Client;
import com.moringa.faqs_project.Network.M_faq_Interface;
import com.moringa.faqs_project.R;
import com.moringa.faqs_project.models.QuestionSearchResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
public class PostQuestionActivity extends AppCompatActivity {
    @BindView(R.id.editQuestionTitle) EditText mEditQuestionTitle;
    @BindView(R.id.editQuestionBody) EditText mEditQuestionBody;
    @BindView(R.id.postQuestionButton) Button mPostQuestionButton;
    private QuestionSearchResponse question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_question);
        ButterKnife.bind(this);

        mPostQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postQuestion();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }

    private void postQuestion() {
        String  title = mEditQuestionTitle.getText().toString();
        String  body = mEditQuestionBody.getText().toString();
        M_faq_Interface client = Faq_Client.getClient();
        Call<QuestionSearchResponse> call = client.postQuestion(title, body);
        call.enqueue(new Callback<QuestionSearchResponse>(){
            @Override
            public void onResponse(retrofit2.Call<QuestionSearchResponse> call, retrofit2.Response<QuestionSearchResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    question = response.body();
                    Toast.makeText(PostQuestionActivity.this, "successfully created", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(retrofit2.Call<QuestionSearchResponse> call, Throwable t) {
                Toast.makeText(PostQuestionActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}