package com.shop.paymachine.factory;

import com.shop.paymachine.strategy.ValidatorStrategy;
import com.shop.paymachine.validator.PaymentValidator;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorFactoryImpl implements ValidatorFactory {
    private final Map<String, ValidatorStrategy> validatorStrategyMap;

    public ValidatorFactoryImpl(Map<String, ValidatorStrategy> validatorStrategyMap) {
        this.validatorStrategyMap = validatorStrategyMap;
    }

    @Override
    public List<PaymentValidator> getValidators(String cardType) {
        String beanName = MessageFormat.format("{0}-{1}", cardType.toLowerCase(), "strategy");
        ValidatorStrategy validatorStrategy = validatorStrategyMap.get(beanName);
        return validatorStrategy.getValidators();
    }
}
