package kartikey.saran.biboxassignmentquestion.DB;

import java.util.List;

import javax.inject.Inject;

import kartikey.saran.biboxassignmentquestion.Model.Question;

public class QuestionRepository {
    @Inject
    QuestionDAO questionDAO;

    public void addQuestion(Question question) {
        questionDAO.addQuestion(question);
    }

    public void updateQuetion(Question question) {
        questionDAO.updateQuestion(question);
    }

    public List<Question> getAllQuestion() {
        return questionDAO.getAll();
    }
}
