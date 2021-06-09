package suporte;

import logs.Log;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Pastas extends  Variaveis{
    @Test
    public void testePastas() throws IOException {
        criarPastas();
    }

    public void criarPastas(){

        //sempre criar primeiro a pasta da seguradora
        criarPasta(diretorioSeguradora);

        // pastas da seguradora
        criarPasta(diretorioPastaRestricao);
        criarPasta(diretorioPastaArquivos);
        criarPasta(diretorioPastaDownload);
        criarPasta(diretorioPastaProntos);
        criarPasta(diretorioPastaStatus);
        criarPasta(diretorioPastaBackup);
        criarPasta(diretorioPastaPdf);
        criarPasta(diretorioCotacao);
        new Log().exibirLog(String.format("pasta e subpastas da %s criadas", nomeSeguradoraPastaLocal));

        //pastas de auxilio na vm
        criarPasta(diretorioFerramentas);
        criarPasta(diretorioFerramentasMover);
        new Log().exibirLog("pastas de auxilio na vm criadas");


    }

    private void criarPasta(String diretorio){
        File pasta = new File(diretorio);
        pasta.mkdir();
    }
}
