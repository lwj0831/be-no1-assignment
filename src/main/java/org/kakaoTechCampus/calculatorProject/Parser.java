package org.kakaoTechCampus.calculatorProject;

public class Parser {
    
    //간단하게 소수점(.) 포함되있는 경우 실수로 판단
    public static Number parseNumber(String numStr) {
        if (numStr.contains(".")) return Double.parseDouble(numStr);
        else return Integer.parseInt(numStr);
    }
}
