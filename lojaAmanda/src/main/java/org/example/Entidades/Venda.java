package org.example.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Cliente cliente;
    private String dataVenda;
    private Produto produto;
    private String total;
}
