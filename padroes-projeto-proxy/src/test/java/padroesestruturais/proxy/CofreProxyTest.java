package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CofreProxyTest {

    @BeforeEach
    void setUp() {
        BD.addAluno(new Cofre(1, "Alfa", "BB",200000.0f));
        BD.addAluno(new Cofre(2, "Beta", "BB",800000.0f));
    }

    @Test
    void deveRetornarDadosCofre() {
        CofreProxy cofre = new CofreProxy(1);

        assertEquals(Arrays.asList("Alfa", "BB"), cofre.obterDadosCofre());
    }

    @Test
    void deveRetonarFuncionarioAbrirCofre() {
        Funcionario funcionario = new Funcionario("Lester", true);
        CofreProxy cofre = new CofreProxy(2);

        assertEquals(800000.0f, cofre.obterValores(funcionario));
    }


    @Test
    void deveRetonarExcecaoFuncionarioNaoAutorizadoAbrirCofre() {
        try {
            Funcionario funcionario = new Funcionario("Cleiton", false);
            CofreProxy aluno = new CofreProxy(2);

            aluno.obterValores(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }

    }
}