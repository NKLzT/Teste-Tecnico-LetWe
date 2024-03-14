package controller;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Produto;
import repository.ProdutosRepository;
import service.ProdutosService;

@Named("xyz")
@RequestScoped
public class GestaoProdutosBean implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
