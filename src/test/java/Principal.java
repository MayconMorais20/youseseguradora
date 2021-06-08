import gerenciar.*;
import logs.Log;
import org.junit.Before;
import org.junit.Test;
import ramos.Automovel;

import java.io.IOException;

public class Principal extends Variaveis {
    @Before
    public void prepararAmbienteDeTrabalho() throws IOException {
        // sempre criar as pastas primeiro
        new Pastas().criarPastas();

        new Arquivos().pegarArquivosFreenas();
        new Navegador().iniciarUmNavegador();
        new Pdf().deletarArquivosDownload();
        new Erros().deletarArquivoErro();
        new Resumo().lerResumo();
    }

    @Test
    public void iniciarCalculo() throws InterruptedException, IOException {
        Arquivos arquivos = new Arquivos();
        while (true){
            Boolean existeCalculo = arquivos.iniciarExtracaoDeDadosTxt();
            if (existeCalculo){

                // gerenciamento do fechamento/abertura do navegador
                if (Navegador.verificarReabrir()){
                    navegador.close();
                    new Navegador().iniciarUmNavegador();
                    logar = true;
                }
                // inicar calculo na seguradora
                new Automovel().iniciarCalculoNaSeguradora();
            }
            else
            {
                navegador.close();
                new Log().exibirLog("calculos da pasta "+nomeSeguradoraPastaLocal+" finalizados! ");
                break;
            }
        }
    }
}
