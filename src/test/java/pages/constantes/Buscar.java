package pages.constantes;

public enum Buscar {
    XPATH(1), ID(2);
    private final int tipoDeBusca;
    Buscar(int opcao) {
        tipoDeBusca = opcao;
    }
    public int getTipoDeBusca(){
        return tipoDeBusca;
    }
}
