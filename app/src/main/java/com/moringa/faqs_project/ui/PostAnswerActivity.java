
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
import com.moringa.faqs_project.models.Answer;
import com.moringa.faqs_project.models.PostAnswer;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
public class PostAnswerActivity extends AppCompatActivity {
    @BindView(R.id.postAnswerBody) EditText mPostAnswerBody;
    @BindView(R.id.postAnswerButton) Button mPostAnswerButton;
    private PostAnswer answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_answer);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int questionId = intent.getIntExtra("questionId", 0);

        mPostAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postAnswer(questionId);
                startActivity(new Intent(PostAnswerActivity.this, AnswerResponseActivity.class));
            }
        });
    }


    private void postAnswer(int questionId) {
        String  body = mPostAnswerBody.getText().toString();
        M_faq_Interface client = Faq_Client.getClient();
        Call<PostAnswer> call = client.postAnswer(body);
        call.enqueue(new Callback<PostAnswer>(){
            @Override
            public void onResponse(retrofit2.Call<PostAnswer> call, retrofit2.Response<PostAnswer> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    answer = response.body();
                    answer.setQuestion(questionId);
                    Toast.makeText(PostAnswerActivity.this, "Answer Successfully Added", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostAnswer> call, Throwable t) {
                Toast.makeText(PostAnswerActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        });
    }
}

