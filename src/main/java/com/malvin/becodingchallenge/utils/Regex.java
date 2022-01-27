package com.malvin.becodingchallenge.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private Regex() {

    }

    public static Long getScore(String teamAndScore) {
        Pattern scorePattern = Pattern.compile("[-+]?\\d\\D*$");
        Matcher scoreMatcher = scorePattern.matcher(teamAndScore);
        Long score = null;
        while(scoreMatcher.find()) {
            score = Long.parseLong(scoreMatcher.group());
        }
        return score;
    }

}
