package buildWeek.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rivenditori")
public class Rivenditore  {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String indirizzo;

    @ManyToMany(mappedBy = "rivenditori")
    private List<BigliettoEAbbonamento> bigliettiEAbbonamenti;

    @OneToMany(mappedBy = "rivenditore")
    private List<Biglietto> biglietti;

    public Rivenditore(String nome, String indirizzo, List<Biglietto> biglietti) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.biglietti = biglietti;
    }

    public Rivenditore (){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<BigliettoEAbbonamento> getBigliettiEAbbonamenti() {
        return bigliettiEAbbonamenti;
    }

    public void setBigliettiEAbbonamenti(List<BigliettoEAbbonamento> bigliettiEAbbonamenti) {
        this.bigliettiEAbbonamenti = bigliettiEAbbonamenti;
    }
}
