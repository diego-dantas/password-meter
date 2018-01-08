package br.com.db1.passwordmeter.additions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Additions {

    //conta os numeros de caracteres
    public int numberOfCharacters(String senha){
        return senha.length();
    }

    //conta qtd de letras maiúsculas
    public int uppercaseLetters(String senha){
        Pattern exp = Pattern.compile("([A-Z]+)");
        Matcher matcher = exp.matcher(senha);
        int i = 0;
        while (matcher.find())
            i += matcher.group().length();
        return i;
    }

    //Conta qtd de letras minúsculas
    public int lowercaseLetters(String senha){
        Pattern exp = Pattern.compile("([a-z]+)");
        Matcher matcher = exp.matcher(senha);
        int i = 0;
        while (matcher.find())
            i += matcher.group().length();
        return i;
    }

    //contar qtd de números na senha
    public int numbers(String senha){
        Pattern exp = Pattern.compile("([\\d]+)");
        Matcher matcher = exp.matcher(senha);
        int i = 0;
        while (matcher.find())
            i += matcher.group().length();
        return i;
    }

    //conta qtd de simbolos da senha
    public int symbols(String senha){
        Pattern exp = Pattern.compile("([^a-zA-Z\\d\\s]+)");
        Matcher matcher = exp.matcher(senha);
        int i = 0;
        while (matcher.find())
            i += matcher.group().length();
        return i;
    }

    //números medios ou simbolos
    public int numbersSymbols(String senha){
        String exp = "[\\d]|[^a-zA-Z\\s]";
        int count = 0;
        String pwd = senha.replaceAll("\\s", "");
        int length = pwd.length();
        for (int i = 0; i < length; i++) {
            String c = pwd.substring(i, i + 1);
            boolean isMiddle = i > 0 && i < length - 1;
            if (c.matches(exp) && isMiddle) count++;
        }
        return count;
    }

}
