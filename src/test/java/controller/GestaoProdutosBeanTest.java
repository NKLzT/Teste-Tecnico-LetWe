package controller;

import static org.mockito.Mockito.*;


import model.Produto;
import repository.ProdutosRepository;
import service.ProdutosService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GestaoProdutosBeanTest {

    @InjectMocks
    private GestaoProdutosBean gestaoProdutosBean;

    @Mock
    private ProdutosService produtosService;

    @Mock
    private ProdutosRepository produtosRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvar() {
        Produto produto = new Produto();
        gestaoProdutosBean.setProduto(produto);
        gestaoProdutosBean.salvar();
        verify(produtosRepository, times(1)).salvarProduto(produto);
    }

    @Test
    public void testAtualizar() {
        Produto produto = new Produto();
        gestaoProdutosBean.setProduto(produto);
        gestaoProdutosBean.atualizar();
        verify(produtosRepository, times(1)).atualizarProduto(produto);
    }

    @Test
    public void testExcluir() {
        Produto produto = new Produto();
        when(produtosRepository.getProduto(anyLong())).thenReturn(produto);
        gestaoProdutosBean.setIdProdutoExclusao(1L);
        gestaoProdutosBean.excluir();
        verify(produtosService, times(1)).excluir(produto);
    }
}
