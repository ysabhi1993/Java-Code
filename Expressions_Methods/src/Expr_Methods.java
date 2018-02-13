public class Expr_Methods {
    public static void main(String[] args){
        int score = 100;
        boolean result = true;
        int level = 10;
        if(result && calculateScore(level, score))
            System.out.println("You Win!");
        else
            System.out.println("You Lose!");

        if(result && calculateScore(level, score, "Hello"))
            System.out.println("printing result");
        else
            System.out.println("printing result");
    }

    //method calculateScore
    public static boolean calculateScore(int level, int score){
        int bonus = 10 * level;
        int totalScore = (score*level) + bonus;
        if(totalScore > 1000){
            return true;
        }
        else {
            return false;
        }
    }

    // Method overloading:
    // same method name but different set of parameters
    public static boolean calculateScore(int level, int score, String playerName){
        int bonus = 10 * level;
        int totalScore = (score*level) + bonus;
        if(totalScore > 1000){
            System.out.println(playerName + "has won!");
            return true;
        }
        else {
            System.out.println(playerName + " lost!");
            return false;
        }
    }

}
