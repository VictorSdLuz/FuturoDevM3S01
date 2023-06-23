package com.senai.devinadoption.service;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.enums.Categoria;
import com.senai.devinadoption.enums.Produto;
import com.senai.devinadoption.model.Estoque;

public interface EstoqueService {


    boolean verificarArmazenamentoExistente(Long armazenamentoId);

    boolean verificarArmazenamentoAceitaAnimal(Long armazenamentoId, Animal animal);

    //criterio7
    Estoque cadastrarProdutoNoEstoque(Long armazenamentoId, Produto produto, int quantidade, Animal animal, Categoria categoria);

    //criterio6
    void removerItemDoEstoque(Long Id);
}