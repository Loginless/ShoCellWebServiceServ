package ua.com.webserviceserv.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.webserviceserv.models.Assembler;
import ua.com.webserviceserv.models.Payments;
import ua.com.webserviceserv.models.PaymentsDTO;
import ua.com.webserviceserv.services.AbonentsService;
import ua.com.webserviceserv.services.PaymentsService;

@RestController
public class MainController {

    @Autowired
    private PaymentsService paymentService;
//
//    @Autowired
//    private AbonentsService abonentsService;

    @RequestMapping(
            value = "/payments/{id}"
            , method = RequestMethod.GET
            , headers = {"Accept=application/json"})
    // HttpEntity Represents an HTTP request or response entity, consisting of headers and body.
    // ResponseEntity это Extension of HttpEntity that adds a HttpStatus status code
    public ResponseEntity<PaymentsDTO> getPayment(@PathVariable("id") int id) {
        Payments payment = paymentService.getPayment(id);
        if (payment != null) {
            return new ResponseEntity<>(Assembler.getInstance().getPaymentDTO(payment), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
