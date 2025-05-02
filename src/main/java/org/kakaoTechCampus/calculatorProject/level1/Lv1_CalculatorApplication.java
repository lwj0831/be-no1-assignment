package org.kakaoTechCampus.calculatorProject.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv1_CalculatorApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            int num1;
            int num2;
            String operator;

            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = scanner.nextInt(); //개행 문자(\n)전까지 읽음
                scanner.nextLine(); //개행 문자까지 읽어 Scanner 버퍼 비우기
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = scanner.nextInt();
                scanner.nextLine();
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.next();
            }catch(InputMismatchException e){
                System.out.println("잘못된 피연산자를 입력하였습니다. 다시 입력해주세요!");
                scanner.nextLine(); //Scanner 버퍼 비우기
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
                        continue;
                    }
                default:
                    System.out.println("지원하지 않는 연산자입니다(" + operator +") 다시 입력해주세요!");
                    continue;
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exitResponse = scanner.next();
            if(exitResponse.equals("exit")) break;
        }
    }
}