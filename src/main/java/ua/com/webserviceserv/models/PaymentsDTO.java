package ua.com.webserviceserv.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PaymentsDTO {
    @NotNull(message = "Field customerId cannot be null")
    private Integer customerId;

    @NotNull(message = "Field paymentAmount cannot be null")
    @Pattern(regexp = "[+]?[0-9]*\\.?[0-9]+", message = "Field paymentAmount cannot satisfy the pattern")
    private Float paymentAmount;

    @Pattern(regexp = "(^(((0[1-9]|1[0-9]|2[0-8])[\\-](0[1-9]|1[012]))|((29|30|31)[\\-](0[13578]|1[02]))|((29|30)[\\-](0[4,6,9]|11)))[\\-](19|[2-9][0-9])\\d\\d$)|(^29[\\-]02[\\-](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)", message = "Field paymentDate cannot satisfy the pattern dd-MM-yyyy")
    String paymentDate;

    String channel;

    public PaymentsDTO() {
    }

    public PaymentsDTO(Integer customerId, Float paymentAmount, String paymentDate, String channel) {
        this.customerId = customerId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.channel = channel;
    }

    public PaymentsDTO(Payments payment) {
        this.customerId = payment.getAbonentID().getAbonentID();
        this.paymentAmount = payment.getPaymentSum();
//        this.paymentDate = payment.getPaymentDateAsString();
        this.channel = payment.getChannel();
    }

    public Integer getCustomerId() {
        return customerId;
    }


    public Float getPaymentAmount() {
        return paymentAmount;
    }


    public String getPaymentDate() {
        return paymentDate;
    }


    public String getChannel() {
        return channel;
    }
}
