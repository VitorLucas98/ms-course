package com.vitorlucas.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlucas.hrpayroll.entities.Payment;
import com.vitorlucas.hrpayroll.entities.Worker;
import com.vitorlucas.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient; 
	
	public Payment getPayment(Long workerId, Integer days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();
		System.out.print(worker.toString());
		Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
		
		return payment;
	}
}
