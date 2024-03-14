package repository;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            produto = manager.merge(produto);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
        return produto;
    }

    public void remover(Produto produto) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            produto = getProduto(produto.getId());
            manager.remove(produto);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Produto atualizarProduto(Produto produto) {
        if (produto != null && produto.getId() != null) {
            EntityTransaction transaction = manager.getTransaction();
            try {
                transaction.begin();
                produto = manager.merge(produto);
                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
            return produto;
        }
        throw new IllegalArgumentException("Produto não pode ser nulo e deve ter um ID válido.");
    }

    public List<Produto> listarTodos() {
        TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
        return query.getResultList();
    }
}
