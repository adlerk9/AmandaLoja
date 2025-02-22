package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.Entidades.Cliente;
import org.example.Entidades.Produto;

import java.util.List;

public class ClienteDAO {
    public void salvar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public Cliente listarClientePorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id); // Encontra o autor pelo ID
        em.close();
        return cliente;
    }

    public List<Cliente> listarTodosClientes() {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> root = cq.from(Cliente.class);
        cq.select(root);
        List<Cliente> cliente = em.createQuery(cq).getResultList();
        em.close();
        return cliente;
    }
    public void atualizarCliente(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}