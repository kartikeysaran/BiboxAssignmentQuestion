package kartikey.saran.biboxassignmentquestion.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import kartikey.saran.biboxassignmentquestion.Model.Question;

@Dao
public interface QuestionDAO {
    @Query("SELECT * FROM questions")
    List<Question> getAll();

    @Insert
    void addQuestion(Question question);

    @Update
    void updateQuestion(Question question);

    @Update
    void updateQuestionList(List<Question> questions);
}
