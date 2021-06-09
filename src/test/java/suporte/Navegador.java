package suporte;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Navegador extends Variaveis {
    @Test
    public void testeArquivo() throws IOException {
        iniciarUmNavegador();
        criarSessaoNavegador();
    }

    private void criarArquivoAbrirNavegador() throws IOException {
        FileWriter abrirNavegadorAquivo = new FileWriter(
                "/home/" + nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/status/abrirNavegador.txt");
        PrintWriter gravar = new PrintWriter(abrirNavegadorAquivo);
        gravar.flush();
        gravar.close();
    }

    public static Boolean verificarReabrir(){
        File file = new File("/home/" + nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/status/abrirNavegador.txt");
        boolean relogar = true;

        if (file.exists() && file.isFile()) {
            relogar = false;
        }
        return relogar;
    }

    public void deleterarArquivoReiniciar(){
        File file = new File("/home/" + nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/status/abrirNavegador.txt");
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public  void iniciarUmNavegador() throws IOException {
        // gera o primerio arquivo do navegador para indicar sua abertura
        criarArquivoAbrirNavegador();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        //- imagens teste!
        // 1 - ativador, 2 - desativado
        //prefs.put("profile.managed_default_content_settings.images", 1);
        //diretorio onde o PDF será direcionado no Dowload
        prefs.put("download.default_directory", "/home/"+ nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/download/");
        //desativa o PDF View
        prefs.put("plugins.plugins_disabled", new String[]{
                "Chrome PDF Viewer"
        });
        //Não deixar abrir o PDF externamente!
        prefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", prefs);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        if (!nomeComputador.contains("maycon")){
            System.setProperty("webdriver.chrome.driver","/home/"+nomeComputador+"/drivers/chromedriver");
        }

        navegador = new ChromeDriver(options);
        navegador.manage().window().maximize();

        // tempo de duracao em caso de lentidão ::: 1 minuto
        aguardar = new WebDriverWait(navegador, Duration.ofMinutes(1));
        // tempo de duracao em caso de testes rapidos ::: 10 segundos
        aguardarParaTestesRapidos = new WebDriverWait(navegador, Duration.ofSeconds(10));
    }
    public void criarSessaoNavegador(){
        SessionId s = ((RemoteWebDriver) navegador).getSessionId();
        System.out.println("Session Id is: " + s);
    }
}
