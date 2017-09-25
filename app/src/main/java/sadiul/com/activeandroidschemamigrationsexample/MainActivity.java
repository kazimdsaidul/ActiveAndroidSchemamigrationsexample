package sadiul.com.activeandroidschemamigrationsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import sadiul.com.activeandroidschemamigrationsexample.model.Person;
import sadiul.com.activeandroidschemamigrationsexample.model.PersonDb;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btInsert;
    Button btShow;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiziation();


    }

    private void initiziation() {
        btInsert = (Button) findViewById(R.id.btInsert);
        btShow = (Button) findViewById(R.id.btShow);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btInsert.setOnClickListener(this);
        btShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btInsert:

                insert();

                break;

            case R.id.btShow:

                show();
                break;

        }
    }

    private void show() {

        List<Person> allPerson = PersonDb.getAllPerson();

        StringBuilder stringBuilder = new StringBuilder();
        for (Person item:allPerson) {

            stringBuilder.append(item.getId()+" "+item.toString());
        }

        tvResult.setText(stringBuilder);




    }

    private void insert() {




          Person person = new Person("name v1", "emailV1");
          Long save = person.save();
          Log.e("TAG", "insert: "+save);



    }
}
