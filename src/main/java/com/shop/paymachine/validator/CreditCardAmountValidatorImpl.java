package com.shop.paymachine.validator;

import com.shop.paymachine.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class CreditCardAmountValidatorImpl implements PaymentValidator {
    @Override
    public boolean process(Payment payment) {
        double amountMin = 10.0;
        return payment.getAmount() >= amountMin;
    }
}
