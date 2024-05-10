package buildWeek.Entity;

import buildWeek.Enum.Tessera;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Tessera tessera;

    private String nome;

    private String cognome;

    @OneToMany(mappedBy = "utente")
    private List<Biglietto> biglietto;

    @OneToOne(mappedBy = "utente")
    private Abbonamento abbonamento;

    public Utente( Tessera tessera, String nome, String cognome) {
        this.tessera = tessera;
        this.nome = nome;
        this.cognome = cognome;
    }
    public Utente(){

       }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }
}
