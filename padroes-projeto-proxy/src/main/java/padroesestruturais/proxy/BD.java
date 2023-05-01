package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Cofre> cofres = new HashMap<>();

    public static Cofre getCofre(Integer codigo) {
        return cofres.get(codigo);
    }

    public static void addAluno(Cofre cofre) {
        cofres.put(cofre.getCodigo(), cofre);
    }
}
