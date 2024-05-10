package buildWeek.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table (name = "manutenzioni")
public class Manutenzione  {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    /*@ManyToOne
    @JoinColumn(name = "id_mezzi")
    private List<Mezzo> mezzi; */

    @OneToOne
    @JoinColumn(name = "id_mezzo")
    private Mezzo mezzo;

    public Manutenzione(LocalDate dataInizio, LocalDate dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;

    }

    public Manutenzione(LocalDate dataInizio, LocalDate dataFine, Mezzo mezzo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.mezzo = mezzo;
    }

    public Manutenzione() {
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    /*public List<Mezzo> getMezzi() {
        return mezzi;
    }

    public void setMezzi(List<Mezzo> mezzi) {
        this.mezzi = mezzi;
    } */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }
}
