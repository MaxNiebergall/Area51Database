
public class Alien {
	
	private String			name;
	private String			homeWorld;
	private String			holdingCell;
	private String			biography;
	private String			notes;
	private Base.Hostility	hostility;
	
	public Alien(String na, String hm, String c, String b, String no, Base.Hostility i) {
		setName(na);
		homeWorld = hm;
		holdingCell = c;
		biography = b;
		notes = no;
		setHostility(i);
	}
	
	public String getName() {
		return name.trim();
	}
	
	public void setName(String name) {
		int count;
		count = (name.length() - 32);
		this.name = name;
		if (count < 0) {
			for (int i = -(count); i > 0; i--) {
				this.name += " ";
			}
		}
	}
	
	public String getHomeWorld() {
		return homeWorld.trim();
	}
	
	public void setHomeWorld(String homeWorld) {
		this.homeWorld = homeWorld;
		int count;
		count = (homeWorld.length() - 32);
		if (count < 0) {
			for (int i = -(count); i > 0; i--) {
				this.homeWorld += " ";
			}
		}
	}
	
	public String getHoldingCell() {
		return holdingCell.trim();
	}
	
	public void setHoldingCell(String holdingCell) {
		this.holdingCell = holdingCell;
		int count;
		count = (holdingCell.length() - 32);
		if (count < 0) {
			for (int i = -(count); i > 0; i--) {
				this.holdingCell += " ";
			}
		}
	}
	
	public String getBiography() {
		return biography;
	}
	
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Base.Hostility getHostility() {
		return hostility;
	}
	
	public void setHostility(Base.Hostility other) {
		this.hostility = other;
	}
	
	public int getHostilityAsInt() {
		if (this.getHostility() == Base.Hostility.NONE) {
			return 0;
		}
		else if (this.getHostility() == Base.Hostility.LOW) {
			return 1;
		}
		else if (this.getHostility() == Base.Hostility.MEDIUM) {
			return 2;
		}
		else if (this.getHostility() == Base.Hostility.HIGH) {
			return 3;
		}
		else if (this.getHostility() == Base.Hostility.EXTREME) {
			return 4;
		}
		
		else return -1;
	}

	public Base.Hostility incrementedHostility() {
		if (this.getHostility() == Base.Hostility.NONE) {
			return Base.Hostility.LOW;
		}
		else if (this.getHostility() == Base.Hostility.LOW) {
			return Base.Hostility.MEDIUM;
		}
		else if (this.getHostility() == Base.Hostility.MEDIUM) {
			return Base.Hostility.HIGH;
		}
		else if (this.getHostility() == Base.Hostility.HIGH) {
			return Base.Hostility.EXTREME;
		}
		else if (this.getHostility() == Base.Hostility.EXTREME) {
			return Base.Hostility.NONE;
		}
		
		else return Base.Hostility.NONE;
	}
}
