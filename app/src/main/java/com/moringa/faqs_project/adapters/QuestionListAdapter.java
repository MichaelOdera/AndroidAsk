package com.moringa.faqs_project.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.faqs_project.ui.QuestionDetailActivity;
import com.moringa.faqs_project.R;
import com.moringa.faqs_project.models.QuestionSearchResponse;

import org.parceler.Parcels;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder> {
    private List<QuestionSearchResponse> mQuestions;
    private QuestionSearchResponse question;
    private Context mContext;

    public QuestionListAdapter(Context context, List<QuestionSearchResponse> questions){
        mContext = context;
        mQuestions = questions;
    }

    @NonNull
    @Override
    public QuestionListAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list_item, parent, false);
        QuestionViewHolder viewHolder = new QuestionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListAdapter.QuestionViewHolder holder, int position) {
        holder.bindQuestions(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.questionTitle)
        TextView mQuestionTitle;
        @BindView(R.id.questionBody) TextView mQuestionBody;
        private Context mContext;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }


        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Intent intent = new Intent(mContext, QuestionDetailActivity.class);
            question = mQuestions.get(position);
            //intent.putExtra("description", description);
            intent.putExtra("question", Parcels.wrap(question));
            intent.putExtra("position", position);
            mContext.startActivity(intent);
            }

        public void bindQuestions(QuestionSearchResponse questionSearchResponse) {

            mQuestionTitle.setText(questionSearchResponse.getTitle());
            mQuestionBody.setText(questionSearchResponse.getBody());

        }
    }


    }

