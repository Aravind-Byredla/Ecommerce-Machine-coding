package net.javaguides.service;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.PaymentMode;

public interface PincodeServiceabilityService {
    Boolean createPincodeServiceability(String sourcePincode,
                                        String destinationPincode,
                                        PaymentMode paymentMode)
            throws EcommerceException;
    Boolean checkIsSrcAndDestnPincodeMatchesForPaymentType(
            String sourcePincode,
            String destinationPincode,
            PaymentMode paymentMode
    )
            throws EcommerceException;
}
