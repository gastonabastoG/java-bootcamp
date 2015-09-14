package bootcamp.key3;

import bootcamp.key3.Producto.Hospital;
import bootcamp.key3.Producto.Privado;
import bootcamp.key3.Producto.Publico;


public class Principal {

	public static void main(String[] args) {
		Hospital hospital;
		Privado privadoHospital;
		privadoHospital = (Privado) HospitalFactory.createHospital(Privado.class);
		privadoHospital.setName("Vip");
		privadoHospital.registerGuest();
		hospital = privadoHospital;
		
		System.out.println(hospital.toString());
		
		Publico publicoHospital;
		publicoHospital = (Publico) HospitalFactory.createHospital(Publico.class);
		publicoHospital.setName("Vecinal");
		
		System.out.println(publicoHospital.toString());
		System.out.println(privadoHospital.toString());
		
	}

}
