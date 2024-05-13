package com.ChallengeApp.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ChallengeApp.Dto.Challenge;
import com.ChallengeApp.Service.ChallengeService;

@RestController
@RequestMapping("/challenge")
@CrossOrigin( origins = "http://localhost:3000")
public class ChallengeController {
	
	@Autowired
	private ChallengeService challengeService;
	
	
	public ChallengeController(ChallengeService challengeService) {		
		this.challengeService = challengeService;
	}


	@GetMapping
	public ResponseEntity<List<Challenge>> getAllChallenge(){
			return new ResponseEntity<> (challengeService.getAllChallenges() , HttpStatus.OK);
			
	}
	
	@PostMapping
	public ResponseEntity< String> AddChallenge(@RequestBody Challenge challenge) {
		
	     boolean isChallengeAdded= challengeService.AddChallenge(challenge);
		if(isChallengeAdded) {
			return new ResponseEntity<> ("challenge add successfully" ,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> ("challenge not add successfully", HttpStatus.NOT_FOUND);
		}
	}	
	
	
	@GetMapping("/{month}")
	public ResponseEntity<Challenge> getChallenge(@PathVariable String  month) {		
		Challenge challenge = challengeService.getChallenge(month);
	   if( challenge != null) {
		   return new ResponseEntity<>( challenge , HttpStatus.OK)  ;
	   }
	   else {
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<String > UpdatedChallenge (@PathVariable Long id ,@RequestBody Challenge updatedChallenge){
		boolean ischallengeupdated = challengeService.updatedChallenge(id ,updatedChallenge);
		
		if(ischallengeupdated) {
			return new ResponseEntity<> ("challenge updated successfully" ,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> ("challenge not updated successfully", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletedChallenge (@PathVariable Long id){
		
           boolean ischallengedeleted = challengeService.deletedChallenge(id);
		
		if(ischallengedeleted) {
			return new ResponseEntity<> ("challenge deleted successfully" ,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> ("challenge not deleted successfully", HttpStatus.NOT_FOUND);
		}
		
	}
}
