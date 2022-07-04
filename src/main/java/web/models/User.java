package web.models;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private byte age;

    public User() {}

    public User(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }
}
