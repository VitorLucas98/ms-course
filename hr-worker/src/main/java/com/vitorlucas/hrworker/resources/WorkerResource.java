package com.vitorlucas.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitorlucas.hrworker.entities.dto.WorkerDTO;
import com.vitorlucas.hrworker.services.WorkerService;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Autowired
	private Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private WorkerService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("PORT = "+ env.getProperty("local.server.port"));
		WorkerDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll(){
		List<WorkerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}		

}
