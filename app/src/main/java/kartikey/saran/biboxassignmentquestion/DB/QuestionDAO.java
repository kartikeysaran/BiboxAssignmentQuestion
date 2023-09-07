package kartikey.saran.biboxassignmentquestion.DB;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import kartikey.saran.biboxassignmentquestion.Model.Question;

@Dao
public interface QuestionDAO {

    @Query("SELECT * FROM questions")
    List<Question> getAll();
}
