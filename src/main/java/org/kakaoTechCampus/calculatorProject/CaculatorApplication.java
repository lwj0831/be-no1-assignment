package org.kakaoTechCampus.calculatorProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaculatorApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(true) {
            int num1;
            int num2;
            String operator;

            //Input num1, num2, operator
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = scanner.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.next();
            }catch(InputMismatchException e){
                System.out.println("InputMismatchException occurs!");
                break;
            }

            //Calculate
            int result = calculator.calculate(num1, num2, operator);
            System.out.println("결과: " + num1 + operator + num2 + " = " + result);

            //Delete Result
            calculator.removeResult();

            //Print Previous Results
            calculator.printOperationResults();

            //Check Exit
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitResponse = scanner.next();
            if(exitResponse.equals("exit")) break;
        }
    }
}
