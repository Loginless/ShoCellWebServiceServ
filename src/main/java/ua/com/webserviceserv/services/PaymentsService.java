package ua.com.webserviceserv.services;

import ua.com.webserviceserv.models.Abonents;
import ua.com.webserviceserv.models.Payments;
import ua.com.webserviceserv.models.PaymentsDTO;

import java.util.List;

public interface PaymentsService {

    Payments findByID(Integer paymentID);

    void addPayment(Payments payment);

    List<Payments> getAllPayments();

    Integer makePayment(Abonents abonents, PaymentsDTO payment);

    Payments getPayment(int id);

    Payments getPayment(int id, int customerID);

    Integer create(PaymentsDTO resource);


}
