package ua.com.webserviceserv.models;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    private static volatile Assembler instance;

    public static Assembler getInstance() {
        if (instance == null) {
            synchronized (Assembler.class) {
                if (instance == null) {
                    instance = new Assembler();
                }
            }
        }
        return instance;
    }

    public List<PaymentsDTO> getPaymentDToList(List<Payments> paymentList) {
        List<PaymentsDTO> paymentDTOList = new ArrayList<>();
        for (Payments payment : paymentList) {
            paymentDTOList.add(new PaymentsDTO(payment));
        }
        return  paymentDTOList;
    }

    public PaymentsDTO getPaymentDTO (Payments payment) {
        return  new PaymentsDTO(payment);
    }
}