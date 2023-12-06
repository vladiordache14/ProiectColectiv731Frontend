package com.example.proiectcolectiv731_be.pass_reset;

import com.example.proiectcolectiv731_be.repository.UserRepository;
import com.example.proiectcolectiv731_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/passReset")
public class PassResetController {

    @Autowired
    private GMailer mailer;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repo;

    public PassResetController(){
        mailer=new GMailer();
    }

    @PostMapping("/reset")
    public ResponseEntity<String> updatePass(String username){
        if(!repo.existsByUsername(username))
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);

        String newPass=RandomPasswordGenerator.generate();
        String mailDestination=userService.getEmailByUsername(username);
        userService.updatePassword(username, newPass);

        mailer.sendMail("Password Changed","This is your new password: "+newPass+"   CHANGE IT!!!",mailDestination);
        return new ResponseEntity<>("Done", HttpStatus.CREATED);

    }
}
