package sadiul.com.activeandroidschemamigrationsexample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 9/25/17.
 */

@Table(name = "person")
public class Person extends Model {
    @Column(name = "Name")
     String name;
    @Column(name = "Email")
     String email;
    @Column(name = "mobile")
    String mobile;
    @Column(name = "address")
    String address;
    @Column(name = "address2")
    String address2;

   public Person(){
        super();
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Person(String name, String email, String mobile, String address) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Person(String name, String email, String mobile, String address, String address2) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.address2 = address2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
