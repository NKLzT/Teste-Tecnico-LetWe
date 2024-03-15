package repository;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Produto;
import util.Transacional;

public class ProdutosRepository {

	@Inject
	private EntityManager manager;

	public ProdutosRepository() {

	}

	public ProdutosRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Produto getProduto(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("ID do produto não pode ser nulo");
		}
		return manager.find(Produto.class, id);
	}

	public List<Produto> pesquisar(String nome) {
		TypedQuery<Produto> query = manager.createQuery("from Produto where nome like :nome", Produto.class);
		query.setParameter("nome", nome + "%");
		return query.getResultList();
	}

	@Transacional
	public Produto salvarProduto(Produto produto) {
		try {
			produto = manager.merge(produto);
		} catch (RuntimeException e) {
			throw e;
		}
		return produto;
	}

	public void remover(Produto produto) {
		try {
			produto = getProduto(produto.getId());
			manager.remove(produto);
		} catch (RuntimeException e) {

			throw e;
		}
	}

	@Transacional
	public Produto atualizarProduto(Produto produto) {
		try {
			Produto produtoExistente = getProduto(produto.getId());
			if (produtoExistente != null) {
				produtoExistente.setNome(produto.getNome());
				produtoExistente.setDescricao(produto.getDescricao());
				produtoExistente.setPreco(produto.getPreco());
				manager.merge(produtoExistente);
			} else {
				throw new IllegalArgumentException("Produto não encontrado para atualização.");
			}
			return produtoExistente;
		} catch (RuntimeException e) { 
			throw e;
		}
	}
	
	public List<Produto> listarTodos() {
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}

}
