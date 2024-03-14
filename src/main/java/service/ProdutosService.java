package service;

import java.util.List;

import javax.inject.Inject;

import model.Produto;
import util.Transacional;
import repository.ProdutosRepository;

public class ProdutosService {
	
	@Inject
	private ProdutosRepository produtosRepository;
	
	@Transacional
	public void salvar(Produto produto) {
		produtosRepository.salvarProduto(produto);
	}
	@Transacional
	public void excluir(Produto produto) {
		produtosRepository.remover(produto);
	}
	@Transacional
	public List<Produto> listarTodos() {
	    return produtosRepository.listarTodos();
	}

}
