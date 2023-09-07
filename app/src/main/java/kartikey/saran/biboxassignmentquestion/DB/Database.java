package kartikey.saran.biboxassignmentquestion.DB;

import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import kartikey.saran.biboxassignmentquestion.Model.Question;

@androidx.room.Database(entities = {Question.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class Database extends RoomDatabase {
    public abstract QuestionDAO questionDAO();
}
