package bootcamp.key3.Producto;

/**
 * @author Guille
 *  Sala/Room : People can recover here
 */
public class Room {
	
	private int beds;
	private int patients;
	
	public Room(int numberOfBeds){
		beds=numberOfBeds;
		patients=0;
	}
	
	
	/**
	 * Patient enters
	 * @return if are space for the new guest
	 */
	public boolean addPatient(){
		if(patients<beds){
			patients++;
			return true;
		}
		else
			return false;
			
	}
	
	/**
	 * Patient leaves (the hospital or is translated)
	 */
	public void removePatient(){
		if(patients>0)
			patients--;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getPatients() {
		return patients;
	}

	public void setPatients(int patients) {
		this.patients = patients;
	}
	
	
	

}
