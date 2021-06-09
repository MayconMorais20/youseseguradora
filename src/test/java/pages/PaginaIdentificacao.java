package pages;

import suporte.Variaveis;
import org.openqa.selenium.WebElement;
import pages.ferramentas.Ferramentas;

import java.io.IOException;

public class PaginaIdentificacao extends Variaveis {
    public static WebElement inputNome(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='Meu nome é']/following::input";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public static WebElement inputEmail(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='e o meu e-mail é']/following::input";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public static WebElement inputNumeroTelefone(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='se precisar, meu telefone é']/following-sibling::input";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public static WebElement botaoContinuarCalculo(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//input[@value='Continuar']";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
}
