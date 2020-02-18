package dmacc.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmacc.model.OfficeHour;
import dmacc.model.User;
import dmacc.repository.OfficeHourRepository;

@Service
public class HourService {
	private OfficeHourRepository officeHourRepository;
	
	@Autowired
	public HourService(OfficeHourRepository officeHoursRepository) {
		this.officeHourRepository = officeHoursRepository;
		
	}

	public OfficeHour save(OfficeHour hour) {
		// TODO Auto-generated method stub
		return officeHourRepository.save(hour);
	}
	
	public List<OfficeHour> findByUser(User user){
		return officeHourRepository.findByUser(user);
	}
	
	public List<OfficeHour> findByDayOfWeek(String dayOfWeek){
		return officeHourRepository.findByDayOfWeek(dayOfWeek);
	}

	public List<OfficeHour> findByHourStart(LocalDateTime now){
		return officeHourRepository.findByHourStart(now);
	}
	 
}
