package topic_0.key2.builder;

import topic_0.key2.producto.Casa;
import topic_0.key2.producto.Pared;
import topic_0.key2.producto.Piso;
import topic_0.key2.producto.Techo;

public class CasaBuilder implements ICasa{
    private final Casa casa;

    public CasaBuilder() {
            this.casa = new Casa();
    }

    /*
     * Aplico solo el patron Builder; voy a crear solo un tipo de casa
     * @see topic_0.key2.Builder.ICasa#buildTecho()
     */
    @Override
    public void buildTecho() {
            this.casa.setTecho(new Techo(0,"paja", 2.0,2.0,2.0));
    }

    @Override
    public void buildParedes() {
            this.casa.setParedes(new Pared(0,2.0,2.0,2.0,"Ladrillo"));
    }

    @Override
    public void buildPiso() {
            this.casa.setPiso(new Piso(0,"Flotante",35));
    }

    @Override
    public void buildAmbiente() {
            this.casa.setAmbientes(1);
    }

    @Override
    public Casa getCasa() {
            return casa;
    }

}
