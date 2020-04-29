package com.moringa.faqs_project.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.moringa.faqs_project.Network.Faq_Client;
import com.moringa.faqs_project.Network.M_faq_Interface;
import com.moringa.faqs_project.R;
import com.moringa.faqs_project.adapters.QuestionListAdapter;
import com.moringa.faqs_project.models.QuestionSearchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SearchedItem";
    private QuestionListAdapter mAdapter;

    @BindView(R.id.questionsRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.addQuestionButton) Button mAddQuestionButton;



//    @BindView(R.id.errorTextView)
//    TextView mErrorTextView;
//    @BindView(R.id.progressBarRegister)
//    ProgressBar mProgressBar;

    private List<QuestionSearchResponse> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mAddQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PostQuestionActivity.class));
            }
        });

        M_faq_Interface client = Faq_Client.getClient();
        Call<List<QuestionSearchResponse>> call = client.getQuestions();
        call.enqueue(new Callback<List<QuestionSearchResponse>>() {
            @Override
            public void onResponse(Call<List<QuestionSearchResponse>> call, Response<List<QuestionSearchResponse>> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    questions= response.body();
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    mAdapter = new QuestionListAdapter(MainActivity.this, questions);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                }
            }
            @Override
            public void onFailure(Call<List<QuestionSearchResponse>> call, Throwable t) {
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void showQuestions() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }



}
