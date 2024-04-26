import models.CurrencyConversion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentCurrency = "", newCurrency = "", sign = "";
        float currentMoney;
        CurrencyConversion request = new CurrencyConversion();
        int option = 0;
        while (true) {

                System.out.println("\n**************************************");
                System.out.println("         CONVERSÃO DE MOEDAS  ");
                System.out.println("**************************************");
                System.out.println("\nSelecione a opção digitando o número");
                System.out.println("         1 - BRL para USD");
                System.out.println("         2 - USD para ARS");
                System.out.println("         3 - ARS para EGP");
                System.out.println("         4 - EGP para JMD");
                System.out.println("         5 - JMD para NGN");
                System.out.println("         6 - NGN para BRL");
                System.out.println("         7 - Sair");
                System.out.println("\n**************************************");
                try {
                    option = sc.nextInt();
                } catch (InputMismatchException e) {
                    sc.next();
                }
                if (option == 7) {
                    break;
                }
                switch (option) {
                    case 1:
                        currentCurrency = "BRL";
                        newCurrency = "USD";
                        sign = "US$";
                        break;
                    case 2:
                        currentCurrency = "USD";
                        newCurrency = "ARS";
                        sign = "$";
                        break;
                    case 3:
                        currentCurrency = "ARS";
                        newCurrency = "EGP";
                        sign = "£";
                        break;
                    case 4:
                        currentCurrency = "EGP";
                        newCurrency = "JMD";
                        sign = "$";
                        break;
                    case 5:
                        currentCurrency = "JMD";
                        newCurrency = "NGN";
                        sign = "₦";
                        break;
                    case 6:
                        currentCurrency = "NGN";
                        newCurrency = "BRL";
                        sign = "R$";

                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                if (option > 0 && option < 7) {
                    System.out.println("Informe o valor para conversão: ");
                    currentMoney = sc.nextFloat();
                    System.out.printf("A conversão de %.2f %s para %s é de: %.2f %s", currentMoney, currentCurrency, newCurrency,
                            request.getConvertedValue(currentCurrency, newCurrency, currentMoney), sign);
                }
        }
        sc.close();
    }
}
