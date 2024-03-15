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

	private Produto produtoSelecionado;
	
	private Long idProdutoExclusao;

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

	public String prepararAtualizacao() {
		return "AtualizarProduto.xhtml?faces-redirect=true";
	}

	public String voltar() {
		return "Produto.xhtml?faces-redirect=true";
	}

	public void atualizar() {
		try {
			produtosRepository.atualizarProduto(produto);
			produto = new Produto();
		} catch (IllegalArgumentException e) {
			System.out.println("ERROR: " + e);
		}
	}
	
	public void excluir() {
	    try {
	        Produto produto = produtosRepository.getProduto(idProdutoExclusao);
	        if (produto != null) {
	            System.out.println("Excluindo o produto com ID: " + idProdutoExclusao);
	            produtosService.excluir(produto);
	            // Após excluir o produto, podemos limpar o campo idProdutoExclusao
	            idProdutoExclusao = null;
	        } else {
	            System.out.println("Produto com ID: " + idProdutoExclusao + " não encontrado.");
	        }
	    } catch (Exception e) {
	         System.out.println("ERROR " + e);
	    }
	}
	public Long getIdProdutoExclusao() {
	    return this.idProdutoExclusao;
	}

	public void setIdProdutoExclusao(Long idProdutoExclusao) {
	    this.idProdutoExclusao = idProdutoExclusao;
	}
	
}