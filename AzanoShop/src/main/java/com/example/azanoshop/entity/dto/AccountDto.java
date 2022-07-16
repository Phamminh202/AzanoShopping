package com.example.azanoshop.entity.dto;

import com.example.azanoshop.entity.myenum.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String id;
    @NotEmpty(message = "username missing")
    private String username;
    @NotEmpty(message = "password missing")
    @Min(value = 8, message = "password not strong enough")
    private String password;
    @NotEmpty(message = "password repeat missing")
    private String rePass;
    @NotEmpty(message = "fullname missing")
    private String fullname;
    @NotEmpty(message = "email missing")
    @Email(message = "email wrong")
    private String email;
    @NotEmpty(message = "phone missing")
    private String phone;
    @NotEmpty(message = "address missing")
    private String address;
    private String thumbnail;
    private String detail;
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;
    private int role;
}
