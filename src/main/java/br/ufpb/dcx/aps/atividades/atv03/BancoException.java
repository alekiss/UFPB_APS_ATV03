package br.ufpb.dcx.aps.atividades.atv03;

public class BancoException extends Exception{

    private static final long serialVersionUID = 1L;

    public BancoException(String erro){
        super(erro);
    }
}
