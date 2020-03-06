package dmacc.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "officehour")
public class OfficeHour {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hour_id")
	private int id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Term term;
	
	@Column(name="day_of_week")
	private String dayOfWeek;
	
	@Column(name = "hour_start")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime hourStart;
	
	@Column(name = "hour_end")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime hourEnd;

}
