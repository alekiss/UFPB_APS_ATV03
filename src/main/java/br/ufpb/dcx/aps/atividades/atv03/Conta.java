package br.ufpb.dcx.aps.atividades.atv03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Conta {
    private Correntista correntista;
    private int numero;
    private List<Transacao> transacoes = new LinkedList<Transacao>();
    private Banco banco;
    private List<String> movimentacao = new ArrayList<>();

    public Conta (Correntista correntista, int numero, Banco banco){
        this.correntista = correntista;
        this.numero = numero;
        this.banco = banco;
    }
    public Conta (){

        this.numero = 0;
    }

    public int gerarId(){
        Random b = new Random();
        int c = b.nextInt(99999);
        return c;
    }

    public Transacao depositar (double valor){
        if (valor > 0){
            Transacao a = new Transacao(gerarId(), valor);
            transacoes.add(a);
            this.movimentacao.add("CRÉDITO\tR$ "+(int) valor+ ",00");
            return a;
        }
        else {
            throw new RuntimeException("Não é possivel fazer valor de depósito negativo");
        }
    }
    public Transacao sacar(double valor) throws ContaException{

        if (valor <= this.saldo() && valor > 0){
            Transacao d = new Transacao(gerarId(), - valor);
            transacoes.add(d);
            this.movimentacao.add("DÉBITO\t-R$ "+(int) valor+ ",00");
            return d;
        }
        else {
            throw new ContaException("Saldo insuficiente. Saldo:"+saldo()+" - valor do saque:"+valor);
        }
    }
    public double saldo(){
        double e = 0.0;
        for (Transacao f : transacoes){
            e += f.getValor();
        }
        return e;
    }
    public String extrato(){
        String x = "";
        x += ">> " +banco.getNome()+ "\n";
        x += ">> Correntista: \n";
        x += " CPF: " + correntista.getCpf() + "\n";
        x += " " + correntista.getNome() + "\n";
        x += "> EXTRATO\n";
        x += "------------------------------------\n";
        for (String z: this.movimentacao) x += z+ "\n";
        x += "------------------------------------\n";
        x += "SALDO:\tR$ " + (int) this.saldo() + ",00";
        return x;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public int getNumero() {
        return numero;
    }
}
