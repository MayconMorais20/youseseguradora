package pageObjects.ferramentas;

import gerenciar.Erros;
import logs.Log;
import pageObjects.constantes.Aguardar;
import gerenciar.Variaveis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.constantes.Buscar;

import java.io.IOException;

public class Ferramentas extends Variaveis {
    public static WebElement procurarElemento(Enum tipoDefluxo, Enum tipoBuscar, String procurarPor) throws IOException {
        if (! Erros.verificaErro()){
            try {
                if (tipoBuscar.equals(Buscar.XPATH)){
                    if (tipoDefluxo.equals(Aguardar.NORMAL)){
                        return navegador.findElement(By.xpath(procurarPor));
                    }if(tipoDefluxo.equals(Aguardar.ESPERAR)) {
                        return aguardar.until(ExpectedConditions.elementToBeClickable(By.xpath(procurarPor)));
                    }else {
                        return aguardarParaTestesRapidos.until(ExpectedConditions.elementToBeClickable(By.xpath(procurarPor)));
                    }
                }else {
                    if (tipoBuscar.equals(Buscar.ID)){
                        if (tipoDefluxo.equals(Aguardar.NORMAL)){
                            return navegador.findElement(By.id(procurarPor));
                        }if(tipoDefluxo.equals(Aguardar.ESPERAR)) {
                            return aguardar.until(ExpectedConditions.elementToBeClickable(By.id(procurarPor)));
                        }else {
                            return aguardarParaTestesRapidos.until(ExpectedConditions.elementToBeClickable(By.id(procurarPor)));
                        }
                    }else {
                        return null;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                new Erros().criarArquivoErro();
                new Log().exibirLogErro(String.format(" elemento não encontrado >>> %s <<<", elemento));

            }
        }
        // só vai em caso de erro
        return null;
    }
}
