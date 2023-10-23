package com.shop.paymachine.controller;

import com.shop.paymachine.model.Payment;
import com.shop.paymachine.service.PaymentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private  static final Log log = LogFactory.getLog(PaymentController.class);

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process-payment")
    public ResponseEntity<String> processPayment(@RequestBody Payment payment){
        if (this.paymentService.processPayment(payment)){
            return ResponseEntity.ok("Pagamento feito com sucesso.");
        }
        log.debug(this.paymentService.processPayment(payment));
        log.debug(payment);
        return ResponseEntity.badRequest().body("Erro ao processar o pagamento");
    }
}
