package dmacc.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.model.OfficeHour;
import dmacc.model.User;

public interface OfficeHourRepository extends JpaRepository<OfficeHour, Integer> {
	List<OfficeHour> findByUser(User user);
	List<OfficeHour> findByDayOfWeek(String dayOfWeek);
	
	List<OfficeHour> findByHourStart(LocalDateTime currentTime);
	
    List<OfficeHour> findAllByHourStartBetween(LocalDateTime hourStart, LocalDateTime hourEnd);
    
   // @Query("select a from OfficeHour a where a.hourStart <= :now and a.hourEnd >= :now")
   // List<OfficeHour> findAllWithDateTimeDuring(LocalDateTime now, LocalDateTime hourStart, LocalDateTime hourEnd);
 
}
