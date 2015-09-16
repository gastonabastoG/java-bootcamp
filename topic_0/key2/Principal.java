package topic_0.key2;

import topic_0.key2.director.CasaDirector;
import topic_0.key2.producto.Casa;

public class Principal {

    public static void main(String[] args) {
        CasaDirector director = new CasaDirector(); 
        director.buildCasa();
        Casa casa = director.getCasa();

        System.out.println(casa);
        System.out.println(casa.getTecho());
        System.out.println(casa.getAmbientes());
        System.out.println(casa.getPiso());
    }

}
