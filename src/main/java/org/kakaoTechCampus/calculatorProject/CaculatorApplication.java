package org.kakaoTechCampus.calculatorProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaculatorApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OperationResults<Number> operationResults = new OperationResults<>();
        ArithmeticCalculator<Integer> intCalculator = new ArithmeticCalculator<>(operationResults);
        ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>(operationResults);

        while(true) {
            Number num1;
            Number num2;
            OperatorType operatorType;

            //Input num1, num2, operator
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = Parser.parseNumber(scanner.next());
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = Parser.parseNumber(scanner.next());
                System.out.print("사칙연산 기호를 입력하세요: ");
                operatorType = OperatorType.getOperatorType(scanner.next());
            }catch(IllegalArgumentException | InputMismatchException e) {
                System.out.println("변수를 잘못 입력하였습니다. 다시 입력해주세요!");
                continue;
            }

            //Calculate
            //Delete Result
            //Print Previous Results
            if (num1 instanceof Double || num2 instanceof Double) {
                Double result = doubleCalculator.calculate(num1.doubleValue(), num2.doubleValue(), operatorType);
                System.out.println("결과: " + num1 + operatorType.getSymbol() + num2 + " = " + result);
                doubleCalculator.removeResult();
                doubleCalculator.printOperationResults();
            } else {
                Integer result = intCalculator.calculate(num1.intValue(), num2.intValue(), operatorType);
                System.out.println("결과: " + num1 + operatorType.getSymbol() + num2 + " = " + result);
                intCalculator.removeResult();
                intCalculator.printOperationResults();
            }

            //Check Exit
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitResponse = scanner.next();
            if(exitResponse.equals("exit")) break;
        }
    }
}
