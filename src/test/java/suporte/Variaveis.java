package suporte;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Variaveis extends Diretorios{
    // site seguradora
    public static String linkPortalDoCorretor = "https://www.youse.com.br/";
    public static Boolean logar = true;

    // numero do calculo a ser processado e nome do seu PDF
    public static String numeroArquivo;
    public static File NomePdfDownload;
    public static String nomeDownload;

    // drive do Navegador
    public static WebDriver navegador;

    // waits do Selenium e elemento a procurar
    public static WebDriverWait aguardar;
    public static WebDriverWait aguardarParaTestesRapidos;
    public static String elemento;

    // resumo
    public static String numeroCotacao;
    public static String vigencia;

    // variaveis do calculo
    public static String nome;
    public static String cpf;
    public static String cep;
    public static String fipe;

}
