package com.shop.paymachine.strategy;

import com.shop.paymachine.validator.CardNumberValidatorImpl;
import com.shop.paymachine.validator.CreditCardAmountValidatorImpl;
import com.shop.paymachine.validator.PaymentValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("credit-strategy")
public class CreditCardStrategyImpl implements ValidatorStrategy {
    private final CardNumberValidatorImpl cardNumberSizeValidator;
    private final CreditCardAmountValidatorImpl creditCardAmountValidator;

    public CreditCardStrategyImpl(CardNumberValidatorImpl cardNumberSizeValidator, CreditCardAmountValidatorImpl creditCardAmountValidator) {
        this.cardNumberSizeValidator = cardNumberSizeValidator;
        this.creditCardAmountValidator = creditCardAmountValidator;
    }

    @Override
    public List<PaymentValidator> getValidators() {
        return List.of(this.creditCardAmountValidator, this.cardNumberSizeValidator);
    }
}
