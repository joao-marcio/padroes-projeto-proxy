package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Cofre implements ICofre {

    private Integer codigo;
    private String nome;
    private String local;
    private Float valor;


    public Cofre(int codigo) {
        this.codigo = codigo;
        Cofre objeto = BD.getCofre(codigo);
        this.nome = objeto.nome;
        this.local = objeto.local;
        this.valor = objeto.valor;
    }

    public Cofre(Integer codigo, String nome, String local, Float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosCofre() {
        return Arrays.asList(this.nome, this.local);
    }

    @Override
    public Float obterValores(Funcionario funcionario) {
        return this.valor;
    }
}
