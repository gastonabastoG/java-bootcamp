package topic_0.key3;

import topic_0.key3.factory.HospitalFactory;
import topic_0.key3.producto.Hospital;
import topic_0.key3.producto.Privado;
import topic_0.key3.producto.Publico;


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
