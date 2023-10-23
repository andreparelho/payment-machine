package com.shop.paymachine.validator;

import com.shop.paymachine.model.Payment;

public interface PaymentValidator {
    boolean process(Payment payment);
}
