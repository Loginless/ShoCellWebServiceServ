package ua.com.webserviceserv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.webserviceserv.models.Payments;
import ua.com.webserviceserv.repository.AbonentsRepository;
import ua.com.webserviceserv.repository.PaymentsRepository;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    AbonentsRepository abonentsRepository;

    @Autowired
    PaymentsRepository paymentsRepository;

    @Override
    public Payments findByID(Integer paymentID) {
        return paymentsRepository.findOne(paymentID);
    }

    @Override
    public void addPayment(Payments payment) {
        paymentsRepository.saveAndFlush(payment);
    }
}
