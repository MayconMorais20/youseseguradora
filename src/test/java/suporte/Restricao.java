package suporte;
import logs.Log;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Restricao extends Variaveis{
    @Test
    public void testeRestrica() throws IOException, InterruptedException {
        new Arquivos().iniciarExtracaoDeDadosTxt();
        new Arquivos().moverArquivoParaRestricao("risco restrito na cia");
    }

    public void colocarNomeRestricao(String nomeRestricao ) throws IOException {
        FileWriter arquivoRestricao = new FileWriter(diretorioPastaRestricao + numeroArquivo,true);
        PrintWriter arquivoRestricaoEditar = new PrintWriter(arquivoRestricao);

        arquivoRestricaoEditar.println(nomeRestricao);
        //o método flush libera a escrita no arquivo
        arquivoRestricaoEditar.flush();
        //No final precisamos fechar o arquivo
        arquivoRestricaoEditar.close();
        new Log().exibirLog(String.format("nome da restricao inserida no arquivo %s ", numeroArquivo));
    }
}
