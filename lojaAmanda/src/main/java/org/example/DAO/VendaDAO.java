package org.example.DAO;

import jakarta.persistence.EntityManager;
import org.example.Entidades.Cliente;
import org.example.Entidades.Produto;
import org.example.Entidades.Venda;

public class VendaDAO {
    public void salvar(Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
        em.close();
    }
    public Venda listarVendaPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Venda venda = em.find(Venda.class, id); // Encontra o autor pelo ID
        em.close();
        return venda;
    }
}
