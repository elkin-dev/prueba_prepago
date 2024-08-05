package com.prepago.prueba_estudiante.commons.util;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Shield {
    private Shield() {
    }

    public static String blindStr(String value) {
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

        return policy.sanitize(value)
                .replace("&#34;", "'")
                .replace("&#43;", "+")
                .replace("&#39;", "'")
                .replace("&#61;", "=")
                .replace("&amp;", " & ")
                .replace("&#64;", "@");
    }

    public static List<String> blindListString(List<String> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<String> listBlind = new ArrayList<>();
        for (String value : list) {
            listBlind.add(blindStr(value));
        }
        return listBlind;
    }
}
