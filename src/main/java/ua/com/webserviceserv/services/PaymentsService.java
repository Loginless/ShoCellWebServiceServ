package ua.com.webserviceserv.services;

import ua.com.webserviceserv.models.Payments;

public interface PaymentsService {

    Payments findByID(Integer paymentID);

    void addPayment(Payments payment);


}
