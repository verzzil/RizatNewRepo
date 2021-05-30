package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSettingsDto {
    private Long userId;
    private Integer age;
    private String firstName;
    private String lastName;
    private String phone;
    private String sex;
}
