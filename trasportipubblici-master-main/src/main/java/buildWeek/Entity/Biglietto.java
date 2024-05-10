package buildWeek.Entity;

import net.bytebuddy.matcher.InheritedAnnotationMatcher;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "biglietti")
public class Biglietto extends BigliettoEAbbonamento {

    @Id
    private Integer id;

    private boolean timbrato;

    private LocalTime inizio;

    private LocalTime scadenza;

    private LocalDate emissione;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private  Mezzo mezzo;


    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToOne(mappedBy = "biglietto")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name="tratte_id")
    private Tratta tratta;

    @ManyToOne
    @JoinColumn(name = "dist_auto_id")
    private DistributoreAutomatico distributoreAutomatico;

    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    private Rivenditore rivenditore;

    public Biglietto( boolean timbrato, LocalTime inizio, LocalTime scadenza, Utente utente, Tratta tratta, Rivenditore rivenditore, LocalDate emissione) {
        this.timbrato = timbrato;
        this.inizio = inizio;
        this.scadenza = scadenza;
        this.utente = utente;
        this.tratta = tratta;
        this.rivenditore = rivenditore;
        this.emissione = emissione;
    }

    public Biglietto(boolean timbrato, LocalTime inizio, LocalTime scadenza, Utente utente, Tratta tratta, DistributoreAutomatico distributoreAutomatico, LocalDate emissione) {
        this.timbrato = timbrato;
        this.inizio = inizio;
        this.scadenza = scadenza;
        this.utente = utente;
        this.tratta = tratta;
        this.distributoreAutomatico = distributoreAutomatico;
        this.emissione = emissione;
    }

    public Biglietto() {

    }

    public boolean isTimbrato() {
        return timbrato;
    }

    public void setTimbrato(boolean timbrato) {
        this.timbrato = timbrato;
    }

    public LocalTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalTime inizio) {
        this.inizio = inizio;
    }

    public LocalTime getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalTime scadenza) {
        this.scadenza = scadenza;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public void setEmissione(LocalDate emissione) {
        this.emissione = emissione;
    }
}
