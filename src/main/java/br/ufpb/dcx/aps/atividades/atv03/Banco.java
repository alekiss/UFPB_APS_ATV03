package br.ufpb.dcx.aps.atividades.atv03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {
    private Map<Integer, Conta> contas = new HashMap<Integer, Conta>();
    private int numeroContaLivre;
    private Map<String, Correntista> correntistas = new HashMap<String,Correntista>();
    private String nome;


    public Banco (){
        this.numeroContaLivre = 0;
        this.nome = "";
    }

    public Banco (String nome){

        this.nome = nome;
    }

    public Conta getConta(int conta){
        return contas.get(conta);
    }

    public Conta getConta(Correntista titular){
        for(Conta g: this.contas.values()){
            if(g.getCorrentista().equals(titular)){
                return g;
            }
        }
        return null;
    }
    public Correntista getCorrentista(String cpf){
        if (correntistas.containsKey(cpf)){
            return correntistas.get(cpf);
        }
        else{
            throw new RuntimeException("Não existe correntista com cpf:"+cpf);
        }
    }
    private int gerarNumeroConta() {
        int num = this.numeroContaLivre;
        setNumeroContaLivre(this.contas.size()+1);
        return num;

        /*int numConta = 1;
        for(Map.Entry<Integer, Conta> numeroPesquisado : contas.entrySet()){
            if(numeroPesquisado.getKey() != numConta){
                return numConta;

            }
            numConta ++;
        }
        return numConta;*/

    }
    public void setNumeroContaLivre(int numeroContaLivre){
        this.numeroContaLivre = numeroContaLivre;
    }

    public int geradorDeId(){
        Random h = new Random();
        int i = h.nextInt(99999);
        return i;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void addCorrentista(Correntista correntista) throws BancoException{
        if (!Correntista.cpfValido(correntista.getCpf())){
            correntistas.put(correntista.getCpf() , correntista);
            throw new RuntimeException("CPF invalido:" +correntista.getCpf());
        }
        if (this.correntistas.containsKey(correntista.getCpf())) {
            throw new RuntimeException("Correntista ja cadastrado:Correntista{cpf='"+correntista.getCpf()+"', nome='"+correntista.getNome()+"'}");
        }
        correntistas.put(correntista.getCpf(), correntista);

    }

    public Conta criarConta (Correntista correntista){
        if (!correntistas.containsKey(correntista.getCpf())){
            throw new RuntimeException("Correntista não cadastrado no banco:Correntista{cpf='" +correntista.getCpf()+"', nome='"+correntista.getNome()+"'}");
        }
        for (Conta y : contas.values()){
            if (y.getCorrentista().equals(correntista)){
                throw new RuntimeException("Correntista já tem conta cadastrada");
            }
        }
        numeroContaLivre = geradorDeId();
        Conta j = new Conta(correntista, numeroContaLivre, this);
        contas.put(gerarNumeroConta(), j);
        return j;

       /* if(correntistas.isEmpty()) {
            throw new RuntimeException("Correntista não cadastrado no banco:Correntista{cpf='" + correntista.getCpf() + "', nome='" + correntista.getNome() + "'}");
        }
        else{
            this.contas.put(gerarNumeroConta(), j);
        }
        return j;*/
    }

}

