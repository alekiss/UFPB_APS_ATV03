package br.ufpb.dcx.aps.atividades.atv03;

import java.util.List;

public class BancoFacade {
    private Banco banco;

    public BancoFacade(String bancoNome){

        this.banco = new Banco(bancoNome);
    }

    public void cadastrarCorrentista(String cpf, String nome) throws BancoException{

        Correntista k = new Correntista(cpf, nome);
        banco.addCorrentista(k);
    }

    public Conta getConta(int numero){

        return banco.getConta(numero);
    }
    public Conta criarContaPF(String cpf){
        Correntista l = banco.getCorrentista(cpf);
        return banco.criarConta(l);
    }

    public void depositar(double valor, int conta){
        Conta m = banco.getConta(conta);
        m.depositar(valor);
    }

    public double sacar(double valor, int conta) throws ContaException{
        Conta n = banco.getConta(conta);
        n.sacar(valor);
        return n.saldo();
    }
    public String extrato(int conta){
        Conta o = banco.getConta(conta);
        return o.extrato();
    }
    public List<Transacao> getTransacoes(int conta){
        Conta p = banco.getConta(conta);
        return p.getTransacoes();
    }
    public double saldo(int conta){
        Conta q = banco.getConta(conta);
        return q.saldo();
    }

}
