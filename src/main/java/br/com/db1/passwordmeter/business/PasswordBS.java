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
        boolean lenOK= false,
                requiredOk = false;

        //adição dos bonus
        n = additions.numberOfCharacters(senha);
        bonus += rate.rate4(n, len);
       // if(n > 0) requirements++;
        valor[0] = bonus;

        n = additions.uppercaseLetters(senha);
        if (n > 0 && n < len)
            bonus += rate.rateNLen(n, len);
        if(n > 0) requirements++;
        valor[1] = bonus;

        n = additions.lowercaseLetters(senha);
        if (n > 0 && n < len)
            bonus += rate.rateNLen(n, len);
        if(n > 0) requirements++;
        valor[2] = bonus;

        n = additions.numbers(senha);
        if (n > 0 && n < len)
            bonus += rate.rate4(n, len);
        if(n > 0) requirements++;
        valor[3] = bonus;

        n = additions.symbols(senha);
        bonus += rate.rate6(n, len);
        if(n > 0) requirements++;
        valor[4] = bonus;

        n = additions.numbersSymbols(senha);
        bonus += rate.rate2(n, len);
        //if(n > 0) requirements++;
        valor[5] = bonus;

        //subtração dos bonus
        n = deductions.lettersOnly(senha);
        bonus += rate._rateN(n, len);
        //if(n > 0) requirements++;
        valor[6] = bonus;

        n = deductions.numbersOnly(senha);
        bonus += rate._rateN(n, len);
        //if(n > 0) requirements++;
        valor[7] = bonus;

        n = deductions.repeatCharacters(senha);
        bonus += deductions.rate(n, len);
        //if(n > 0) requirements++;
        valor[8] = bonus;

        n = deductions.consecutiveUppercaseLetters(senha);
        bonus += rate._rate2(n, len);
        //if(n > 0) requirements++;
        valor[9] = bonus;

        n = deductions.consecutiveLowercaseLetters(senha);
        bonus += rate._rate2(n, len);
        //if(n > 0) requirements++;
        valor[10] = bonus;

        n = deductions.consecutiveNumbers(senha);
        bonus += rate._rate2(n, len);
        //if(n > 0) requirements++;
        valor[11] = bonus;

        n = deductions.sequentialLetters(senha);
        bonus += rate._rate3(n, len);
        //if(n > 0) requirements++;
        valor[12] = bonus;

        n = deductions.sequentialNumbers(senha);
        bonus += rate._rate3(n, len);
        //if(n > 0) requirements++;
        valor[13] = bonus;

        n = deductions.sequentialSymbols(senha);
        bonus += rate._rate3(n, len);
        //if(n > 0) requirements++;
        valor[14] = bonus;
        System.out.println("requirede  " + requirements);
        //verifica se a senha tem mais de 8 caracteres
        if(len >= 8) lenOK = true;
        count = requirements;
        if(lenOK) count++;

        if((lenOK == true) && (requirements >= 3)){
            n = count;
            bonus += rate.rate2(n, len);
        }
        valor[15] = bonus;

        score += bonus;
        int e= 0;
        for(int v : valor){
            System.out.print("Valor da posição " + e++ + " é " + v + "\n");
        }

        if(score < 0){
            score = 0;
        }else if(score > 100){
            score = 100;
        }

        return score;
    }
}
