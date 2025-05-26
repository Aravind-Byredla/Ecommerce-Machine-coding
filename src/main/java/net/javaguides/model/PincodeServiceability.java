package net.javaguides.model;

public class PincodeServiceability {
    private final String destinationPincode;
    private final PaymentMode paymentMode;

    public PincodeServiceability(String destinationPincode, PaymentMode paymentMode) {
        this.destinationPincode = destinationPincode;
        this.paymentMode = paymentMode;
    }


    public String getDestinationPincode() {
        return destinationPincode;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}
