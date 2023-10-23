package com.shop.paymachine.strategy;

import com.shop.paymachine.validator.CardNumberValidatorImpl;
import com.shop.paymachine.validator.DebitCardAmountValidatorImpl;
import com.shop.paymachine.validator.PaymentValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("debit-strategy")
public class DebitCardStrategyImpl implements ValidatorStrategy {
    private final DebitCardAmountValidatorImpl debitCardAmountValidator;
    private final CardNumberValidatorImpl cardNumberSizeValidator;

    public DebitCardStrategyImpl(DebitCardAmountValidatorImpl debitCardAmountValidator, CardNumberValidatorImpl cardNumberSizeValidator) {
        this.debitCardAmountValidator = debitCardAmountValidator;
        this.cardNumberSizeValidator = cardNumberSizeValidator;
    }

    @Override
    public List<PaymentValidator> getValidators() {
        return List.of(this.cardNumberSizeValidator, this.debitCardAmountValidator);
    }
}
