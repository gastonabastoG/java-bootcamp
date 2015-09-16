package topic_0.key2.director;

import topic_0.key2.builder.CasaBuilder;
import topic_0.key2.producto.Casa;

public class CasaDirector {
    private final CasaBuilder builder;

    public CasaDirector(){
            builder = new CasaBuilder();
    }

    public void buildCasa(){

            builder.buildAmbiente();
            builder.buildParedes();
            builder.buildPiso();
            builder.buildTecho();

    }

    public Casa getCasa(){
            return builder.getCasa();
    }
}
