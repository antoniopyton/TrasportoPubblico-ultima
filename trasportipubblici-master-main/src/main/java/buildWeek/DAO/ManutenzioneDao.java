package buildWeek.DAO;

import buildWeek.Entity.Manutenzione;
import buildWeek.Entity.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ManutenzioneDao {
    private EntityManager em;

    public ManutenzioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(List<Manutenzione> manutenzioni) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        for (Manutenzione manutenzione : manutenzioni) {
            em.persist(manutenzione);
        }
        et.commit();
    }

    public Manutenzione getManutenzioniById (int id) {
        return em.find(Manutenzione.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Manutenzione manutenzione = getManutenzioniById(id);

        if (manutenzione != null) {
            em.remove(manutenzione);
        } else {
            System.out.println("Manutenzione non effettuata");
        }

        et.commit();
    }
}
