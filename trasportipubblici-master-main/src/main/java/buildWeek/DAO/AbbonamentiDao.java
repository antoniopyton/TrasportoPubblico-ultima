package buildWeek.DAO;

import buildWeek.Entity.Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbbonamentiDao {

    private EntityManager em;

    public AbbonamentiDao(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(abbonamento);
        et.commit();
    }

    public Abbonamento getAbbonamentoById (int id) {
        return em.find(Abbonamento.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Abbonamento abbonamento = getAbbonamentoById(id);

        if (abbonamento != null) {
            em.remove(abbonamento);
        } else {
            System.out.println("Abbonamento non presente");
        }

        et.commit();
    }

}
