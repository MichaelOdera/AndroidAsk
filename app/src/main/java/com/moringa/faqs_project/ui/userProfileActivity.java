package com.moringa.faqs_project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringa.faqs_project.R;
import com.moringa.faqs_project.ui.MainActivity;

import butterknife.BindView;

public class userProfileActivity extends AppCompatActivity {

    @BindView(R.id.backHomeText)TextView mBackHome;
    @BindView(R.id.favouriteQuestionText)TextView mFavouriteQuestion;
    @BindView(R.id.logoutText)TextView mLogoutText;
    @BindView(R.id.settingText)TextView mSettings;
    @BindView(R.id.helpText)TextView mHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
