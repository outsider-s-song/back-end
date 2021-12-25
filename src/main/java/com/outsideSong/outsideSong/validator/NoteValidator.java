package com.outsideSong.outsideSong.validator;

import java.util.regex.Pattern;

public class NoteValidator {

    public static boolean validateNickname(String nickname) {

        if (!Pattern.matches("^.{2,8}$", nickname)) {
            throw new IllegalStateException("닉네임은 2글자 이상 8글자 이하입니다");
        }

        return true;
    }

    public static boolean validateContent(String content) {

        if (!Pattern.matches("^.{1,25}$", content)) {
            throw new IllegalStateException("한마디는 최대 25자까지 가능합니다");
        }

        return true;
    }

    public static boolean validatePassword(String password) {

        if (!Pattern.matches("^.{4,10}$", password)) {
            throw new IllegalStateException("비밀번호는 4자 이상 10자 이하입니다");
        }

        return true;
    }
}
