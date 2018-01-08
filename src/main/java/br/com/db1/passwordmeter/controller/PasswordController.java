package br.com.db1.passwordmeter.controller;

import br.com.db1.passwordmeter.DTO.PasswordDTO;
import br.com.db1.passwordmeter.business.PasswordBS;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PasswordController {

    PasswordDTO pwd = new PasswordDTO();
    PasswordBS pwdB = new PasswordBS();
    Gson gson = new Gson();


    @PostMapping("/senha")
    public String senha(@RequestBody Map<String, String> body){
        int score = pwdB.score(body.get("senha"));
        pwd.setScore(score);
        pwd.setLevel(pwd.getLevel(score));
        return gson.toJson(pwd);
    }
}
