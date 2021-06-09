package suporte;

import logs.Log;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Vm extends Variaveis {
    @Test
    public void testeVm() throws IOException {
        new Pastas().criarPastas();
        criarNomeVM();
        nomeVm();

    }

    public void criarNomeVM() throws IOException {
        FileWriter arq = new FileWriter(diretorioFerramentasMover+"NomeVm.txt");
        String hostname = "Unknown";

        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }
        PrintWriter gravarArquivo = new PrintWriter(arq);
        gravarArquivo.println(hostname);
        gravarArquivo.flush();
        gravarArquivo.close();
    }

    public String nomeVm() throws IOException {
        String nomeDaVm = "";
        Scanner arquivo = new Scanner(diretorioFerramentasMover+"NomeVm.txt");
        String primeiraLinha = arquivo.nextLine();
        FileReader linha = new FileReader(primeiraLinha);
        BufferedReader lerLinha = new BufferedReader(linha);

        nomeDaVm = lerLinha.readLine();
        lerLinha.close();

        new Log().exibirLog(String.format("o nome da vm é: %s ", nomeDaVm));
        return nomeDaVm;
    }
}
