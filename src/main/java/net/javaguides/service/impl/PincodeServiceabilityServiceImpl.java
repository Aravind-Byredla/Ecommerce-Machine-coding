package net.javaguides.service.impl;

import net.javaguides.exception.EcommerceException;
import net.javaguides.model.PaymentMode;
import net.javaguides.model.PincodeServiceability;
import net.javaguides.repository.PincodeServiceabilityRepository;
import net.javaguides.service.PincodeServiceabilityService;

import java.util.HashMap;

public class PincodeServiceabilityServiceImpl implements PincodeServiceabilityService {
    PincodeServiceabilityRepository pincodeServiceabilityRepository;

    public PincodeServiceabilityServiceImpl(PincodeServiceabilityRepository pincodeServiceabilityRepository) {
        this.pincodeServiceabilityRepository = pincodeServiceabilityRepository;
    }



    @Override
    public Boolean createPincodeServiceability(String sourcePincode, String destinationPincode, PaymentMode paymentMode) throws EcommerceException {
        PincodeServiceability pincodeServiceability = new PincodeServiceability(destinationPincode, paymentMode);

        return pincodeServiceabilityRepository.createPincodeServiceability(sourcePincode, pincodeServiceability);
    }

    @Override
    public Boolean checkIsSrcAndDestnPincodeMatchesForPaymentType(String sourcePincode, String destinationPincode, PaymentMode paymentMode) throws EcommerceException {
        HashMap<String, PaymentMode> allDestinationPinCodes = pincodeServiceabilityRepository.getAllDestinationPinCodes(sourcePincode);

        return allDestinationPinCodes.containsKey(destinationPincode) &&
                paymentMode.equals(allDestinationPinCodes.get(destinationPincode));
    }
}
