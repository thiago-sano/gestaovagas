package br.com.rocketseat.gestaovagas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FirstTest {

    @Test
    void deve_ser_possivel_calcular_dois_numeros() {
        var result = calculate(2, 3);
        assertEquals(5, result);
    }

    @Test
    void validar_valor_incorreto() {
        var result = calculate(2, 3);
        assertNotEquals(4, result);
    }

    public static int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
