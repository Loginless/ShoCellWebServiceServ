package ua.com.webserviceserv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.webserviceserv.models.Abonents;
import ua.com.webserviceserv.models.Payments;
import ua.com.webserviceserv.models.PaymentsDTO;
import ua.com.webserviceserv.repository.AbonentsRepository;
import ua.com.webserviceserv.repository.PaymentsRepository;

import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService{

    @Autowired
    AbonentsRepository abonentsRepository;

    @Autowired
    PaymentsRepository paymentsRepository;

    public Payments findByID(Integer paymentID) {
        return paymentsRepository.findOne(paymentID);
    }

    public void addPayment(Payments payment) {
        paymentsRepository.saveAndFlush(payment);
    }

    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    public Integer makePayment(Abonents abonents, PaymentsDTO paymentDTO) {
        if (abonents == null) {
            return -1;
        } else {
            Payments payment = new Payments();
            payment.setAbonentID(abonents);
            payment.setPaymentSum(paymentDTO.getPaymentAmount());
            payment.setChannel(paymentDTO.getChannel());

            this.addPayment(payment);
            return payment.getPaymentID();
        }
    }

    public Payments getPayment(int id) {
        return paymentsRepository.findOne(id);

    }

    @Override
    public Payments getPayment(int id, int customerID) {
        return null;
    }

//    public Payments getCustomerPayment(int id, int customerID) {
//        return paymentsRepository.getCustomerPayment(id, customerID);
//    }

    public Integer create(PaymentsDTO resource) {
        Abonents customer = abonentsRepository.findOne(resource.getCustomerId());
        return this.makePayment(customer, resource);
    }
}

