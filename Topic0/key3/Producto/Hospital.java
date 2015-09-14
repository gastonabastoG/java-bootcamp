package bootcamp.key3.Producto;

import java.util.List;

public abstract class Hospital {
	protected String name;
	protected List<Sector> sectors;

	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return Total of Patients
	 */
	public int TotalPatients(){
		int total=0;
		for (Sector sector : sectors) {
			for (Room room : sector.rooms) {
					total+=( room.getPatients() );
			}
		}
		return total;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Hospital [name=" + name + ", Patientes=" + TotalPatients() + "]";
	}

	
}
