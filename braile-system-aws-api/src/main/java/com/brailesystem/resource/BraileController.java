package com.brailesystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brailesystem.service.BraileService;

@RestController
public class BraileController {
	
	@Autowired
	BraileService braileService;
	
	@RequestMapping(value = "convert", method = RequestMethod.GET)
	public ResponseEntity<?> covertBraile(@RequestParam String rows, @RequestParam String columns){
		String text=braileService.convertBrailetoText(rows, columns);
		
		return new ResponseEntity<>(text, HttpStatus.OK);
	}
}
