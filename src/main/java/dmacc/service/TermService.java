package dmacc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dmacc.model.Term;
import dmacc.repository.TermRepository;

@Service
public class TermService {
	private TermRepository termRepo;
	
	public TermService(TermRepository termRepository) {
		this.termRepo = termRepository;
	}
	
	public Term save(Term t) {
		return termRepo.save(t);
	}
	
	public Term findByTermCode(int termCode) {
		return termRepo.findByTermCode(termCode);
	}

	public List<Term> findAll(){
		List<Term> allTerms = termRepo.findAll();
		return allTerms;
	}


}
