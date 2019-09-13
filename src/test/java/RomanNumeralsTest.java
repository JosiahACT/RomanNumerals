import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest
{

    /**
     * This will check if there are any symbols repeated more than 3 times.
     * Returns "" if no instances are found.
     *
     * @param in
     * @return
     */
    private String threeInARow( String in )
    {
        int out = 0; // Keeps check of the highest amount in a row of a character.
        int counter = 1; // No. of occurrences in a row of the current character.
        String chara = "";

        for ( int i = 0; i < in.length() - 1; i++ )
        {
            if ( in.substring( i + 1, i + 2 ).equals( in.substring( i, i + 1 ) ) )
            {
                if ( i < in.length() - 2 )
                {
                    counter++;
                }
                else // If we are near the end of the string then we will bypass assignment of counter to out.
                {
                    counter++;
                    if ( counter > out )
                    {
                        out = counter > out ? counter : out;
                        chara = in.substring( i, i + 1 );
                    }
                }
            }
            else if ( counter > out )
            {
                out = counter;
                counter = 1;
                chara = in.substring( i, i + 1 );
            }
            else
            {
                counter = 1;
            }
        }

        if ( out > 3 )
        {
            return "Answer: " + in + " contains more than 3 '" + chara + "'s. There are in fact " + Integer
                    .toString( out ) + " of them.";
        }
        else
        {
            return "";
        }
    }

    /**
     * Will check if there is more than one V,L or D in a row.
     * Returns "" if no instances are found.
     *
     * @param in
     * @return
     */
    private String lookForSequentialVLDs( String in )
    {
        String chara = "";
        for ( int i = 0; i < in.length() - 1; i++ )
        {
            if ( in.substring( i + 1, i + 2 ).equals( in.substring( i, i + 1 ) ) && (
                    in.substring( i + 1, i + 2 ).equals( "V" )
                            || in.substring( i + 1, i + 2 ).equals( "L" )
                            || in.substring( i + 1, i + 2 ).equals( "D" ) ) )
            {
                chara = in.substring( i, i + 1 );
                return "Answer: " + in + " contains more than 1 '" + chara + "' in a row.";
            }
        }
        return "";
    }

    /**
     * Runs through the rules of subtraction e.g. no I before M.
     *
     * @param in
     * @return
     */
    private String subtractionRules( String in )
    {

        for ( int i = 0; i < in.length() - 1; i++ )
        {

            String firstCharacter = in.substring( i, i + 1 );
            String secondCharacter = in.substring( i + 1, i + 2 );

            if ( firstCharacter.equals( "I" ) && ( secondCharacter.equals( "L" )
                    || secondCharacter.equals( "C" )
                    || secondCharacter.equals( "D" )
                    || secondCharacter.equals( "M" ) ) )
            {
                return "I cannot precede " + secondCharacter;
            }
            if ( firstCharacter.equals( "X" ) && ( secondCharacter.equals( "D" )
                    || secondCharacter.equals( "M" ) ) )
            {
                return "X cannot precede " + secondCharacter;
            }
            if ( firstCharacter.equals( "D" ) && secondCharacter.equals( "M" ) )
            {
                return "D cannot precede M";
            }
            if ( firstCharacter.equals( "L" ) && ( secondCharacter.equals( "C" )
                    || secondCharacter.equals( "D" )
                    || secondCharacter.equals( "M" ) ) )
            {
                return "L cannot precede " + secondCharacter;
            }
            if ( firstCharacter.equals( "V" ) && ( secondCharacter.equals( "X" )
                    || secondCharacter.equals( "L" )
                    || secondCharacter.equals( "C" )
                    || secondCharacter.equals( "D" )
                    || secondCharacter.equals( "M" ) ) )
            {
                return "V cannot precede " + secondCharacter;
            }
        }
        return "";
    }

    @Test
    public void baseNumbersShouldBecomeSymbols()
    {
        assertEquals( "I", RomanNumerals.getResult( 1 ) );
        assertEquals( "V", RomanNumerals.getResult( 5 ) );
        assertEquals( "X", RomanNumerals.getResult( 10 ) );
        assertEquals( "L", RomanNumerals.getResult( 50 ) );
        assertEquals( "C", RomanNumerals.getResult( 100 ) );
        assertEquals( "D", RomanNumerals.getResult( 500 ) );
        assertEquals( "M", RomanNumerals.getResult( 1000 ) );
    }

    @Test
    public void noMoreThan3OfASymbolInARow()
    {
//        assertEquals("",threeInARow(RomanNumerals.getResult(3814)));
//        assertEquals("",threeInARow(RomanNumerals.getResult(1247)));

        for ( int i = 1; i < 4000; i++ )
        {
            assertEquals( "", threeInARow( RomanNumerals.getResult( i ) ) );
        }
    }


    @Test
    public void noMoreThanOneVLDInARow()
    {
//        assertEquals("",lookForSequentialVLDs(RomanNumerals.getResult(3814)));
//        assertEquals("",lookForSequentialVLDs(RomanNumerals.getResult(1247)));
//        assertEquals("If there are no characters which match VLD, return nothing", "",lookForSequentialVLDs("VIV"));

        for ( int i = 1; i < 4000; i++ )
        {
            assertEquals( "", lookForSequentialVLDs( RomanNumerals.getResult( i ) ) );
        }
    }


    @Test
    public void shouldObeySubtractionRules()
    {
//        assertEquals("",subtractionRules(RomanNumerals.getResult(3814)));
//        assertEquals("",subtractionRules(RomanNumerals.getResult(1247)));
        //assertEquals("",subtractionRules("IM"));
        for ( int i = 1; i < 4000; i++ )
        {
            assertEquals( "", subtractionRules( RomanNumerals.getResult( i ) ) );
        }

    }

}