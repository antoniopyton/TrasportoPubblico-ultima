package buildWeek.DAO;

import buildWeek.Entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtentiDao {


    private EntityManager em;

    public UtentiDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getUtenteById (int id) {
        return em.find(Utente.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Utente utente = getUtenteById(id);

        if (utente != null) {
            em.remove(utente);
        } else {
            System.out.println("Utente non presente");
        }

        et.commit();
    }

}
