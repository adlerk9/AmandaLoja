package org.example;

import org.example.DAO.ClienteDAO;
import org.example.DAO.PagamentoDAO;
import org.example.DAO.ProdutoDAO;
import org.example.DAO.VendaDAO;
import org.example.Entidades.Cliente;
import org.example.Entidades.Pagamento;
import org.example.Entidades.Produto;
import org.example.Entidades.Venda;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Adler");
        cliente.setEmail("precissode3pontos@gmail.com");
        cliente.setEndereco("Minha Casa");

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvar(cliente);

//        Produto produto = new Produto();
//        produto.setNome("Carro");
//        produto.setDescricao("Ultra veloz");
//        produto.setPreco("R$20");
//        ProdutoDAO produtoDAO = new ProdutoDAO();
//        produtoDAO.salvar(produto);

//        Venda venda = new Venda();
//        venda.setDataVenda("21/02/2025");
//        venda.setCliente(cliente);
//        venda.setProduto(produto);
//        venda.setTotal("R$20");
//        VendaDAO vendaDAO = new VendaDAO();
//        vendaDAO.salvar(venda);

//        Pagamento pagamento = new Pagamento();
//        pagamento.setFormaPagamento("Pix");
//        pagamento.setStatus("Em andamento");
//        pagamento.setValorPago("R$20");
//        pagamento.setVenda(venda);
//        PagamentoDAO pagamentoDAO = new PagamentoDAO();
//        pagamentoDAO.salvar(pagamento);

    }
}