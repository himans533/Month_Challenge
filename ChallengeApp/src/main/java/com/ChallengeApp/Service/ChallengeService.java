package com.ChallengeApp.Service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ChallengeApp.Dto.Challenge;
import com.ChallengeApp.Repository.ChallengeRepository;

@Service
public class ChallengeService {
	
//	private List<Challenge> challenges= new ArrayList<>();
	private Long nextid = 1L;
	
	@Autowired
	ChallengeRepository challengeRepository;
	
	
	public ChallengeService(ChallengeRepository challengeRepository) {
		this.challengeRepository = challengeRepository;
	}

//	public ChallengeService() {
//		Challenge challenge1= new Challenge( 1L , "January" , "Learn to the programming language");
//		challengeRepository.save(challenge1);
//	}
	
	public List<Challenge> getAllChallenges(){
		return challengeRepository.findAll();
		
	}
	
	public boolean AddChallenge(Challenge challenge) {
		if(challenge != null) {
		challenge.setId(nextid++);
		challengeRepository.save(challenge);
		return true;
		}
		else {
			return false;
		}
			
	}
      public Challenge getChallenge(String month) {
    	  
    	  Optional<Challenge> challenge= challengeRepository.findByMonthIgnoreCase(month);
    	 
		return challenge.orElse(null);
		
	}

      
	public boolean updatedChallenge(Long id, Challenge updatedChallenge) {
		
		Optional<Challenge> challenge= challengeRepository.findById(id);
		
			if(challenge.isPresent()) {
				Challenge updatedToChallenge = challenge.get();
				updatedToChallenge.setMonth(updatedChallenge.getMonth());
				updatedToChallenge.setDecription(updatedChallenge.getDecription());
				challengeRepository.save(updatedToChallenge);
				return true;
			}
		return false;
	}

	public boolean deletedChallenge(Long id) {
		Optional<Challenge> challenge= challengeRepository.findById(id);
		
		if( challenge.isPresent()) {
			challengeRepository.deleteById(id);
				return true;
		}
		else 
		return false;
	}	
	}
