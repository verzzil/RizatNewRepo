package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignInDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.dto.UserSettingsDto;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.itis.springbootdemo.dto.UserDto.*;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = usersRepository.getOne(userId);
        return UserDto.from(user);
    }

    @Override
    public List<UserDto> findAll() {
        return usersRepository.findAll().stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public boolean confirmUser(String code) {
        User user = usersRepository.findByConfirmCode(code).orElseThrow(IllegalArgumentException::new);
        user.setState(State.CONFIRMED);

        usersRepository.save(user);

        return true;
    }

    @Override
    public Optional<UserDto> signIn(SignInDto signInDto) {
        Optional<User> user = usersRepository.findByEmail(signInDto.getEmail());

        if(user.isPresent())
            if(passwordEncoder.matches(signInDto.getPassword(), user.get().getPassword()))
                return Optional.ofNullable(UserDto.from(user.get()));
        return Optional.empty();
    }

    @Override
    public void changeUserSettings(UserSettingsDto userSettingsDto) {
        User user = usersRepository.findById(userSettingsDto.getUserId()).orElseThrow(IllegalArgumentException::new);

        if (userSettingsDto.getFirstName() != null) user.setFirstName(userSettingsDto.getFirstName());
        if (userSettingsDto.getLastName() != null) user.setLastName(userSettingsDto.getLastName());
        if (userSettingsDto.getPhone() != null) user.setPhone(userSettingsDto.getPhone());
        if (userSettingsDto.getAge() != null) user.setAge(userSettingsDto.getAge());
        if (userSettingsDto.getSex() != null) user.setSex(userSettingsDto.getSex());

        usersRepository.save(user);
    }
}
