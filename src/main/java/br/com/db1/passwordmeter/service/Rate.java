package br.com.db1.passwordmeter.service;

public class Rate {

    public int rate2(int n, int len){
        return +(n * 2);
    }

    public int rate4(int n, int len){
        return +(n * 4);
    }

    public int rate6(int n, int len){
        return +(n * 6);
    }

    public int rateNLen(int n, int len){
        return +((len -n) * 2);

    }

    public int _rateN(int n, int len){
        return -n;
    }

    public int _rate2(int n, int len){
        return -(n * 2);
    }

    public int _rate3(int n, int len){
        return -(n * 3);
    }
}
