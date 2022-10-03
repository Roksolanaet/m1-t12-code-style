import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return round(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double round(double value, int places) {

        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void calculateDepositSumWithInterest() {
        int depositPeriodYears;
        int depositType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositSum = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriodYears = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double depositPercent = 0;
        if (depositType == 1) {
            depositPercent = calculateSimplePercent(depositSum, 0.06, depositPeriodYears);
        } else if (depositType == 2) {
            depositPercent = calculateComplexPercent(depositSum, 0.06, depositPeriodYears);
        }
        System.out.println("Результат вклада: " + depositSum + " за " + depositPeriodYears + " лет превратятся в " + depositPercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositSumWithInterest();
    }

}
