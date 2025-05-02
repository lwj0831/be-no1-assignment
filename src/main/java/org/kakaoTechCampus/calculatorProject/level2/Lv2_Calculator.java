package org.kakaoTechCampus.calculatorProject.level2;

import java.util.List;

public class Lv2_Calculator {
    private Lv2_OperationResults lv2OperationResults;

    public Lv2_Calculator() {
        this.lv2OperationResults = new Lv2_OperationResults();
    }

    public int calculate(int num1, int num2, String operator) throws ArithmeticException, IllegalArgumentException{
        int result=0;
        boolean isError = false;
        switch (operator) {
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("divide by zero error occurs!");
        }
        if(!isError) this.lv2OperationResults.save(result);
        removeResultIfNeeded();

        return result;
    }

    public void printOperationResults(){
        List<Integer> results = lv2OperationResults.getResults();
        for (int i=1;i<=results.size();i++){
            System.out.println(i + "번째 연산 결과: " + results.get(i-1));
        }
    }

    public void setOperationResults(Lv2_OperationResults lv2OperationResults) {
        this.lv2OperationResults = lv2OperationResults;
    }

    public void removeResultIfNeeded(){
        if(isRemovable()) this.lv2OperationResults.delete();
    }

    //이전 연산 결과 3개만 저장하도록 설계
    public boolean isRemovable(){
        return this.lv2OperationResults.getSize() > 3;
    }
}
