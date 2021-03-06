package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Term;

@Repository
public interface TermRepository extends JpaRepository<Term, Integer>{
	Term findByTermCode(int termCode);
}
