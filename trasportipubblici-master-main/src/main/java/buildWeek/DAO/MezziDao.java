package buildWeek.DAO;

import buildWeek.Entity.Mezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MezziDao {

    private EntityManager em;

    public MezziDao(EntityManager em) {
        this.em = em;
    }

    public void save(List<Mezzo> mezzi) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        for (Mezzo mezzo : mezzi) {
            em.persist(mezzo);
        }
        et.commit();
    }

    public Mezzo getMezziById (int id) {
        return em.find(Mezzo.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Mezzo mezzo = getMezziById(id);

        if (mezzo != null) {
            em.remove(mezzo);
        } else {
            System.out.println("Mezzo non presente");
        }

        et.commit();
    }

    public List<Object[]> getBigliettiPerMezzo() {
        Query query = em.createNativeQuery(
                "SELECT m.id, COUNT(b.id) AS num_biglietti " +
                        "FROM mezzi m " +
                        "LEFT JOIN viaggi v ON m.id = v.mezzo_id " +
                        "LEFT JOIN biglietti b ON v.biglietto_id = b.id " +
                        "WHERE b.timbrato = true " +
                        "GROUP BY m.id");
        return query.getResultList();
    }




}
