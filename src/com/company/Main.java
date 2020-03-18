package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    }


    //1. No livro [1], faça pelo menos 5 dos seguintes exercícios do capítulo 18: 18.7, 18.8, 18.9, 18.12, 18.13, 18.14, 18.16, 18.17 e 18.18.

    //18.07
    /*
    O que o seguinte código faz?
    public int mystery(int a, int b){
        if(b == 1){
            return a;
        }
        else
        return a + mystery(a, b-1);
    }
    R: Faz a multiplicação dos dois inteiros, porém através
    de uma soma. Por exemplo:
    int a = 2
    int b = 3
    1a iteração 2 + mystery(2, 2)
    2a iteração 2 + mystery(2, 1)
    3a iteração 2
    Retorno = 6;
     */

    //18.09

    /**
     * O método a seguir faz a exponenciação da base.
     * EX: power(3, 4) = 3*3*3*3  = 81.
     * @param base - base a ser multiplicada.
     * @param expoente - expoente que determina quantas vezes a base será multiplicada.
     * @return - o valor da exponenciação da base.
     */
    public static int power(int base, int expoente){
        if(expoente == 1){
            return base;
        }
        return base * power(base, expoente-1);
    }
    //18.14

    /**
     * O método a seguir verifica se uma String é um Palíndromo de forma recursiva.
     * Ex: Se String = "ovo", "arara"
     * O retorno deve ser = true
     * @param str - String a ser verificada.
     * @return - True ou False.
     */
    public static boolean isPalindromoRecursivo(String str){
        return isPalindromoRecursivo(str, 0, str.length()-1);
    }

    /**
     * O método a seguir é um auxiliar ao método "isPalindromoRecursivo(String str)".
     * @param s - String a ser verificada.
     * @param i - Contador de Recursiviade.
     * @param f - Contador de Recursividade.
     * @return - De forma recursiva o valor True ou False.
     */
    public static boolean isPalindromoRecursivo(String s, int i, int f){
        boolean resp;
        if(i < (f/2)){
            resp = true;
        }

        if(s.charAt(i) != s.charAt(f)){
            return resp = false;
        }else {
            if(i>=(s.length()-1)) return true;
            resp = isPalindromoRecursivo(s,i+1,f-1);

        }
        return resp;
    }

    //18.17

    /**
     * O método a seguir exibe a String de trás para frente.
     * @param str - String a ser revertida.
     * @return - String ao contrário.
     */
    public static String stringReverse(String str){
        int contador = str.length()-1;
        String resposta = "";
        char[] newStr = str.toCharArray();
        return stringReverse(newStr, contador, resposta);
    }

    /**
     * O método a seguir é um método auxiliar do método "stringReverse(String str)".
     * @param str - String a ser revertida.
     * @param contador - tamanho da string a ser revertida.
     * @param resposta - variável para guardar os valores atualizados da String revertida.
     * @return - De forma recursiva retorna a String reversa.
     */
    public static String stringReverse(char[] str, int contador, String resposta){
        if (contador == 0){
            return resposta+str[contador];
        }
        resposta = resposta + str[contador];
        return stringReverse(str, contador-1, resposta);
    }

    //18.18

    /**
     * O método a seguir recebe um array de inteiros e retorna o menor
     * inteiro existente dentro do array.
     * @param array -  array de inteiros a ser verificado
     * @return - menor inteiro dentro do array.
     */
    public static int recursiveMinimum(int[] array){
        int tamanho = array.length-1;
        int retorno = array[tamanho];
        return recursiveMinimum(array, tamanho, retorno);
    }

    /**
     * O método a seguir é um método auxiliar para o método "recursiveMinimum(int[] array)".
     * @param array - array de inteiros a ser verificado
     * @param tamanho - tamanho do array.
     * @param retorno - variável que guarda o valor de resposta.
     * @return - De forma recursiva, retorna o menor inteiro dentro do array.
     */
    public static int recursiveMinimum(int[] array, int tamanho, int retorno){
        if (tamanho == 0){
            if(array[tamanho] < retorno) retorno = array[tamanho];
            return retorno;
        }
        if (array[tamanho] < retorno) retorno = array[tamanho];

        return recursiveMinimum(array, tamanho-1, retorno);
    }

    /*
    2. Considere o seguinte método a seguir, implementado na linguagem Java:

    public static boolean existe(int chave, List<Integer> vals) {
    boolean existeChave = false;
        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i) == chave) existeChave = true;
        }
            return existeChave;
    }

    Faça o que se pede:
    (a) Implemente uma versão de existe que seja puramente recursiva.
    */

    /**
     * O método a seguir verifica de forma puramente recursiva se existe
     * determinado número dentro da lista.
     * @param chave - número a ser procurando dentro da lista.
     * @param vals  - lista de números.
     * @return - True ou False.
     */
    public static boolean existe(int chave, List<Integer> vals){
        return existeRecursivoPuro(chave, vals, vals.size()-1);
    }

    /**
     * O método a seguir é um método auxiliar ao método "existe(int chave, List<Integer> vals)".
     * @param chave - número a ser procurado dentro da lista.
     * @param vals - lista de números
     * @param tamanho - variável que controla o método recursivo.
     * @return - True ou False.
     */
    public static boolean existeRecursivoPuro(int chave, List<Integer> vals, int tamanho){
        if (tamanho == 0 && vals.get(tamanho) != chave){
            return false;
        }
        if(vals.get(tamanho) == chave){
            return true;
        }
        return existeRecursivoPuro(chave, vals, tamanho-1);
    }
    /*
    (b) Implemente uma versão de existe que seja tail recursiva.
     */

    /**
     * O método a seguir verifica, utilizando recursividade Tail,
     * se existe determinado número dentro da lista.
     * @param chave - número a ser procurado dentro da lista.
     * @param vals - lista de números.
     * @param tail - 0
     * @return - True ou False.
     */
    public static boolean existeRecursivo(int chave, List<Integer> vals, int tail) {
        if (vals.size() == 1) {
            if (chave == vals.get(tail)) return true;
        } else if (chave == vals.get(tail)) {
            return true;
        }else{
            vals = vals.subList(tail+1, vals.size());
            return existeRecursivo(chave, vals, tail);
        }
        return false;
    }

    /**
     * O método a seguir verifica, utilizando recursividade Tail,
     * se existe determinado número dentro da lista.
     * @param chave - número a ser procurado dentro da lista.
     * @param vals - lista de números.
     * @return - True ou False.
     */
    public static boolean existeTailRecusivo(int chave, List<Integer> vals) {
        return existeRecursivo(chave, vals, 0);
    }


    /*
    3. Implemente um método que valide uma string formada por quaisquer caracteres,
    mas que para cada caractere de abertura '(', '[' ou '{' haja outro ')', ']' ou '}'
    correspondente de fechamento. Sob essa regra, são strings válidas "", "abc", "a(bc)", "[[[]]]" e "{[a]b}c(d)",
    enquanto são inválidas "(", "}", "ab(c", "a}bc", "a({bc}" e "a({)b}"
     */

    public static String validador(String str){
        return "";
    }

    /*
    Referências
    [1] DEITEL, Paul; DEITEL, Harvey. Java: como programar. 10 ed. São Paulo: Pearson Education do Brasil, 2017. ISBN 978-430-0479-2.
    Livro disponível na biblioteca de eBooks da Pearson, acessível pelo Portal do Aluno.
     */

}
