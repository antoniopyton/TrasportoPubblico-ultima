package buildWeek.Entity;

import buildWeek.Enum.StatoDistributori;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distributori_automatici")
public class DistributoreAutomatico {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private StatoDistributori stato;

    @ManyToMany(mappedBy = "distributoriAutomatici")
    private List<BigliettoEAbbonamento> bigliettiEAbbonamenti;

    @OneToMany(mappedBy = "distributoreAutomatico")
    private List<Biglietto> biglietti;


    public DistributoreAutomatico(StatoDistributori stato, List<Biglietto> biglietti) {
        this.stato = stato;
        this.biglietti = biglietti;
    }



    public DistributoreAutomatico() {}

    public StatoDistributori getStato() {
        return stato;
    }

    public void setStato(StatoDistributori stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "id=" + id +
                ", stato=" + stato +
                ", bigliettiEAbbonamenti=" + bigliettiEAbbonamenti +
                ", biglietti=" + biglietti +
                '}';
    }
}
