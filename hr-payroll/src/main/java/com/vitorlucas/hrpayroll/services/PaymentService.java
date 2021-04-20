package com.vitorlucas.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.vitorlucas.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Integer days) {
		Payment payment = new Payment("Bob mike",200.0 , days);
		return payment;
	}
}
