package org.kakaoTechCampus.calculatorProject.level3;

import java.util.List;

public class ArithmeticCalculator <T extends Number>{
    private final OperationResults<Number> operationResults;

    public ArithmeticCalculator(OperationResults<Number> operationResults) {
        this.operationResults = operationResults;
    }

    public T calculate(T num1, T num2, OperatorType operatorType) {
        T result = switch (operatorType) {
            case PLUS -> add(num1, num2);
            case MINUS -> subtract(num1, num2);
            case MULTIPLY -> multiply(num1, num2);
            case DIVIDE -> divide(num1, num2);
        };
        if(result!=null) operationResults.save(result);
        removeResult();
        return result;
    }

    private T add(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        }
        return null;
    }

    private T subtract(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() - num2.intValue());
        } else if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        }
        return null;
    }

    public T multiply(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf(num1.intValue() * num2.intValue());
        } else if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        }
        return null;
    }

    public T divide(T num1, T num2) {
        try {
            if (num1 instanceof Integer && num2 instanceof Integer) {
                return (T) Integer.valueOf(num1.intValue() / num2.intValue());
            } else if (num1 instanceof Double || num2 instanceof Double) {
                return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
            }
        }catch (ArithmeticException e){
            System.out.println("divide by zero error occurs!");
        }
        return null;
    }

    public void printBiggerResults(T num) {
        if (num instanceof Integer) {
            operationResults.getResults().stream()
                    .filter(result -> result.intValue() > num.intValue())
                    .forEach(System.out::println);
        } else if (num instanceof Double) {
            operationResults.getResults().stream()
                    .filter(result -> result.doubleValue() > num.doubleValue())
                    .forEach(System.out::println);
        }
    }

    public void printOperationResults(){
        List<Number> results = operationResults.getResults();
        for (int i=1;i<=results.size();i++){
            System.out.println(i + "번째 연산 결과: " + results.get(i-1));
        }
    }

    public void removeResult(){
        if(isRemovable()) this.operationResults.delete();
    }

    //이전 연산 결과 3개만 저장하도록 설계
    public boolean isRemovable(){
        return this.operationResults.getSize() > 3;
    }

}
