package kartikey.saran.biboxassignmentquestion.DI;

import android.app.Application;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import kartikey.saran.biboxassignmentquestion.DB.Database;
import kartikey.saran.biboxassignmentquestion.DB.QuestionDAO;
import kartikey.saran.biboxassignmentquestion.DB.QuestionRepository;

@InstallIn(SingletonComponent.class)
@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public Database provideDatabase(Application application) {
        return Database.getInstance(application);
    }

    @Provides
    public QuestionDAO provideQuestionDAO(Database database) {
        return database.questionDAO();
    }

    @Provides
    public QuestionRepository provideRepository(QuestionDAO questionDAO) {
        return new QuestionRepository(questionDAO);
    }

}
