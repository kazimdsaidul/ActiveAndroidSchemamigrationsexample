package sadiul.com.activeandroidschemamigrationsexample.model;

import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 9/25/17.
 */

public class PersonDb {

    public  static  List<Person> getAllPerson() {

        return new Select()
                .from(Person.class)
                .execute();

    }
}
