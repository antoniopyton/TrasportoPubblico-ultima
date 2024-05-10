package buildWeek.Entity;

import buildWeek.Enum.CapienzaMezzo;
import buildWeek.Enum.Servizio;
import buildWeek.Enum.TipoMezzo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Servizio servizio;

    @Enumerated(EnumType.STRING)
    private CapienzaMezzo capienza;

    @Enumerated(EnumType.STRING)
    private TipoMezzo tipoMezzo;

    @OneToOne(mappedBy = "mezzo")
    private Manutenzione manutenzione;

    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi;

    @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> biglietti;

    public Mezzo( Servizio servizio, CapienzaMezzo capienza, TipoMezzo tipoMezzo) {

        this.servizio = servizio;
        this.capienza = capienza;
        this.tipoMezzo = tipoMezzo;
        this.viaggi = new ArrayList<>();
        this.biglietti = new ArrayList<>();
    }

    public Mezzo() {
        this.viaggi = new ArrayList<>();
        this.biglietti = new ArrayList<>();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public Servizio getServizio() {
        return servizio;
    }

    public void setServizio(Servizio servizio) {
        this.servizio = servizio;
    }

    public CapienzaMezzo getCapienza() {
        return capienza;
    }

    public void setCapienza(CapienzaMezzo capienza) {
        this.capienza = capienza;
    }

    public Manutenzione getManutenzione() {
        return manutenzione;
    }

    public void setManutenzione(Manutenzione manutenzione) {
        this.manutenzione = manutenzione;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    public void addViaggio(Viaggio viaggio) {
        this.viaggi.add(viaggio);
    }

    public void addBiglietto(Biglietto biglietto) {
        this.biglietti.add(biglietto);
    }
}
