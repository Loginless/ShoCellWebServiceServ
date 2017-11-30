package ua.com.webserviceserv.models;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Entity
@Table(
        name = "Individual_Abonents"
)
public class PrePaid extends Abonents {
    @Column(
            name = "Abonents_First_Name"
    )
    private String firstName;
    @Column(
            name = "Abonents_Second_Name"
    )
    private String secondName;

    public PrePaid() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "PrePaid{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}


