package com.shop.paymachine.validator;

import com.shop.paymachine.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class CardNumberValidatorImpl implements PaymentValidator {
    @Override
    public boolean process(Payment payment) {
       int cardSize = 16;
       return payment.getCard() != null && payment.getCard().getNumber().length() == cardSize;
    }
}
