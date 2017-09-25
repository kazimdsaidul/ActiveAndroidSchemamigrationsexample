package sadiul.com.activeandroidschemamigrationsexample;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.TableInfo;

import java.lang.reflect.Field;
import java.util.Collection;

import sadiul.com.activeandroidschemamigrationsexample.model.Person;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 9/25/17.
 */

public class AppController extends   com.activeandroid.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // <---- run your one time code here

             createIfNeedColumn(Person.class,"Mobile");

            // mark first time has runned.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

    }

    public static boolean createIfNeedColumn(Class<? extends Model> type, String column) {
        boolean isFound = false;
        TableInfo tableInfo = new TableInfo(type);

        Collection<Field> columns = new TableInfo(type).getFields();
        for (Field f : columns) {
            if (column.equals(f.getName())) {
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            ActiveAndroid.execSQL("ALTER TABLE " + tableInfo.getTableName() + " ADD COLUMN " + column + " TEXT;");
        }
        return isFound;
    }
}
