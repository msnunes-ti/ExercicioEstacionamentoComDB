import javax.persistence.*;
import java.sql.ResultSet;
import java.util.List;

public class DAO<Registro> {

    private static EntityManagerFactory emf;
    private EntityManager em;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("estacionamento");
        } catch (Exception e) {

        }
    }

    public DAO() {
        this.em = emf.createEntityManager();
    }

    public DAO abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO incluir(Registro registro) {
        em.persist(registro);
        return this;
    }

    public DAO incluirAtomico(Registro registro) {
        return this.abrirTransacao().incluir(registro).fecharTransacao();
    }

    public void lancarSaida(String placa) {
        String jpql = "SELECT * FROM registros WHERE placa = '" + placa + "'";
        TypedQuery<Registro> query = (TypedQuery<Registro>) em.createQuery(jpql, getClass());
        List<Registro> registros = query.getResultList();
        for (Registro registro : registros) {

        }
    }

    public List<Registro> obterTodosEstacionados() {
        String jpql = "SELECT r.id, r.placa,r.data_entrada FROM registros r WHERE data_saida IS NULL";
        Query query = em.createQuery(jpql, getClass());
        return query.getResultList();

    }


    public void fechar() {
        em.close();
    }

}
