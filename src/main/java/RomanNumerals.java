public class RomanNumerals {

    public static String getResult( int number )
    {
        StringBuilder out = new StringBuilder(20);

        while( number > 999 )
        {
            out.append("M");
            number -= 1000;
        }

        if( number > 899 )
        {
            out.append("CM");
            number -= 900;
        }

        if( number > 499 )
        {
            out.append("D");
            number -= 500;
        }

        if( number > 399 )
        {
            out.append("CD");
            number -= 400;
        }

        while( number > 99 )
        {
            out.append("C");
            number -= 100;
        }

        if( number > 89 )
        {
            out.append("XC");
            number -= 90;
        }

        if( number > 49 )
        {
            out.append("L");
            number -= 50;
        }

        if( number > 39 )
        {
            out.append("XL");
            number -= 40;
        }

        while( number > 9 )
        {
            out.append("X");
            number -= 10;
        }

        if( number > 8)
        {
            out.append("IX");
            number -= 9;
        }

        if( number > 4)
        {
            out.append("V");
            number -= 5;
        }

        if( number > 3)
        {
            out.append("IV");
            number -= 4;
        }

        while( number > 0)
        {
            out.append("I");
            number -= 1;
        }


        return out.toString();
    }

}
