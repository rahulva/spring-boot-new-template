package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "sbd_session")
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String sessionId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Temporal(TemporalType.TIME)
    private LocalTime time;

    @Column(length = 3000)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(sessionId, session.sessionId) &&
                Objects.equals(person, session.person) &&
                Objects.equals(date, session.date) &&
                Objects.equals(time, session.time) &&
                Objects.equals(description, session.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, person, date, time, description);
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", person=" + person +
                ", date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                '}';
    }
}
