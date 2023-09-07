package kartikey.saran.biboxassignmentquestion.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kartikey.saran.biboxassignmentquestion.DB.QuestionRepository;
import kartikey.saran.biboxassignmentquestion.Model.Question;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    QuestionRepository questionRepository;
    @Inject
    MainActivityViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private final MutableLiveData<List<Question>> questionsList = new MutableLiveData<List<Question>>();
    public LiveData<List<Question>> getQuestionList() {
        return questionsList;
    }
    public void addQuestion(Question question) {
        List<Question> questions = questionsList.getValue();
        if(questions==null) {
            questions = new ArrayList<>();
        }
        questionRepository.addQuestion(question);
        questions.add(question);
        questionsList.setValue(questions);
    }

    public void updateQuestionList(List<Question> questions) {
        questionsList.setValue(questions);
        questionRepository.updateQuestionList(questions);
    }

    public void updateQuestion(Question question) {
        questionRepository.updateQuestion(question);
    }
}