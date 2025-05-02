package org.kakaoTechCampus.calculatorProject.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            int num1;
            int num2;
            String operator;

            scanner.nextLine(); //Scanner 버퍼 초기화
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = scanner.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.next();
            }catch(InputMismatchException e){
                System.out.println("잘못된 피연산자를 입력하였습니다. 다시 입력해주세요!");
                continue;
            }

            int result=0;
            switch (operator) {
                case "+":
                    result = num1+num2;
                    System.out.println("결과: " + num1 + " + " + num2 + " = " + result);
                    break;
                case "-":
                    result = num1-num2;
                    System.out.println("결과: " + num1 + " - " + num2 + " = " + result);
                    break;
                case "*":
                    result = num1*num2;
                    System.out.println("결과: " + num1 + " * " + num2 + " = " + result);
                    break;
                case "/":
                    try {
                        result = num1 / num2;
                        System.out.println("결과: " + num1 + " / " + num2 + " = " + result);
                        break;
                    }catch (ArithmeticException e){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. 다시 입력해주세요!");
                        break;
                    }
                default:
                    System.out.println("지원하지 않는 연산자입니다(" + operator +") 다시 입력해주세요!");
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitResponse = scanner.next();
            if(exitResponse.equals("exit")) break;
        }
    }
}