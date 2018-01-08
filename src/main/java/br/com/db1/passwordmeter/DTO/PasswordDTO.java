package br.com.db1.passwordmeter.DTO;

public class PasswordDTO {
    private int score;
    private String level;

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public String getLevel(){
        return this.level;
    }

    public String getLevel(int score){
        int intScore = score;
        String lev = "";

        if(intScore >= 0 && intScore <= 20){
            lev = "VERY WEAK";
        }else if(intScore > 20 && intScore <= 40){
            lev = "WEAK";
        }else if(intScore > 40 && intScore <= 60){
            lev = "GOOD";
        }else if(intScore > 60 && intScore <= 80){
            lev = "STRONG";
        }else if(intScore > 80 && intScore <= 100){
            lev = "VERY STRONG";
        }


       return lev;
    }
}

