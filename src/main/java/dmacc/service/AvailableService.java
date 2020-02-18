package dmacc.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmacc.model.OfficeHour;
import dmacc.model.User;
import dmacc.repository.OfficeHourRepository;

@Service
public class AvailableService {
	private OfficeHourRepository officeHourRepository;
	
	@Autowired
	public AvailableService(OfficeHourRepository officeHoursRepository) {
		this.officeHourRepository = officeHoursRepository;
		
	}
	
	public List<OfficeHour> findCurrentOfficeHours(){
		List<OfficeHour> currentOfficeHours = new ArrayList<OfficeHour>();
		LocalDateTime now = LocalDateTime.now();
		DayOfWeek dayOfWeek = DayOfWeek.from(now);
		String currentDayOfWeek = dayOfWeek.name();
		
		currentOfficeHours = officeHourRepository.findByDayOfWeek(currentDayOfWeek);
		
		
		return currentOfficeHours;
	}

}
