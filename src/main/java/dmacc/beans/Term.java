package dmacc.beans;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="terms")
public class Term {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="termID")
	private long id;
	private Date startdate;
	private Date enddate;
	
	
	public Term() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Term(Date startdate, Date enddate) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
	}


	
	public Term(Date startdate) {
		super();
		this.startdate = startdate;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startdate;
	}
	public void setStartDate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEndDate() {
		return enddate;
	}
	public void setEndDate(Date enddate) {
		this.enddate = enddate;
	}


	//@Override
	//public String toString() {
	//	return "Term [id=" + id + ", startdate=" + startdate + ", enddate=" + enddate + "]";
	//}
	
}

