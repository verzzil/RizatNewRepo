package ru.itis.springbootdemo.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Slf4j
@Component
public class SmsServiceSmsRuImpl implements SmsService {

    @Value("${sms.ru.url}")
    private String smsUrl;

    @Value("${sms.ru.api_id}")
    private String apiId;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void sendSms(String phone, String text) {
        String url = smsUrl + "?api_id=" + apiId + "&to=" + phone + "&msg=" + text + "&json=1";
        log.info(url);
        String result = restTemplate.getForObject(url, String.class);
        log.info(result);
    }
}

