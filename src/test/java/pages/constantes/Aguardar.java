package pages.constantes;

public enum Aguardar {
    NORMAL(1), ESPERAR(2), ESPERARTESTES(3);
    private final int tipoDeFluxo;
    Aguardar(int opcao) {
        tipoDeFluxo = opcao;
    }
    public int getTipoDeFluxo(){
        return tipoDeFluxo;
    }
}
