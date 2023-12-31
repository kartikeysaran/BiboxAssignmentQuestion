package kartikey.saran.biboxassignmentquestion.DB;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import kartikey.saran.biboxassignmentquestion.Helper.Utils;
import kartikey.saran.biboxassignmentquestion.Model.Question;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.GlobalScope;

import android.content.Context;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

@androidx.room.Database(entities = {Question.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class Database extends RoomDatabase {
    public abstract QuestionDAO questionDAO();

    @Volatile
    private static Database instance;

    public static Database getInstance(Context context) {
        synchronized (context) {
            if(instance == null) {
                instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        Database.class,
                        Utils.DB_NAME
                ).fallbackToDestructiveMigration().build();
            }
            return instance;
        }
    }
}
