package br.com.db1.passwordmeter.business;

import br.com.db1.passwordmeter.additions.Additions;
import br.com.db1.passwordmeter.deductions.Deductions;
import br.com.db1.passwordmeter.service.Rate;

public class PasswordBS {


    Additions additions = new Additions();
    Deductions deductions = new Deductions();
    Rate rate = new Rate();
    int[] valor = new int[16];

    public int score(String senha){
        int len = senha.length();
        int score = 0,
            n = 0,
            bonus = 0,
            requirements = 0,
            count = 0;
        boolean lenOK= false;

        //adição dos bonus
        n = additions.numberOfCharacters(senha);
        bonus += rate.rate4(n, len);

        n = additions.uppercaseLetters(senha);
        if (n > 0 && n < len)
            bonus += rate.rateNLen(n, len);
        if(n > 0) requirements++;

        n = additions.lowercaseLetters(senha);
        if (n > 0 && n < len)
            bonus += rate.rateNLen(n, len);
        if(n > 0) requirements++;

        n = additions.numbers(senha);
        if (n > 0 && n < len)
            bonus += rate.rate4(n, len);
        if(n > 0) requirements++;

        n = additions.symbols(senha);
        bonus += rate.rate6(n, len);
        if(n > 0) requirements++;

        n = additions.numbersSymbols(senha);
        bonus += rate.rate2(n, len);

        //subtração dos bonus
        n = deductions.lettersOnly(senha);
        bonus += rate._rateN(n, len);

        n = deductions.numbersOnly(senha);
        bonus += rate._rateN(n, len);

        n = deductions.repeatCharacters(senha);
        bonus += deductions.rate(n, len);

        n = deductions.consecutiveUppercaseLetters(senha);
        bonus += rate._rate2(n, len);

        n = deductions.consecutiveLowercaseLetters(senha);
        bonus += rate._rate2(n, len);

        n = deductions.consecutiveNumbers(senha);
        bonus += rate._rate2(n, len);

        n = deductions.sequentialLetters(senha);
        bonus += rate._rate3(n, len);

        n = deductions.sequentialNumbers(senha);
        bonus += rate._rate3(n, len);

        n = deductions.sequentialSymbols(senha);
        bonus += rate._rate3(n, len);

        //verifica se a senha tem mais de 8 caracteres
        if(len >= 8) lenOK = true;
        count = requirements;
        if(lenOK) count++;

        if((lenOK == true) && (requirements >= 3)){
            n = count;
            bonus += rate.rate2(n, len);
        }


        score += bonus;

        if(score < 0){
            score = 0;
        }else if(score > 100){
            score = 100;
        }

        return score;
    }
}
