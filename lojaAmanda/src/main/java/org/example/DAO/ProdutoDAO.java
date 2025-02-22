package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.Entidades.Cliente;
import org.example.Entidades.Produto;

import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    public Produto listarProdutoPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    public List<Produto> listarTodosProdutos() {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> root = cq.from(Produto.class);
        cq.select(root);
        List<Produto> produto = em.createQuery(cq).getResultList();
        em.close();
        return produto;
    }

    public void atualizarProduto(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
