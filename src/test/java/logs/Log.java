package logs;

public class Log {
    public void exibirLog(String mensagem){
        System.out.println(String.format("::: LOG ::: %s", mensagem.toLowerCase()));
    }
    public void exibirLogErro(String mensagem){
        System.out.println(String.format(">> ERRO >> %s", mensagem.toLowerCase()));
    }
}
