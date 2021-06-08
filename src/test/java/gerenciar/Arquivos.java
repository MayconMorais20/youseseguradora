package gerenciar;
import logs.Log;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.*;

public class Arquivos extends Variaveis{
    @Test
    public void testeArquivos() throws IOException, InterruptedException {
        iniciarExtracaoDeDadosTxt();
        //moverArquivoParaRestricao("risco sem aceitacao");
        pegarArquivosFreenas();
    }

    private void atribuirValorVariaveis(String numeroArquivo ) throws IOException {

        nome = buscarDadosArquivosPorIndices(1);
        cpf  = buscarDadosArquivosPorIndices(2);
        cep = buscarDadosArquivosPorIndices(3);
        fipe = buscarDadosArquivosPorIndices(17);

    }

    public Boolean iniciarExtracaoDeDadosTxt() throws IOException {
        Boolean confimarExtracao = true;
        //  inicia a busca dos arquivos
        buscarNumeroArquivo();

        if (numeroArquivo != null){
            atribuirValorVariaveis(numeroArquivo);
        }else {
            confimarExtracao = false;
        }
        return confimarExtracao;
    }

    private void buscarNumeroArquivo(){
        File[] files = new File(diretorioPastaArquivos).listFiles();

        try {
            numeroArquivo = files[0].getName();
            new Log().exibirLog("numero do arquivo atual é " + numeroArquivo);

        }catch (Exception e){
            new Log().exibirLogErro("acabou os arquivos da pasta " + nomeSeguradoraPastaLocal);
        }
    }

    private String buscarDadosArquivosPorIndices(Integer indice) throws IOException {
        String dadosExtraidos = null;
        File file = new File(diretorioPastaArquivos + numeroArquivo);
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

    public void moverArquivoParaProntos(){
        File caminhoarquivo = new File(diretorioPastaArquivos + numeroArquivo);

        if (caminhoarquivo.exists() && caminhoarquivo.isFile()) {
            //  move o txt da pasta ".../aquivos/" para ".../prontos/"
            caminhoarquivo.renameTo(new File(diretorioPastaProntos + numeroArquivo));
            new Log().exibirLog(String.format("moveu corretamento o arquivo %s para o prontos", numeroArquivo.replace(".TXT","")
                    .replace(".txt","")));

        }
    }

    public void moverArquivoParaRestricao(String nomeRestricao) throws IOException, InterruptedException {
        File caminhoarquivo = new File(diretorioPastaArquivos + numeroArquivo);

        if (caminhoarquivo.exists() && caminhoarquivo.isFile()) {
            //  move o txt da pasta ".../aquivos/" para ".../prontos/"
            caminhoarquivo.renameTo(new File(diretorioPastaRestricao + numeroArquivo));
            new Log().exibirLog(String.format("moveu corretamento o arquivo %s para a restricao", numeroArquivo.replace(".TXT", "")
                    .replace(".txt", "")));
            Thread.sleep(1000);
            // assim que mover ele coloca o nome da restrição;
            new Restricao().colocarNomeRestricao(nomeRestricao);

        }
    }
    private Boolean verificarVmOuComputadorPessoal(){
        Boolean vm = true;
        for( String usario : usuariosNaoVMS ){
            if (usario.toUpperCase().equals(nomeComputador.toUpperCase())){
                vm = false;
            }
        }
        return vm;
    }
    public void pegarArquivosFreenas() throws IOException {
        // se retornar true é uma vm, portanto vai buscar do freenas os arquivos.
        if (verificarVmOuComputadorPessoal()){

            //cria arquivo com o nome da vm caso nao exista
            new Vm().criarNomeVM();

            // caminho de onde ira pegar os arquivos no freenas
            File diretorioFreenas = new File(diretorioArquivosFreenas
                    + new Vm().nomeVm().toLowerCase() + "/");

            File destinoNaVm = new File(diretorioArquivosVm);

            // busca no freenas os arquivos dessa vm
            if (diretorioFreenas.exists()) {
                FileUtils.copyDirectory(diretorioFreenas, destinoNaVm);
                FileUtils.deleteDirectory(diretorioFreenas);
            }

            // pegar resumo do freenas
            File resumoFreenas = new File(diretorioResumoFreenas);

            File resumoVm = new File(diretorioResumoVm);
            resumoVm.mkdir();

            FileUtils.copyDirectory(resumoFreenas, resumoVm);
        }
    }
}
