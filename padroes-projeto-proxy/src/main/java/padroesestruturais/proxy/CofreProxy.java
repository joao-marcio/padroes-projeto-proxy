package padroesestruturais.proxy;

import java.util.List;

public class CofreProxy implements ICofre {

    private Cofre cofre;

    private Integer codigo;

    public CofreProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosCofre() {
        if (this.cofre == null) {
            this.cofre = new Cofre(this.codigo);
        }
        return this.cofre.obterDadosCofre();
    }

    @Override
    public Float obterValores(Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.cofre == null) {
            this.cofre = new Cofre(this.codigo);
        }
        return this.cofre.obterValores(funcionario);
    }
}
