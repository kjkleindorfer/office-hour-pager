package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.model.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Integer>{

}
