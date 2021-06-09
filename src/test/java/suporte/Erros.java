package suporte;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Erros extends Variaveis{
    @Test
    public void testeErro() throws IOException {
        Boolean resposta;
        criarArquivoErro();
        resposta = verificaErro();
        deletarArquivoErro();
        resposta = verificaErro();
    }

    public static void criarArquivoErro() throws IOException {
        FileWriter GerarArquivoErro = new FileWriter(diretorioPastaStatus + "erro.txt");
        PrintWriter gravar = new PrintWriter(GerarArquivoErro);
        gravar.flush();
        gravar.close();
    }
    public static Boolean verificaErro(){
        boolean existeerro = false;
        File file = new File(diretorioPastaStatus + "erro.txt");
        if(file.exists() && file.isFile()){
            existeerro = true;
        }
        return existeerro;
    }
    public void deletarArquivoErro(){
        File file = new File(diretorioPastaStatus + "erro.txt");
        if(file.exists() && file.isFile()){
            file.delete();
        }
    }

}
