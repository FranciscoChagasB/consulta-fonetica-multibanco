package com.teste.projeto.service;

import java.text.Normalizer;

public class StringUtilsService {

    public static String normalize(String input) {
        if (input == null) return null;
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

}
