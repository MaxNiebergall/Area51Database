import java.util.Date;

public class EventItem {
	
	String action="";
	Alien item;
	Date now;
	
	EventItem(String action, Alien item){
		 now = new Date();	
		 this.action=action;
		 this.item=item;
	}
	
}
