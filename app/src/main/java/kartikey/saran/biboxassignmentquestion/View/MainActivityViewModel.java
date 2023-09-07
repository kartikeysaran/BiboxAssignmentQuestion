package kartikey.saran.biboxassignmentquestion.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kartikey.saran.biboxassignmentquestion.Model.Question;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<List<Question>> questionsList = new MutableLiveData<List<Question>>();
    public LiveData<List<Question>> getQuestionList() {
        return questionsList;
    }

    public void addQuestion(Question question) {
        List<Question> questions = questionsList.getValue();
        if(questions==null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
        questionsList.setValue(questions);
    }

    public void setValueList(List<Question> questions) {
        questionsList.setValue(questions);
    }

}