public class ControlFlow {
    public static void main(String[] args){
        int switchValue = 1;

        // switch statement can be used with int, char, Strings
        switch(switchValue){
            case 1:
                System.out.println("Print 1");
                break;
            case 2:
                System.out.println("Print 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Print " + switchValue );
                break;
            default:
                System.out.println("Print Node");
                break;
        }

        String month = "Jan";
        switch(month.toLowerCase()){    //month.toUpperCase()
            case "jan":
                System.out.println("January");
                break;
            case "feb":
                System.out.println("February");
                break;
            case "mar": case "apr": case "may":
                System.out.println("March or April or May");
                break;
            default:
                System.out.println("Other months");
                break;
        }
        for(int i = 1; i <= 5; ++i) {
            double totalInterest = calcInterest(10000, 2, i);
            System.out.println("Total amount to be repayed after " + i + " years is " + String.format("%.2f",totalInterest));
        }
        for(int i = 2; i < 100; ++i){
            if(isPrime(i) && isPrimeDoWhile(i))
                System.out.println(i + " is " + isPrime(i));
        }
    }

    public static double calcInterest(double amount, double interestRate, int numOfYears){
        int i = 0;
        for(int j = 0; j < numOfYears; ++j){
            amount += (amount * interestRate/100);
        }
        return amount;
    }

    public static boolean isPrime(int n){
        int i = 2;
        if(n <= 3) return true;
        while(i <= Math.sqrt(n)){
            if(n % i == 0)
                return false;
            i++;
        }
        return true;
    }

    public static boolean isPrimeDoWhile(int n){
        int i = 1;
        if(n <= 3) return true;
        do{
            i++;
            if(n % i == 0) return false;
        }
        while(i <= Math.sqrt(n));
        return true;
    }
}
