package org.kakaoTechCampus.calculatorProject.level3;

import java.util.List;

public class Lv3_Calculator {
    private Lv3_OperationResults<Integer> lv3OperationResults;

    public Lv3_Calculator() {
        this.lv3OperationResults = new Lv3_OperationResults<>();
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
                throw new IllegalArgumentException("Invalid operator!");
        }
        if(!isError) this.lv3OperationResults.save(result);
        removeResult();
        return result;
    }

    public void printOperationResults(){
        List<Integer> results = lv3OperationResults.getResults();
        for (int i=1;i<=results.size();i++){
            System.out.println(i + "번째 연산 결과: " + results.get(i-1));
        }
    }

    public void setOperationResults(Lv3_OperationResults<Integer> lv3OperationResults) {
        this.lv3OperationResults = lv3OperationResults;
    }

    public void removeResult(){
        if(isRemovable()) this.lv3OperationResults.delete();
    }
    
    //이전 연산 결과 3개만 저장하도록 설계
    public boolean isRemovable(){
        return this.lv3OperationResults.getSize() > 3;
    }
}
