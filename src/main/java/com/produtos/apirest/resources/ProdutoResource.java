package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;


@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto buscarProduto(@PathVariable(value="id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}
