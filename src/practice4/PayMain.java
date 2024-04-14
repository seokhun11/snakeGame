package practice4;

import java.util.Scanner;

public class PayMain {
    public static void main(String[] args){
        PayService payService = new PayService();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String option;
            int amount;
            System.out.print("결제 수단을 입력하세요: ");
            option = scanner.nextLine();
            if(option.equals("exit"))
            {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else
            {
                System.out.print("결제 금액을 입력하세요: ");
                amount = scanner.nextInt();

                payService.processPay(option, amount);
            }

        }
    }
}
