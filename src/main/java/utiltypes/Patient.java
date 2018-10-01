package utiltypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * @author GHajba
 */
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examination> bedheadBoard = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Patient() {
    }

    public Patient(String name, Date birthday) {
        setName(name);
        setBirthday(birthday);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Examination> getBedheadBoard() {
        return bedheadBoard;
    }

    @Override
    public String toString() {
        return String.format("Patient called %s has %d entries in his/her bedhead board.", this.getName(), this.bedheadBoard.size());
    }
}
