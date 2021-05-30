package ru.itis.springbootdemo.services;



public interface SmsService {
    void sendSms(String phone, String text);
}
