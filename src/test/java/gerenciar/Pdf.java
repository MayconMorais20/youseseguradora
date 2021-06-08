package gerenciar;
import logs.Log;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Pdf extends Variaveis{
    @Test
    public void testePdf() throws IOException, InterruptedException {
        new Arquivos().iniciarExtracaoDeDadosTxt();
        deletarArquivosDownload();
        moverPdfDownloadParaPastaPdf();
    }
    private void buscarDownloadPdf() throws IOException, InterruptedException {
        //  preparar ambiente de comparação de PDF
        File[] ListaDeArquivosDownload;
        ArrayList<String> ListaDeNomesArquivosDownload = new ArrayList();
        Integer contadorTempoEspera = 0;

        // LOOP PARA AGUARDA O PDF SER BAIXADO E PEGAR SEU NOME DE PDF
        while (true){
            // aguarda o dowload por 1m 20s no maximo
            Thread.sleep(2000);
            if(contadorTempoEspera >= 40){
                Erros.criarArquivoErro();
                new Log().exibirLogErro("esperou muito tempo pelo download vai criar ...status/erro.txt");
                break; }
            contadorTempoEspera++;

            try {
                ListaDeArquivosDownload = new File(diretorioPastaDownload).listFiles();
                for (File file : ListaDeArquivosDownload) {
                    ListaDeNomesArquivosDownload.add(file.getName());
                }

                NomePdfDownload = new File(diretorioPastaDownload+ListaDeNomesArquivosDownload.get(0));
                // verifica se existe um arquivo ( confirmação )
                if (!NomePdfDownload.exists()) {
                    new Log().exibirLog("ainda não existe nenhum arquivo na pasta download.");
                }else{
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Arquivo ainda não existe!");
                new Log().exibirLogErro("não conseguiu listagem de arquivo na pasta download.");
            }
        }
    }

    public void deletarArquivosDownload(){
        File[] ListaDeArquivosDownload = new File(diretorioPastaDownload).listFiles();
        for (File file : ListaDeArquivosDownload) {
            file.delete();
        }
    }

    public void moverPdfDownloadParaPastaPdf() throws IOException, InterruptedException {
        buscarDownloadPdf();
        if(! Erros.verificaErro()){
            //CAMINHO P/ RENOMEAR E MOVER O ARQUIVO .../caminhopdfZero/0.pdf PARA O ...pdf/(nrlinhapdf).pdf
            File diretorioPdfComNomePdfOrigemArquivo = new File(diretorioPastaPdf + numeroArquivo
                    .replace(".TXT",".pdf")
                    .replace(".txt",".pdf"));

            //RENOMEIA E MOVE O ARQUIVO DA PASTA '.../PDFNRLINHAZERO/' PARA '.../PDF/'
            if (NomePdfDownload.renameTo(diretorioPdfComNomePdfOrigemArquivo)) {
                new Log().exibirLog(String.format("moveu corretamente '%s' para '%s '", NomePdfDownload, diretorioPdfComNomePdfOrigemArquivo));
                if (NomePdfDownload.exists() && NomePdfDownload.isFile()) {
                    NomePdfDownload.delete();
                }
                Thread.sleep(1000);
            } else {
                new Log().exibirLogErro(String.format("erro ao renomear/mover o arquivo %s .pdf !", NomePdfDownload));
            }
        }
    }

}
