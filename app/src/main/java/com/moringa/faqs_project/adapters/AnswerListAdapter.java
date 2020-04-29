package com.moringa.faqs_project.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.faqs_project.models.Answer;
import com.moringa.faqs_project.ui.QuestionDetailActivity;
import com.moringa.faqs_project.R;

import org.parceler.Parcels;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnswerListAdapter extends RecyclerView.Adapter<AnswerListAdapter.AnswerViewHolder> {
    private List<Answer> mAnswers;
    private Answer answer;
    private Context mContext;

    public AnswerListAdapter(Context context, List<Answer> answers){
        mContext = context;
        mAnswers = answers;
    }

    @NonNull
    @Override
    public AnswerListAdapter.AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_answer_list_item, parent, false);
        AnswerViewHolder viewHolder = new AnswerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerListAdapter.AnswerViewHolder holder, int position) {
        holder.bindAnswers(mAnswers.get(position));
    }

    @Override
    public int getItemCount() {
        return mAnswers.size();
    }

    public class AnswerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.answerBody1) TextView mAnswerBody;
        private Context mContext;

        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }


        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Intent intent = new Intent(mContext, QuestionDetailActivity.class);
            answer = mAnswers.get(position);
            intent.putExtra("question", Parcels.wrap(answer));
            intent.putExtra("position", position);
            mContext.startActivity(intent);
        }

        public void bindAnswers(Answer answerSearchResponse) {
            mAnswerBody.setText(answerSearchResponse.getBody());

        }
    }


}

