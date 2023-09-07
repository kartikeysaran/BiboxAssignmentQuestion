package kartikey.saran.biboxassignmentquestion.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import kartikey.saran.biboxassignmentquestion.Model.Question;

public class QuestionRepository {
    QuestionDAO questionDAO;
    @Inject
    public QuestionRepository(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }


    public void addQuestion(Question question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                questionDAO.addQuestion(question);
            }
        });

    }

    public void updateQuestion(Question question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                questionDAO.updateQuestion(question);
            }
        });
    }

    public void updateQuestionList(List<Question> questions) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                questionDAO.updateQuestionList(questions);
            }
        });
    }

    private volatile List<Question> questionList;
    public List<Question> getAllQuestion() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                questionList = questionDAO.getAll();
            }
        });
        return questionList;

    }
}
