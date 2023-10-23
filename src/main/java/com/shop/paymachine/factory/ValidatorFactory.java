package com.shop.paymachine.factory;

import com.shop.paymachine.validator.PaymentValidator;

import java.util.List;

public interface ValidatorFactory {
    List<PaymentValidator> getValidators(String cardType);
}
