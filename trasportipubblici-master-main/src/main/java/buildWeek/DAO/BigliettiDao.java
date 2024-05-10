package buildWeek.DAO;

import buildWeek.Entity.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class BigliettiDao {

    private EntityManager em;

    public BigliettiDao(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(biglietto);
        et.commit();
    }

    public Biglietto getBigliettiById (int id) {
        return em.find(Biglietto.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Biglietto biglietto = getBigliettiById(id);

        if (biglietto != null) {
            em.remove(biglietto);
        } else {
            System.out.println("Biglietto non presente");
        }

        et.commit();
    }

    public List<Biglietto> getBigliettiByDistributoreId(int distributoreId) {
        Query query = em.createQuery(
                "SELECT YEAR(b.emissione), MONTH(b.emissione), COUNT(b) " +
                        "FROM Biglietto b " +
                        "WHERE b.distributoreAutomatico.id = :distributoreId " +
                        "GROUP BY YEAR(b.emissione), MONTH(b.emissione)");

        query.setParameter("distributoreId", distributoreId);
        return query.getResultList();
    }
}
