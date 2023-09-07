package kartikey.saran.biboxassignmentquestion.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kartikey.saran.biboxassignmentquestion.Adapter.QuestionAdapter;
import kartikey.saran.biboxassignmentquestion.Helper.Utils;
import kartikey.saran.biboxassignmentquestion.Model.Question;
import kartikey.saran.biboxassignmentquestion.R;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private EditText eTAddQuestion;
    private Button btnAddQuestion;
    private RecyclerView recyclerView;
    private QuestionAdapter adapter;
    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> option1 = new ArrayList<>();
        option1.add("Delhi");
        option1.add("Lucknow");
        option1.add("Mumbai");
        option1.add("Banglore");
        Question q1 = new Question("What is the capital of India ?",option1);

        //questionList.add(q1);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.addQuestion(q1);
        setUpViews();
        setUpObserver();

    }

    private void setUpViews() {
        eTAddQuestion = findViewById(R.id.eTAddQuestion);
        btnAddQuestion = findViewById(R.id.btnAddQuestion);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionList = new ArrayList<>();
        adapter = new QuestionAdapter(questionList);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        btnAddQuestion.setOnClickListener(v->{
            if(!eTAddQuestion.getText().toString().isEmpty()) {
                List<String> options = new ArrayList<>();
                Question question = new Question(eTAddQuestion.getText().toString(), options);
                viewModel.addQuestion(question);
                eTAddQuestion.setText("");
                Utils.hideKeyboard(this);
            } else {
                eTAddQuestion.setError(getString(R.string.required));
            }
        });
    }

    private void setUpObserver() {
        viewModel.getQuestionList().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                questionList = questions;
                adapter = new QuestionAdapter(questions);
                recyclerView.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "Size of ArrayList: "+questionList.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            Collections.swap(questionList, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}