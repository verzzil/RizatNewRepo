package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserForm;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.UUID;


@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  MailsService mailsService;

    @Autowired
    private SmsService smsService;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .firstName((form.getFirstName()))
                .lastName((form.getLastName()))
                .state(State.NOT_CONFIRMED)
                .phone((form.getPhone()))
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(newUser);
        smsService.sendSms(form.getPhone(), "Вы зарегались!");

        mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
    }
}
