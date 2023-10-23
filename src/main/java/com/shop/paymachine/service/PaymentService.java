package com.shop.paymachine.service;

import com.shop.paymachine.factory.ValidatorFactory;
import com.shop.paymachine.model.Payment;
import com.shop.paymachine.validator.PaymentValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final ValidatorFactory validatorFactory;

    public PaymentService(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public boolean processPayment(Payment payment){
        List<PaymentValidator> validatorList = this.validatorFactory.getValidators(payment.getCard().getCardType());
        for (PaymentValidator paymentValidator : validatorList) {
            if (!paymentValidator.process(payment)){
                return false;
            }
        }
        return true;
    }
}
