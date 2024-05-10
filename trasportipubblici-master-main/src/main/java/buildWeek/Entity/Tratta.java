package buildWeek.Entity;

import buildWeek.Enum.Servizio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tratta")
public class Tratta {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="zona_partenza")
    private String zonaPartenza;

    private String capolinea;

    @Column(name="tempo_medio_in_minuti")
    private double tempoMedio;



    public Tratta( String zonaPartenza, String capolinea, double tempoMedio, List<Mezzo> mezzi) {

        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoMedio = tempoMedio;

    }
    public Tratta (){

    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public double getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(double tempoMedio) {
        this.tempoMedio = tempoMedio;
    }


}
