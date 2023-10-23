package com.shop.paymachine.strategy;

import com.shop.paymachine.validator.CardNumberValidatorImpl;
import com.shop.paymachine.validator.PaymentValidator;
import com.shop.paymachine.validator.VoucherCardAmountValidatorImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("voucher-strategy")
public class VoucherCardStrategyImpl implements ValidatorStrategy {
    private final CardNumberValidatorImpl cardNumberSizeValidator;
    private final VoucherCardAmountValidatorImpl voucherCardAmountValidator;

    public VoucherCardStrategyImpl(CardNumberValidatorImpl cardNumberSizeValidator, VoucherCardAmountValidatorImpl voucherCardAmountValidator) {
        this.cardNumberSizeValidator = cardNumberSizeValidator;
        this.voucherCardAmountValidator = voucherCardAmountValidator;
    }

    @Override
    public List<PaymentValidator> getValidators() {
        return List.of(this.cardNumberSizeValidator, this.voucherCardAmountValidator);
    }
}
