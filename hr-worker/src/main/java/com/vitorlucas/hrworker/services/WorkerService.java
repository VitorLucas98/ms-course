package com.vitorlucas.hrworker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitorlucas.hrworker.entities.Worker;
import com.vitorlucas.hrworker.entities.dto.WorkerDTO;
import com.vitorlucas.hrworker.repository.WorkerRepository;
import com.vitorlucas.hrworker.services.exceptions.ResourceNotFoundException;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;
	
	public List<WorkerDTO> findAll(){
		List<Worker> list = repository.findAll();
		return list.stream().map(x -> new WorkerDTO(x)).collect(Collectors.toList());
	}
	
	public WorkerDTO findById(Long id) {
		Optional<Worker> worker = repository.findById(id);
		Worker entity = worker.orElseThrow(() -> new ResourceNotFoundException("id not found"));
		return new WorkerDTO(entity);
	}
	
}
