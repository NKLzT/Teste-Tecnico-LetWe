package controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Produto;
import repository.ProdutosRepository;
import service.ProdutosService;

@Named("xyz")
@RequestScoped
public class GestaoProdutosBean {

    @Inject
    private ProdutosService produtosService;

    @Inject
    private ProdutosRepository produtosRepository;

    private Produto produto = new Produto();

    public void salvar() {
        System.out.println(produto.toString());
        produtosRepository.salvarProduto(produto);
        produto = new Produto();
    }

    // getters and setters
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void listarProdutos() {
        produtos = produtosRepository.listarTodos();
    }
}
