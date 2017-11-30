package ua.com.webserviceserv.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Cacheable
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Table(
        name = "Abonents"
)
public class Abonents {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "Abonent_ID"
    )
    private int abonentID;
    @Column(
            name = "Mobile_Number"
    )
    private long mobileNumber;
    @Column(
            name = "Abonent_Status",
            nullable = false
    )
    private boolean abonentStatus;

    @OneToMany(
            mappedBy = "abonentID",
            fetch = FetchType.LAZY
    )
    private List<Payments> paymentRecords = new ArrayList();

    public Abonents() {
    }


    public int getAbonentID() {
        return this.abonentID;
    }

    public void setAbonentID(int abonentID) {
        this.abonentID = abonentID;
    }

    public long getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isAbonentStatus() {
        return this.abonentStatus;
    }

    public void setAbonentStatus(boolean abonentStatus) {
        this.abonentStatus = abonentStatus;
    }

    public List<Payments> getPaymentRecords() {
        return this.paymentRecords;
    }

    public void setPaymentRecords(List<Payments> paymentRecords) {
        this.paymentRecords = paymentRecords;
    }

    @Override
    public String toString() {
        return "Abonents{" +
                "abonentID=" + abonentID +
                ", mobileNumber=" + mobileNumber +
                ", abonentStatus=" + abonentStatus +
                ", paymentRecords=" + paymentRecords +
                '}';
    }
}


