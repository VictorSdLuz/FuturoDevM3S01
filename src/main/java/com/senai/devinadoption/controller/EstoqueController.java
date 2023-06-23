package com.senai.devinadoption.controller;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.enums.Categoria;
import com.senai.devinadoption.enums.Produto;
import com.senai.devinadoption.model.Estoque;
import com.senai.devinadoption.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    //criterio7
    @PostMapping("/produto")
    public ResponseEntity<String> cadastrarProdutoNoEstoque(
            @RequestParam Long armazenamentoId,
            @RequestParam Produto produto,
            @RequestParam int quantidade,
            @RequestParam Animal animal,
            @RequestParam Categoria categoria) {

        try {
            Estoque estoque = estoqueService.cadastrarProdutoNoEstoque(armazenamentoId, produto, quantidade, animal, categoria);
            return ResponseEntity.ok("Produto cadastrado no estoque com sucesso. ID do estoque: " + estoque.getId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    //criterio6
    @DeleteMapping("{id}")

    public ResponseEntity<String> removerItemDoEstoque(@PathVariable Long id) {
        estoqueService.removerItemDoEstoque(id);
        return ResponseEntity.ok("Item do estoque removido com sucesso.");
    }

}