package repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Produto;

public class ProdutosRepository {
	@Inject
	private EntityManager manager;

	public ProdutosRepository() {

	}

	public ProdutosRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Produto getProduto(Long id) {
		return manager.find(Produto.class, id);
	}

	public List<Produto> pesquisar(String nome) {
		TypedQuery<Produto> query = manager.createQuery("from Produto where nome like :nome", Produto.class);
		query.setParameter("nome", nome + "%");
		return query.getResultList();
	}

	public Produto salvarProduto(Produto produto) {
		return manager.merge(produto);
	}

	public void remover(Produto produto) {
		produto = getProduto(produto.getId());
		manager.remove(produto);
	}

	public Produto atualizarProduto(Produto produto) {
		if (produto != null && produto.getId() != null) {
			return manager.merge(produto);
		}
		throw new IllegalArgumentException("Produto não pode ser nulo e deve ter um ID válido.");
	}
	
	public List<Produto> listarTodos() {
	    TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
	    return query.getResultList();
	}

}
