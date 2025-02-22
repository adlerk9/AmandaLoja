package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.Entidades.Cliente;
import org.example.Entidades.Pagamento;
import org.example.Entidades.Produto;

import java.util.List;

public class PagamentoDAO {
    public void salvar(Pagamento pagamento) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
        em.close();
    }
    public List<Pagamento> listarTodosPagamentos() {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pagamento> cq = cb.createQuery(Pagamento.class);
        Root<Pagamento> root = cq.from(Pagamento.class);
        cq.select(root);
        List<Pagamento> pagamento = em.createQuery(cq).getResultList();
        em.close();
        return pagamento;
    }
}
