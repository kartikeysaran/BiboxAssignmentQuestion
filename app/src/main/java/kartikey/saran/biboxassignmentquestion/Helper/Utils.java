package kartikey.saran.biboxassignmentquestion.Helper;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
public class Utils {
    public static void hideKeyboard(Activity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = context.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(context);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final String DB_NAME = "questions_db";
}
