package br.com.db1.passwordmeter.deductions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deductions {

    private Double repNum = 0d;

    //metodo para validar se tem apenas letra
    public int lettersOnly(String senha){
        String exp = "^[a-zA-Z\\s]*$";
        return senha.matches(exp) ? senha.length() : 0;
    }

    //metodo para validar se tem apenas numero na senha
    public int numbersOnly(String senha){
        String exp = "^[\\d\\s]*$";
        return senha.matches(exp) ? senha.length() : 0;
    }

    public int repeatCharacters(String senha) {
        int i = 0;
        int length = senha.length();
        for (int a = 0; a < length; a++) {
            boolean bCharExists = false;
            for (int b = 0; b < length; b++) {
                if (senha.charAt(a) == senha.charAt(b) && a != b) {
                    bCharExists = true;
                    repNum += Math.abs((float) length / (b - a));
                }
            }
            if (bCharExists) {
                i++;
                int unqChar = length - i;
                repNum = (unqChar != 0) ? Math.ceil(repNum / unqChar) : Math.ceil(repNum);
            }
        }
        return i;
    }

    //conta qtd de letras consecutivas maiúsculas
    public int consecutiveUppercaseLetters(String senha){
        Pattern exp = Pattern.compile("([A-Z]{2,})");
        Matcher matcher = exp.matcher(senha.replaceAll("\\s", ""));
        int i = 0;
        while (matcher.find())
            i += (matcher.group().length() - 1);
        return i;
    }


    //conta qtd de letras consecutivas minsúculas
    public int consecutiveLowercaseLetters(String senha){
        Pattern exp = Pattern.compile("([a-z]{2,})");
        Matcher matcher = exp.matcher(senha.replaceAll("\\s", ""));
        int i = 0;
        while (matcher.find())
            i += (matcher.group().length() - 1);
        return i;
    }

    //conta qtd de letras consecutivas minsúculas
    public int consecutiveNumbers(String senha){
        Pattern exp = Pattern.compile("([\\d]{2,})");
        Matcher matcher = exp.matcher(senha.replaceAll("\\s", ""));
        int i = 0;
        while (matcher.find())
            i += (matcher.group().length() - 1);
        return i;
    }

    //contar a sequencia de letras
    public int sequentialLetters(String senha){
        String ltr = "abcdefghijklmnopqrstuvwxyz";
        int count = 0;
        for (int i = 0; i < (ltr.length() - 3); i++) {
            String fwd = ltr.substring(i, i + 3);
            String rev = new StringBuilder(fwd).reverse().toString();
            if (senha.toLowerCase().contains(fwd) || senha.toLowerCase().contains(rev))
                count++;
        }
        return count;
    }

    //contar a sequencia de numeros
    public int sequentialNumbers(String senha){
        String num = "01234567890";
        int count = 0;
        for (int i = 0; i < (num.length() - 3); i++) {
            String fwd = num.substring(i, i + 3);
            String rev = new StringBuilder(fwd).reverse().toString();
            if (senha.toLowerCase().contains(fwd) || senha.toLowerCase().contains(rev))
                count++;
        }
        return count;
    }

    //contar a sequencia de simbolos
    public int sequentialSymbols(String senha){
        String sbl = "!@#$%^&*()";
        int count = 0;
        for (int i = 0; i < (sbl.length() - 3); i++) {
            String fwd = sbl.substring(i, i + 3);
            String rev = new StringBuilder(fwd).reverse().toString();
            if (senha.toLowerCase().contains(fwd) || senha.toLowerCase().contains(rev))
                count++;
        }
        return count;
    }


    //rata para caracteres repetido
    public int rate(int n, int len) {
        int rate = -repNum.intValue();
        repNum = 0d;
        return rate;
    }

}
