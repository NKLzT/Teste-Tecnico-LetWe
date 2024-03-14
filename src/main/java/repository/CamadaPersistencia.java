package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import model.Produto;

public class CamadaPersistencia {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("letwe");
        EntityManager manager = factory.createEntityManager();

        ProdutosRepository produtosRepository = new ProdutosRepository(manager);

        manager.getTransaction().begin();

     // Criar um novo produto
        Produto novoProduto = new Produto();
        novoProduto.setNome("Produto Teste");
        novoProduto.setDescricao("Descrição do Produto Teste");
        novoProduto.setPreco(99.99);

        // Salvar o produto
        Produto produtoSalvo = produtosRepository.salvarProduto(novoProduto);
        System.out.println("Produto salvo com ID: " + produtoSalvo.getId());

        // Atualizar o produto
        produtoSalvo.setNome("Produto Teste Atualizado");
        produtoSalvo = produtosRepository.atualizarProduto(produtoSalvo);
        System.out.println("Produto atualizado com ID: " + produtoSalvo.getId());

        // Pesquisar produtos
        List<Produto> produtos = produtosRepository.pesquisar("Produto Teste");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("-----------------------------");
        }

        // Remover o produto
        produtosRepository.remover(produtoSalvo);

    }
}
