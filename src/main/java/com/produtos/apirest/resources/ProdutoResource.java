package com.produtos.apirest.resources;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;


@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna produto único baseado no id")
    public Produto buscarProduto(@PathVariable(value="id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/produtos")
    @ApiOperation(value="Salva um produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value="Deleta um produto")
    public void removerProduto(@PathVariable(value="id") long id) {
        Produto produto = produtoRepository.findById(id);
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto/{id}")
    @ApiOperation(value="Atualiza um produto")
    public Produto atualizarProduto(@RequestBody Produto produto, @PathVariable(value="id") long id) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }
}
