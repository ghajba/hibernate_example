package utiltypes;

import java.util.ArrayList;
import java.util.Calendar;
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

    @Temporal(TemporalType.DATE)
    private Calendar birthdayCalendar;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Examination> bedheadBoard = new ArrayList<>();

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

    public Calendar getBirthdayCalendar() {
        return birthdayCalendar;
    }

    public void setBirthdayCalendar(Calendar birthdayCalendar) {
        this.birthdayCalendar = birthdayCalendar;
    }

    public List<Examination> getBedheadBoard() {
        return bedheadBoard;
    }

    @Override
    public String toString() {
        return String.format("Patient called %s has %d entries in his/her bedhead board.", this.getName(), this.bedheadBoard.size());
    }
}
