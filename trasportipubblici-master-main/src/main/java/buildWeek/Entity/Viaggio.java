package buildWeek.Entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "viaggi")
public class Viaggio {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ora_partenza")
    private LocalTime oraPartenza;

    @Column(name = "ora_arrivo")
    private LocalTime oraArrivo;

    @OneToOne
    @JoinColumn(name = "biglietto_id")
    private Biglietto biglietto;

    @ManyToOne
    @JoinColumn(name = "abbonamento_id")
    private Abbonamento abbonamento;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    public Viaggio(LocalTime oraPartenza, LocalTime oraArrivo, Mezzo mezzo, Tratta tratta) {
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.mezzo = mezzo;
        this.tratta = tratta;
    }

    public Viaggio(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getOraPartenza() {
        return oraPartenza;
    }

    public void setOraPartenza(LocalTime oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public LocalTime getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(LocalTime oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }
}
