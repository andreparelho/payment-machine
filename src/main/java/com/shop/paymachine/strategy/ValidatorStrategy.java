package com.shop.paymachine.strategy;

import com.shop.paymachine.validator.PaymentValidator;

import java.util.List;

public interface ValidatorStrategy {
    List<PaymentValidator> getValidators();
}
