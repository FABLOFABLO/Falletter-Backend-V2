package com.example.falleterbev2.domain.user.presentation.dto;

import com.example.falleterbev2.domain.user.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignupRequest {
    @NotBlank(message = "아이디에 공백, 띄어쓰기를 사용할 수 없습니다")
    @Size(min = 2,max = 5, message = "최소 2글자부터 5글자까지 가능합니다")
    private String name;

    @NotBlank(message = "비밀번호에 공백,띄어쓰기를 포함하실수없습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$*]{8,255}$", message = "최소 8자 ~ 최대 225자까지 가능하며, 숫자, 영어 대소문자와 _!#$*만 허용됩니다")
    private String password;

    @NotBlank
    @Size(min = 4,max = 4)
    private String batch;

    @NotBlank
    private String birth;

    @NotBlank
    @Size(min = 10,max = 50)
    private String email;

    @NotNull
    private Gender gender;
}
