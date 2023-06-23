package com.senai.devinadoption.service;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.enums.Categoria;
import com.senai.devinadoption.enums.Produto;
import com.senai.devinadoption.model.Armazem;
import com.senai.devinadoption.model.Estoque;
import com.senai.devinadoption.repository.ArmazemRepository;
import com.senai.devinadoption.repository.EstoqueReposioty;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EstoqueServiceImpl  implements  EstoqueService {

    private final EstoqueReposioty estoqueReposioty;
    private final ArmazemRepository armazemRepository;

    public EstoqueServiceImpl(EstoqueReposioty estoqueReposioty, ArmazemRepository armazemRepository) {
        this.estoqueReposioty = estoqueReposioty;
        this.armazemRepository = armazemRepository;
    }

    @Override
    public boolean verificarArmazenamentoExistente(Long armazenamentoId) {
        return armazemRepository.existsById(armazenamentoId);
    }

    @Override
    public boolean verificarArmazenamentoAceitaAnimal(Long armazenamentoId, Animal animal) {
        Optional<Armazem> armazemOptional = armazemRepository.findById(armazenamentoId);
        if (armazemOptional.isPresent()) {
            Armazem armazem = armazemOptional.get();
            return armazem.getAnimal() == animal;
        }
        return false;
    }
    //criterio7
    @Override
    public Estoque cadastrarProdutoNoEstoque(Long armazenamentoId, Produto produto, int quantidade, Animal animal, Categoria categoria) {
        boolean armazenamentoExistente = verificarArmazenamentoExistente(armazenamentoId);
        if (!armazenamentoExistente) {
            throw new IllegalArgumentException("O local de armazenamento não existe.");
        }

        boolean aceitaAnimal = verificarArmazenamentoAceitaAnimal(armazenamentoId, animal);
        if (!aceitaAnimal) {
            throw new IllegalArgumentException("O local de armazenamento não aceita produtos para o animal especificado.");
        }

        Estoque estoque = new Estoque();
        estoque.setArmazem(armazemRepository.getById(armazenamentoId));
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidade);
        estoque.setAnimal(animal);
        estoque.setCategoria(categoria);

        return estoqueReposioty.save(estoque);
    }

    //criterio6
    @Override
    public void removerItemDoEstoque(Long id) {
        Optional<Estoque> estoqueOptional = estoqueReposioty.findById(id);
        if (estoqueOptional.isPresent()) {
            Estoque estoque = estoqueOptional.get();
            estoqueReposioty.delete(estoque);
        } else {
            throw new IllegalArgumentException("O item do estoque não foi encontrado.");
        }
    }

}
