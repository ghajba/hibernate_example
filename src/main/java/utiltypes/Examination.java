package utiltypes;

import java.util.Date;

import javax.persistence.*;

/**
 * @author GHajba
 */
@Entity
public class Examination {

    Examination() {
    }

    public Examination(String description, String notes, Date time, Patient patient) {
        setDescription(description);
        setNotes(notes);
        setTime(time);
        setPatient(patient);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @Column(length = 2048)
    private String notes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCalendar;

    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimeCalendar() {
        return timeCalendar;
    }

    public void setTimeCalendar(Date timeCalendar) {
        this.timeCalendar = timeCalendar;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
