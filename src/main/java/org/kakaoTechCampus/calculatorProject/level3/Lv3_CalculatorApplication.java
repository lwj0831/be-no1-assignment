package org.kakaoTechCampus.calculatorProject.level3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv3_CalculatorApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lv3_OperationResults<Number> lv3OperationResults = new Lv3_OperationResults<>();
        Lv3_ArithmeticCalculator<Integer> intCalculator = new Lv3_ArithmeticCalculator<>(lv3OperationResults);
        Lv3_ArithmeticCalculator<Double> doubleCalculator = new Lv3_ArithmeticCalculator<>(lv3OperationResults);

        while(true) {
            Number num1;
            Number num2;
            String operator="";
            Lv3_OperatorType operatorType;

            //Input num1, num2, operator
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = Lv3_Parser.parseNumber(scanner.next());
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = Lv3_Parser.parseNumber(scanner.next());
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.next();
                operatorType = Lv3_OperatorType.getOperatorType(operator);
            }catch (NumberFormatException e) {
                System.out.println("잘못된 피연산자를 입력하였습니다. 다시 입력해주세요!");
                scanner.nextLine(); //Scanner 버퍼 초기화
                continue;
            }
            catch(InputMismatchException e) {
                System.out.println("지원하지 않는 연산자(" + operator + ")입니다. 다시 입력해주세요!");
                continue;
            }

            //Calculate
            //Delete Result
            //Print Previous Results
            if (num1 instanceof Double || num2 instanceof Double) {
                Double result;
                try {
                    result = doubleCalculator.calculate(num1.doubleValue(), num2.doubleValue(), operatorType);
                }catch (ArithmeticException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. 다시 입력해주세요!");
                    continue;
                }
                System.out.println("결과: " + num1 + operatorType.getSymbol() + num2 + " = " + result);
                doubleCalculator.printOperationResults();
            } else {
                Integer result;
                try {
                    result = intCalculator.calculate(num1.intValue(), num2.intValue(), operatorType);
                } catch (ArithmeticException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. 다시 입력해주세요!");
                    continue;
                }
                System.out.println("결과: " + num1 + operatorType.getSymbol() + num2 + " = " + result);
                intCalculator.printOperationResults();
            }

            //Check Exit
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitResponse = scanner.next();
            if(exitResponse.equals("exit")) break;
        }
    }
}
