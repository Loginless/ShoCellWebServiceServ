package ua.com.webserviceserv.models;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Cacheable
@Table(
        name = "Payments"
)
public class Payments {
    @Id
    @GeneratedValue
    @Column(
            name = "Payment_ID"
    )
    private int paymentID;
    @Column(
            name = "Date"
    )
    private Date date;
    @Column(
            name = "Payment_Sum"
    )
    private float paymentSum;

    @Column
    private String channel;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "Abonent_ID",
            foreignKey = @ForeignKey(
                    name = "Fk_Abonent_Payments"
            )
    )
    private Abonents abonentID;

    public Payments() {
    }

    public Payments(Date date, int paymentSum, Abonents abonentID) {
        this.date = date;
        this.paymentSum = paymentSum;
        this.abonentID = abonentID;
    }

    public int getPaymentID() {

        return this.paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPaymentSum() {
        return this.paymentSum;
    }

    public void setPaymentSum(float paymentSum) {
        this.paymentSum = paymentSum;
    }

    public Abonents getAbonentID() {
        return this.abonentID;
    }

    public void setAbonentID(Abonents abonentID) {
        this.abonentID = abonentID;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }



    public String toString() {
        return "Payments{paymentID=" + this.paymentID + ", activatedServices=, date=" + this.date + ", paymentSum=" + this.paymentSum + ", accountBalance=, abonentID=" + this.abonentID + '}';
    }
}

