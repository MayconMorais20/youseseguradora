package pageObjects;

import gerenciar.Variaveis;
import org.openqa.selenium.WebElement;
import pageObjects.ferramentas.Ferramentas;

import java.io.IOException;

public class DadosDoVeiculo extends Variaveis {
    public WebElement chassi(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='Qual a placa ou chassi do seu carro?']/following-sibling::input";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement opcaoSemChassi(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//fieldset[@class='narrative-form__field']//a";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement marca(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//select[@data-manual-vehicle-make='true']";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement modelo(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='modelo']/following-sibling::select";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement anoModelo(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='ano modelo']/following-sibling::select";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement versao(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='versão']/following-sibling::select";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement botaoUsoParticular(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//div[text()[normalize-space()='Particular']]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement botaoUsoMotoristaDeAplicativo(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//div[text()[normalize-space()='Particular, Uso Comercial e Motorista de Aplicativo']]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement botaoUsoRepresentanteComercial(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//div[text()[normalize-space()='Representante Comercial/Vendas']]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement botaoUsoTaxi(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//div[text()[normalize-space()='Taxi']]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement botaoUsoTransporteDeCarga(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//div[text()[normalize-space()='Transporte de Carga']]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement botaoUsoTransporteDePassageiros(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//section[@id='vehicle-usage-section']/fieldset[1]/div[1]/div[6]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement inputBlindadoSim(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//input[@type='radio']/following-sibling::label";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement inputBlindadoNao(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "(//input[@type='radio']/following-sibling::label)[2]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement cep(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//label[text()='Qual o CEP onde o carro dorme?']/following::input";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement numeroDoEndereco(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "(//input[@type='tel'])[2]";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement complemento(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//input[@class='complement_address form__input-text']";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }
    public WebElement cpf(Enum tipoDefluxo, Enum tipoBusca) throws IOException {
        elemento = "//input[@data-cpf-input='true']";
        return Ferramentas.procurarElemento(tipoDefluxo, tipoBusca, elemento);
    }

}
