package model;



import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by mario on 25.06.2017.
 */
@Entity
//@Table(name="phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Pattern(regexp ="[0-9 -]", message = "{Pattern.Phone.number.validation}")
    private String number;
    @Size(min=2,max=5,message = "{Size.Phone.extensionNumber.validation}")
    @Pattern(regexp ="[0-9 -]", message = "{Pattern.Phone.extensionNumber.validation}")
    private String extensionNumber;
    @Pattern(regexp ="[0-9 -]", message = "{Pattern.Phone.diallingCode.validation}")
    private String diallingCode;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "person_id")//, referencedColumnName="id")
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

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
