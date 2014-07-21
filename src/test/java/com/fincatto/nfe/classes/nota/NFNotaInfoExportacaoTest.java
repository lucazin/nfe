package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.NFUnidadeFederativa;

public class NFNotaInfoExportacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirLocalEmbarqueProdutosComTamanhoNaoPermitido() {
        try {
            new NFNotaInfoExportacao().setLocalEmbarqueProdutos("");
            Assert.fail("Validacao nao esta funcionando corretamente");
        } catch (final IllegalStateException e) {
            new NFNotaInfoExportacao().setLocalEmbarqueProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm1");
        }
        Assert.fail("Validacao nao esta funcionando corretamente");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveGerarXMLUfEmbarqueProdutoNulo() {
        final NFNotaInfoExportacao exportacao = new NFNotaInfoExportacao();
        exportacao.setLocalEmbarqueProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm");
        exportacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveGerarXMLLocalEmbarqueProdutosNulo() {
        final NFNotaInfoExportacao exportacao = new NFNotaInfoExportacao();
        exportacao.setUfEmbarqueProduto(NFUnidadeFederativa.SC);
        exportacao.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoExportacao exportacao = new NFNotaInfoExportacao();
        exportacao.setUfEmbarqueProduto(NFUnidadeFederativa.SC);
        exportacao.setLocalEmbarqueProdutos("xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm");

        final String xmlEsperado = "<NFNotaInfoExportacao><UFEmbarq>42</UFEmbarq><xLocEmbarq>xEb99u9TExujbhMIcO9u9ycsZAg2gtKzIFgsUogoVjuyDAhnlkZz3I5Hpccm</xLocEmbarq></NFNotaInfoExportacao>";
        Assert.assertEquals(xmlEsperado, exportacao.toString());
    }
}