package pageObjects;

import gerenciar.Variaveis;
import org.openqa.selenium.WebElement;
import pageObjects.constantes.Buscar;
import pageObjects.ferramentas.Ferramentas;

import java.io.IOException;

public class PaginaInicial extends Variaveis {
    public static WebElement botaoCotadorAuto(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//a[@href='/seguro-auto/']";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public static WebElement botaoCoteGratis(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//button[text()='Cote Grátis']";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
}
