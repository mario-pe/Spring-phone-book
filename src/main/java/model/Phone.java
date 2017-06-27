package model;

import javax.persistence.*;

/**
 * Created by mario on 25.06.2017.
 */
@Entity
//@Table(name="phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;
    private String extensionNumber;
    private String diallingCode;

//    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "person_id")//, referencedColumnName="id")
//    private Person person;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String nunber) {
        this.number = nunber;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public String getDiallingCode() {
        return diallingCode;
    }

    public void setDiallingCode(String diallingCode) {
        this.diallingCode = diallingCode;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    @Override
    public String toString() {
        return "phone{" +
                "id='" + id +'\'' +
                "number='" + number + '\'' +
                ", extensionNumber='" + extensionNumber + '\'' +
                ", diallingCode='" + diallingCode + '\'' +
                '}';
    }
}
