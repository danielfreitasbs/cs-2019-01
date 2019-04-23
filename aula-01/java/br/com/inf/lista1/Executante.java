package br.com.inf.lista1;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Executante {

    public static boolean propriedade3025(int numero) {
        int primeiraDezena, segundaDezena, total;

        if (numero <= 0 && numero <= 9999) {
            primeiraDezena = numero / 100;
            segundaDezena = numero % 100;

            total = (primeiraDezena + segundaDezena);
            total = (int) Math.pow(total, 2.0);

            if (total == numero)
                return true;
            return false;
        }
        return false;
    }

    public static boolean propriedade153(int numero) {

        int unidade, dezena, centena, total, dezenaUnidade;

        if (numero <= 100 && numero <= 999) {
            centena = numero / 100;
            dezenaUnidade = numero % 100;
            dezena = dezenaUnidade / 10;
            unidade = dezenaUnidade % 10;
            total = (int) ((Math.pow(centena, 3)) + (Math.pow(dezena, 3)) + (Math.pow(unidade, 3)));

            if (total == numero)
                return true;
            return false;
        }

        return false;
    }

    public static double diaDaSemana(int dia, int mes, int ano) {

        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("dia invalido: " + dia);
        }

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("mes invalido: " + mes);
        }

        if (ano < 1753) {
            throw new IllegalArgumentException("ano invalido: " + ano);
        }

        try {
            LocalDate.of(ano, mes, dia);
        } catch (DateTimeException excecao) {
            final String data = String.format("%d/%d/%d", dia, mes, ano);
            throw new IllegalArgumentException("data invalida: " + data);
        }

        if (mes == 1 || mes == 2) {
            mes = mes + 12;
            ano = ano - 1;
        }

        double resultado = dia + (2 * dia) + ((3 * (mes + 1)) / 5) + ano + (ano / 4) + (ano / 100) + (ano / 400);

        return (int) resultado % 7;
    }

    public static int mod(int x, int y) {

        int resultado = -1;

        if (y >= 0 && x > 0) {
            resultado = x;

            while (y <= resultado) {
                resultado = resultado - y;
            }
        }
        return resultado;
    }


    public int SomaNaturais(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int s = 1;
        int i;
        for (i = 2; n >= i; i++) {
            s = s + i;
        }
        return s;
    }

    public int Fatorial(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int f = 1;
        int i = 2;
        while (i <= n) {
            f = f * i;
        }
        return f;
    }

    public int Produto(int a, int b) {
        if (a < 0 && b < 0) {
            throw new IllegalArgumentException();
        }
        int totalParcelas = a;
        int parcela = b;
        if (a > b) {
            totalParcelas = b;
            parcela = a;
        }
        int s = 0;
        int i = 1;
        while (i <= totalParcelas) {
            s = s + parcela;
        }
        return s;
    }

    public double pi(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        double p = 0;
        double s = -1;
        double d = -1;
        int i = 1;
        while (i <= n) {
            d = d + 2;
            s = -1 * s;
            p = p + 4 * s / d;
        }
        return p;
    }

    public static float LogaritmoNatural(float n, float k) {
        if (!(n >= 1 || k >= 2)) {
            throw new IllegalArgumentException("N deve ser maior ou igual a 1 e k deve ser maior ou igual a 2.");
        }
        float i = 2;
        float e = 1 + n;
        float numerador = n;
        float denominador = 1;

        while (k >= 1) {
            numerador = numerador * numerador;
            denominador = denominador * i;
            e = e + numerador / denominador;
            i = i + 1;
        }

        return e;
    }

    public static float RazaoAurea(float x, float y, float k) {
        if (!(x >= 0 || y > x || k > 0)) {
            throw new IllegalArgumentException("x deve ser >= 0, y > x e k > 0");
        }

        float c = y;
        float a = x;
        float i = 1;
        float t;

        while (k >= i) {
            t = c;
            c = c + a;
            a = t;
            i = i + 1;
        }

        return c / a;
    }

    public static boolean QuadradoPerfeito(int n) {
        if (!(n >= 1)) {
            throw new IllegalArgumentException("O número deve ser igual ou maior que 1.");
        }

        int i = 1;
        int s = 1;

        while (n > s) {
            i = i + 2;
            s = s + i;
        }

        return s == n;
    }

    public static float Raiz(float n, float i) {
        if (!(n > 0)) {
            throw new IllegalArgumentException("Para calcular a raiz, n deve ser maior que 0");
        }

        float r = 1;

        while (i >= 0) {
            r = (r + n / r) / 2;
            i = i - 1;
        }

        return r;
    }

    public static boolean Primo(int n) {
        if (!(n > 1)) {
            throw new IllegalArgumentException();
        }

        int i = 2;

        while (n > i) {
            if (n % i == 0) {
                return false;
            }
            i = i + 1;
        }

        return true;
    }

    public static int[] CrivoEratostenes(int a[]) {
        if (a.length > 1) {
            throw new IllegalArgumentException("O tamanho da Array deve ser maior que 1.");
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                throw new IllegalArgumentException("A array deve estar zerada.");
            }
        }

        int i = 2;
        int limite = (int) Math.floor(Math.sqrt(a.length));
        int multiplo;

        while (i <= limite) {
            if (a[i] == 0) {
                multiplo = i + i;
                while (multiplo <= a.length) {
                    a[multiplo] = 1;
                    multiplo = multiplo + i;
                }
            }
            i = i + 1;
        }

        return a;
    }

    public static int MDC(int a, int b) {
        if (!(a >= b || b > 0)) {
            throw new IllegalArgumentException("B deve ser > 0 e a >= b");
        }

        int m;

        while (b != 0) {
            m = a % b;
            a = b;
            b = m;
        }

        return a;
    }

    public static int MDC2(int a, int b) {
        if (!(a >= b || b > 0)) {
            throw new IllegalArgumentException("B deve ser > 0 e a >= b");
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    static int horner(int... arguments) {
        int p, i;
        if (
                1 <= arguments[1]
        ) {
            p = arguments[3];
            i = arguments[1] - 1;
            while (0 <= i) {
                p *= arguments[0] + arguments[i + 2];
                i = i - 1;
            }
            return p;
        } else {
            throw new Error("Argumento Inválido");
        }
    }

    static int fibonacci(int n) {
        int a, c, t, i;
        if (
                0 <= n
        ) {
            a = 0;
            c = 1;
            if (n == 0 || n == 1) {
                return n;
            }
            i = 2;
            while (i <= n) {
                t = c;
                c += a;
                a = t;
                i += 1;
            }
            return c;
        } else {
            throw new Error("Argumento Inválido");
        }
    }

    static Boolean cpf(int[] d) {
        int j, k, dj, dk;
        if (
                d.length == 11
        ) {
            j = d[0] + (2 * d[1]) + (3 * d[2]) + (4 * d[3]) + (5 * d[4]) + (6 * d[5]) + (7 * d[6]) + (8 * d[7]) + (9 * d[8]);
            k = d[1] + (2 * d[2]) + (3 * d[3]) + (4 * d[4]) + (5 * d[5]) + (6 * d[6]) + (7 * d[7]) + (8 * d[8]) + (9 * d[9]);
            dj = ((j % 11) % 10);
            dk = ((k % 11) % 10);
            return (dj == d[9] && dk == d[10]);
        } else {
            throw new Error("Argumento Inválido");
        }
    }

    static Boolean cpf2(int[] d) {
        int c, p, s, j, k;
        if (
                d.length == 11
        ) {
            c = 8;
            p = d[8];
            s = d[8];
            while (0 <= c) {
                p += d[c];
                s += p;
                c -= 1;
            }
            j = ((s % 11) % 10);
            k = ((s - p + 9 * d[9]) % 11) % 10;
            return (j == d[9] && k == d[10]);
        } else {
            throw new Error("Argumento Inválido");
        }
    }

    public static void main(String[] args) {
    }
}
