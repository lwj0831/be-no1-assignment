package org.kakaoTechCampus.calculatorProject;

import java.util.List;

public class Calculator {
    private OperationResults operationResults;

    public Calculator() {
        this.operationResults = new OperationResults();
    }

    public int calculate(int num1, int num2, String operator) throws ArithmeticException{
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
                try {
                    result = num1 / num2;
                    break;
                }catch (ArithmeticException e){
                    System.out.println("divide by zero error occurs!");
                    isError = true;
                    break;
                }
            default:
                System.out.println("operator error");
        }
        if(!isError) this.operationResults.save(result);
        return result;
    }

    public void printOperationResults(){
        List<Integer> results = operationResults.getResults();
        for (int i=1;i<=results.size();i++){
            System.out.println(i + "번째 연산 결과: " + results.get(i-1));
        }
    }

    public void setOperationResults(OperationResults operationResults) {
        this.operationResults = operationResults;
    }

    public void removeResult(){
        if(isRemovable()) this.operationResults.delete();
    }
    
    //이전 연산 결과 3개만 저장하도록 설계
    public boolean isRemovable(){
        return this.operationResults.getSize() > 3;
    }
}
