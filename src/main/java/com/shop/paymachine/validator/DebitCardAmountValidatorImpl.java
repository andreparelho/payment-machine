package com.shop.paymachine.validator;

import com.shop.paymachine.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class DebitCardAmountValidatorImpl implements PaymentValidator {
    @Override
    public boolean process(Payment payment) {
        double amountMin = 0.01;
        return payment.getAmount() >= amountMin;
    }
}
