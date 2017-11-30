//package ua.com.webserviceserv.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import ua.com.webserviceserv.models.Abonents;
//import ua.com.webserviceserv.models.Assembler;
//import ua.com.webserviceserv.models.Payments;
//import ua.com.webserviceserv.models.PaymentsDTO;
//import ua.com.webserviceserv.services.AbonentsService;
//import ua.com.webserviceserv.services.PaymentsService;
//
//import java.util.List;
//
//@RestController
//// это тот же @Controller, но к его методам необязательно добавлять @ResponseBody
//public class AppController {
//
//    @Autowired
//    private PaymentsService paymentsService;
//
//    @Autowired
//    private AbonentsService abonentsService;
//
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView getIndex() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView getError() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/payments")
//    public ModelAndView allPayments() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("paymentsList", paymentsService.getAllPayments());
//        modelAndView.setViewName("payments");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/payments", method = RequestMethod.POST)
//    public ModelAndView addPayment(@ModelAttribute("newPayment") PaymentsDTO newPayment) {
//        Abonents abonents = abonentsService.getAbonent(newPayment.getCustomerId());
//
//        paymentsService.makePayment(abonents, newPayment);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:payments");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/makepayment", method = RequestMethod.GET)
//    public ModelAndView addPayment() {
//        ModelAndView modelAndView = new ModelAndView();
//        PaymentsDTO paymentDTO = new PaymentsDTO();
//        modelAndView.addObject("newPayment", paymentDTO);
//        modelAndView.setViewName("makepayment");
//        return modelAndView;
//    }
//
////    @RequestMapping(value = "/payments/{id}", method = RequestMethod.GET)
////    public ModelAndView getPayment(@PathVariable("id") int id, Model model) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("payment");
////        modelAndView.addObject("onePayment", paymentService.getPayment(id));
////
////        return modelAndView;
////    }
//
//    /**
//     * 1.1 Get payment by id
//     *
//     * @param id paymen ID
//     * @return Payment
//     */
//    @RequestMapping(
//            value = "/payments/{id}"
//            , method = RequestMethod.GET
//            , headers = {"Accept=application/json"})
//    // HttpEntity Represents an HTTP request or response entity, consisting of headers and body.
//    // ResponseEntity это Extension of HttpEntity that adds a HttpStatus status code
//    public ResponseEntity<PaymentsDTO> getPayment(@PathVariable("id") int id) {
//        Payments payment = paymentsService.getPayment(id);
//        if (payment != null) {
//            return new ResponseEntity<>(Assembler.getInstance().getPaymentDTO(payment), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    /**
//     * 1.2 Get payment by id and customerID
//     *
//     * @param id         payment ID
//     * @param customerId customerID
//     * @return Payment
//     */
//    @RequestMapping(
//            value = "/payments/{customerId}/{id}"
//            , method = RequestMethod.GET
//            , headers = {"Accept=application/json"}
//    )
//    public ResponseEntity<PaymentsDTO> getPaymentByIdCustomerId
//    (@PathVariable("customerId") int customerId, @PathVariable("id") int id) {
//        Abonents customer = abonentsService.getAbonent(customerId);
//        if (customer != null) {
//            Payments payment = paymentsService.getPayment(id, customerId);
//            if (payment != null) {
//                return new ResponseEntity<>(Assembler.getInstance().getPaymentDTO(payment), HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    /**
//     * 1.3 Get payments list by customerID
//     *
//     * @param customerId id of customer
//     * @return List of payments
//     */
////    @RequestMapping(
////            value = "/paymentsall/{customerId}"
////            , method = RequestMethod.GET
////            , headers = {"Accept=application/json"})
////    public ResponseEntity<List<PaymentsDTO>> getPaymentsList(@PathVariable("customerId") int customerId) {
////        Abonents customer = abonentsService.getAbonent(customerId);
////        if (customer != null) {
////            List<Payments> paymentList = paymentsService.ge(customer);
////            return new ResponseEntity<>(Assembler.getInstance().getPaymentDToList(paymentList), HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//
//    /**
//     * 2.1 Create payment of customerID
//     *
//     * @param paymentDTO json like {"customerId":"1","paymentDate":"11-11-2011","channel":"fignya","paymentAmount":"21"}
//     * @return payment id, -1 if wrong
//     */
//    @RequestMapping(value = "/paymentcreate", method = RequestMethod.POST
//            , headers = {"Accept=application/json"})
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public Integer create(@RequestBody PaymentsDTO paymentDTO) {
//        return paymentsService.create(paymentDTO);
//    }
//
//    /**
//     * 3.1 Update payment by id
//     *
//     * @param id         payment ID
//     * @param paymentDTO data to update. json like {"customerId":"1","paymentDate":"11-11-2011","channel":"fignya","paymentAmount":"21"}
//     * @return "Payment " + id + " updated"
//     */
////    @RequestMapping(value = "/paymentupdate/{id}", method = RequestMethod.PUT)
////    public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody PaymentsDTO paymentDTO) {
////        Payments payment = paymentsService.getPayment(id);
////        if (payment == null) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////        paymentsService.updatePayment(payment, paymentDTO);
////        return new ResponseEntity<>("Payment " + id + " updated", HttpStatus.OK);
////    }
//
//    /**
//     * 4.1 Delete payment by id
//     *
//     * @param id id of payment
//     * @return "Payment " + id + " deleted"
//     */
////    @RequestMapping(value = "/paymentdelete/{id}", method = RequestMethod.DELETE)
////    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
////
////        Payments payment = paymentService.getPayment(id);
////        if (payment == null) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////        paymentService.deletePayment(id);
////        return new ResponseEntity<>("Payment " + id + " deleted", HttpStatus.OK);
////    }
//     /*
//     * 1. Get payments:
//     * 1.1 Get payment by id
//     * 1.2 Get payment by id and customerID
//     * 1.3 Get payments list by customerID
//     * 2. Create payments:
//     * 2.1 Create payment of customerID
//     * 3. Update payments:
//     * 3.1 Update payment by id
//     * 4. Delete payments:
//     * 4.1 Delete payment by id
//     * */
//
//}
//
