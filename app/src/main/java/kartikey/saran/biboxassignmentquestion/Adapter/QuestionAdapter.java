package kartikey.saran.biboxassignmentquestion.Adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import kartikey.saran.biboxassignmentquestion.Helper.Utils;
import kartikey.saran.biboxassignmentquestion.Helper.onOptionAdded;
import kartikey.saran.biboxassignmentquestion.Model.Question;
import kartikey.saran.biboxassignmentquestion.R;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{

    private List<Question> questionList;
    private Context context;
    private OptionAdapter optionAdapter;
    private onOptionAdded onOptionAddedListener;
    public QuestionAdapter(List<Question> questionList, onOptionAdded onOptionAddedListener) {
        this.questionList = questionList;
        this.onOptionAddedListener = onOptionAddedListener;
    }


    @NonNull
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false);
        this.context = parent.getContext();
        return new QuestionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.ViewHolder holder, int position) {
        holder.questionTitle.setText(questionList.get(position).getQuestion());
        holder.responseRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        List<String> optionList = questionList.get(position).getOptions();
        if(optionList.size()>=8) {
            holder.editTextOption.setVisibility(View.GONE);
            holder.addOption.setVisibility(View.GONE);
        }
        optionAdapter = new OptionAdapter(optionList);
        holder.responseRecyclerView.setAdapter(optionAdapter);
        holder.addOption.setOnClickListener(v->{
            //Register a callback and at it in the initial view
            if(!holder.editTextOption.getText().toString().isEmpty()) {
                if(optionList.size() < 8) {
                      optionList.add(holder.editTextOption.getText().toString());
                      optionAdapter = new OptionAdapter(optionList);
                      holder.responseRecyclerView.setAdapter(optionAdapter);
                      onOptionAddedListener.onNewOptionAdded(questionList.get(position));
                } else {
                    Toast.makeText(context, "You have reached maximum options for this question", Toast.LENGTH_SHORT).show();
                }
                holder.editTextOption.setText("");
                Utils.hideKeyboard((Activity) context);
            } else {
                holder.editTextOption.setError("Required");
            }
        });

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, 0) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                Collections.swap(questionList.get(holder.getAdapterPosition()).getOptions(), fromPosition, toPosition);
                recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(holder.responseRecyclerView);
        holder.itemView.setTag(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionTitle;
        RecyclerView responseRecyclerView;
        Button addOption;
        EditText editTextOption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTitle = itemView.findViewById(R.id.item_question_q);
            responseRecyclerView = itemView.findViewById(R.id.item_question_lL_option);
            addOption = itemView.findViewById(R.id.item_question_btn_add_option);
            editTextOption = itemView.findViewById(R.id.item_layout_eT_option);
        }
    }

}
