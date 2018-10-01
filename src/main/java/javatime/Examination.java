package javatime;

import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * @author GHajba
 */
@Entity
public class Examination {

    Examination() {
    }

    public Examination(String description, String notes, LocalDateTime time, Patient patient) {
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

    private LocalDateTime time;

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

    public LocalDateTime getTime() {
        if (time.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Examination time cannot be in the future!");
        }
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
