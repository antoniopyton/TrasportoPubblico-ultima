package buildWeek.DAO;

import buildWeek.Entity.DistributoreAutomatico;
import buildWeek.Entity.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class RivenditoreDao {

    private EntityManager em;

    public RivenditoreDao(EntityManager em) {
        this.em = em;
    }

    public void save(List<Rivenditore> rivenditori) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        for (Rivenditore rivenditore : rivenditori) {
            em.persist(rivenditore);
        }
        et.commit();
    }

    public Rivenditore getRivenditoreById (int id) {
        return em.find(Rivenditore.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Rivenditore rivenditore = getRivenditoreById(id);

        if (rivenditore != null) {
            em.remove(rivenditore);
        } else {
            System.out.println("Rivenditore non attivo");
        }

        et.commit();
    }

    public List<Object[]> getBigliettiPerRivenditore() {
        Query query = em.createNativeQuery(
                "SELECT d.id, EXTRACT(YEAR FROM b.emissione) AS anno, EXTRACT(MONTH FROM b.emissione) AS mese, COUNT(b.id) AS num_biglietti " +
                        "FROM biglietti b " +
                        "INNER JOIN rivenditori d ON b.rivenditore_id = d.id " +
                        "GROUP BY d.id, EXTRACT(YEAR FROM b.emissione), EXTRACT(MONTH FROM b.emissione)");
        return query.getResultList();
    }

}
