package ramos;

import suporte.Erros;
import pages.PaginaIdentificacao;
import pages.constantes.Aguardar;
import suporte.Variaveis;
import logs.Log;
import pages.PaginaInicial;
import pages.constantes.Buscar;

import java.io.IOException;

public class Automovel extends Variaveis {
    public void iniciarCalculoNaSeguradora() throws InterruptedException, IOException {
        // construir fluxo para o calculo na seguradora

        logarSiteDaSeguradora()
                .entraNoCalculo()
                .corpo();
    }
    public Automovel logarSiteDaSeguradora() throws InterruptedException {
        if (logar) {
            navegador.get(linkPortalDoCorretor);
            logar = false;
        }
        return this;
    }
    public Automovel entraNoCalculo() throws IOException {
        try{
            PaginaInicial.botaoCotadorAuto(Aguardar.NORMAL, Buscar.XPATH).click();
            PaginaInicial.botaoCoteGratis(Aguardar.ESPERAR, Buscar.XPATH).click();
            new Log().exibirLog("entrou no cotador de automovel");
        }catch (Exception e){
            // vai gerar um erro de NullPoint porem o erro está em algum path ( Olhar Log no Console )
            e.printStackTrace();
            new Erros().criarArquivoErro();
            new Log().exibirLogErro("corrigir elemento mostrado no log, pois retornou null.");
        }
        return this;
    }
    public Automovel corpo() throws IOException {
        try{
            PaginaIdentificacao.inputNome(Aguardar.ESPERAR, Buscar.XPATH)
                    .sendKeys("MAYCON DOUGLAS MM");
            PaginaIdentificacao.inputEmail(Aguardar.ESPERAR, Buscar.XPATH)
                    .sendKeys("madman@gmail.com");
            PaginaIdentificacao.inputNumeroTelefone(Aguardar.ESPERAR, Buscar.XPATH)
                    .sendKeys("98 988332211");
            PaginaIdentificacao.botaoContinuarCalculo(Aguardar.NORMAL, Buscar.XPATH)
                    .click();

        }catch (Exception e){
            // vai gerar um erro de NullPoint porem o erro está em algum path ( Olhar Log no Console )
            e.printStackTrace();
            new Erros().criarArquivoErro();
            new Log().exibirLogErro("corrigir elemento mostrado no log, pois retornou null.");
        }
        return this;
    }
}
