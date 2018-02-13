public class Hello {
    public static void main(String[] args){
        System.out.println("Hello World!");
        int myFirstNumber = 5; // -2^32 to 2^32 - 1
        System.out.println(myFirstNumber);

        //Datatypes //*************************************************************************************************
        //use '_' to make a number more readable
        byte myByteNum = 127; // -2^8 to 2^8 - 1
        short myShortNum = -32768; // -2^16 to 2^16 - 1
        long myLongNum = 123; // -2^64 to 2^63

        byte newByte = (byte)(myByteNum/2); // by default java returns integer values as the result of an expression
                                            //Use type conversion
        System.out.println("New value = " + newByte);

        long finalTotal = 10000 + 10 * (myByteNum + myShortNum + myLongNum); // type casting is done by default for long and int variables
                                                                                 // type casting is needed for byte and short

        System.out.println("Final Total = " + finalTotal);
        float myFloatNum = 10.5f/ 5; // by default a decimal number is assumed to be of type double. Has 7 digits of precision after decimal
                                     // 32 bits long
        double myDoubleNum = 9.8d;   // has a precision of 16 digits
                                     // 64 bits long
        System.out.println("Final Total = " + finalTotal + myFloatNum);     // concatenation
        System.out.println("Final Total = " + (finalTotal + myFloatNum));   // the int value is typecasted into float value

        char char1 = 'd'; //use single quotes
        char char2 = 'a';
        char charArray[] = {'h','e'};

        boolean result = true;

        //Strings //****************************************************************************************************

        String myString = "Test string";
        System.out.println("Current String " + myString);
        myString += " Appended String";
        System.out.println(myString);

        String numString = "10";
        int tempInt = 20;
        System.out.println((numString) + tempInt);    //the integer value is typecasted into text


    }
}
