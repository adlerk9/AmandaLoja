package org.example.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @ManyToOne
    private Venda venda;

    private String valorPago;
    private String formaPagamento;
    private String status;
}
