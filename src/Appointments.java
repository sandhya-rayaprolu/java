import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Appointments {
	
	public List<Appointment> setOverlap(List<Appointment> appList){
		Calendar latestEndtime =  appList.get(0).getEndTime();
		for(int i=0;i<appList.size()-1;i++){
			Appointment currAppt = appList.get(i);
			Appointment nextAppt = appList.get(i+1);
			if(currAppt.getEndTime().after(latestEndtime)){
				latestEndtime = currAppt.getEndTime();
			}
			if(latestEndtime.after(nextAppt.getStartTime())){
				currAppt.setOverlap(true);
				nextAppt.setOverlap(true);
			}
		}
		return appList;
	}
	
	public static void main(String[] args) {
		Appointments appts = new Appointments();
		List<Appointment> appList = new ArrayList<>();
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,10,30,0),new GregorianCalendar(2015,5,12,11,30,0),false));
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,11,00,0),new GregorianCalendar(2015,5,12,12,30,0),false));
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,12,30,0),new GregorianCalendar(2015,5,12,13,30,0),false));
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,12,00,0),new GregorianCalendar(2015,5,12,13,30,0),false));
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,14,30,0),new GregorianCalendar(2015,5,12,15,30,0),false));
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,17,30,0),new GregorianCalendar(2015,5,12,19,00,0),false));
		appList.add(new Appointment(new GregorianCalendar(2015,5,12,19,30,0),new GregorianCalendar(2015,5,12,20,30,0),false));
		appts.setOverlap(appList);
		for(int i=0;i<appList.size();i++){
			Appointment appt =  appList.get(i);
			System.out.println("From: "+appt.getStartTime()+" To: "+appt.getEndTime()+" Overlaps: "+appt.isOverlap());
		}
	}

}
class Appointment{

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public boolean isOverlap() {
		return overlap;
	}

	public void setOverlap(boolean overlap) {
		this.overlap = overlap;
	}

	private Calendar startTime;
	private Calendar endTime;
	private boolean overlap;
	
	public Appointment(Calendar start, Calendar end, boolean hasOverlap) {
		this.startTime = start;
		this.endTime = end;
		this.overlap = hasOverlap;
	}
}