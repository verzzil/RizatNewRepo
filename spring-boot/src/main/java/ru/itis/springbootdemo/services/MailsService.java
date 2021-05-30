package ru.itis.springbootdemo.services;

public interface MailsService {
    void sendEmailForConfirm(String email, String code);
}
