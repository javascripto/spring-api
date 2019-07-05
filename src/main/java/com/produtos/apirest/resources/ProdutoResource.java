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

    @PostMapping("/produtos")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    public void removerProduto(@PathVariable(value="id") long id) {
        Produto produto = produtoRepository.findById(id);
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto/{id}")
    public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable(value="id") long id) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }
}
