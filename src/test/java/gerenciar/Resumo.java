package gerenciar;

import logs.Log;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Resumo extends Variaveis{
    @Test
    public void testeResumo() throws IOException {
        lerResumo();
    }

    public void lerResumo() throws IOException {
        numeroCotacao = lerResumoPorIndices(2);
        vigencia = lerResumoPorIndices(4);

        new Log().exibirLog("leitura do resumo finalizada");
    }

    private String lerResumoPorIndices(Integer indice) throws IOException {
        String dadosExtraidos = null;
        File file = new File(diretorioCotacao+"resumo.txt");
        BufferedReader arquivoBuffRead = new BufferedReader(new FileReader(file.getAbsolutePath()));

        if (indice > 1){
            for (int indiceBuff = 0; indiceBuff < indice; indiceBuff ++){
                dadosExtraidos = arquivoBuffRead.readLine();
            }
        }else {
            dadosExtraidos = arquivoBuffRead.readLine();
        }
        return dadosExtraidos;
    }
}
