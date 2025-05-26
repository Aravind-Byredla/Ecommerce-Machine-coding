package net.javaguides.repository;

import net.javaguides.model.PaymentMode;
import net.javaguides.model.PincodeServiceability;

import java.util.HashMap;

public class PincodeServiceabilityRepository {
    HashMap<String, HashMap<String, PaymentMode>> pinCodes;

    public PincodeServiceabilityRepository(){
        pinCodes = new HashMap<>();
    }

    public Boolean createPincodeServiceability(String sourcePincode, PincodeServiceability pincodeServiceability){
        if(pinCodes.get(sourcePincode) == null){
            HashMap<String, PaymentMode> destinationPincode = new HashMap<>();

            destinationPincode.put(pincodeServiceability.getDestinationPincode(), pincodeServiceability.getPaymentMode());
            pinCodes.put(sourcePincode, destinationPincode);
        }

        return true;
    }

    public HashMap<String, PaymentMode> getAllDestinationPinCodes(String sourcePincode){
        return pinCodes.get(sourcePincode);
    }
}
