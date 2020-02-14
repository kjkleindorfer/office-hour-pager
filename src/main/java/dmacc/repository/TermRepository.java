package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Term;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> { 
	
	
}