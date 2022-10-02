package assignment3370;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test(expected = NullPointerException.class)
    public void testCountNumbers2() {
    	mycustomstring.setString(null);//testing for null
    	assertEquals("string is null", mycustomstring.countNumbers() );
    }

    @Test
    public void testCountNumbers3() {
    	mycustomstring.setString("");//testing an empty string
    	assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
    	mycustomstring.setString("1223424353534332323");//testing a string of just numbers
    	assertEquals(1, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
    	mycustomstring.setString("122324 2435353 4332323");//testing just numbers with spaces
    	assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
    	mycustomstring.setString("Not yet implemented");//string with no digits
    	assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test(expected =IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	assertEquals("n<=0", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-2, true));//testing - and true
    }

    @Test(expected =IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
    	assertEquals("n<=0", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-2, false));//testing - and false
    }

    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	mycustomstring.setString(null);
    	assertEquals("string null and n>0", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));//testing null and false
    }

    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString(null);
    	assertEquals("string null and n>0", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));//testing null and true
       }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString("d");
    	assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));//testing n>string and true
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("d");
    	assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));//testing n>string and false
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("do jot you is");
    	assertEquals("ojtyui", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));//testing normal good case and false
      }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("do jot you is");
    	assertEquals("iuytjo", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));//testing normal good case and true
    }
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("123456");
    	assertEquals("36", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));//testing just numbers and false
       }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
    	mycustomstring.setString("123456");
    	assertEquals("41", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));//testing just numbers and true 
    	}

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
    	mycustomstring.setString("123456");
    	assertEquals("1", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, true));//testing n = length and true 
        }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("123456");
    	assertEquals("6", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));//testing n = length and false 
    	}

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(24, 23);
        assertEquals("start is bigger than end", mycustomstring.getString());//testing illegal argument exception
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(2, 23);
        assertEquals("string is null", mycustomstring.getString());//testing null pointer exception
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(0, 23);
        assertEquals("out of bounds", mycustomstring.getString());//testing out of bounds start<1
       }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(2, 55);
        assertEquals("out of bounds", mycustomstring.getString());//testing out of bounds end>length  
        }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(1, 2);
        assertEquals("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?", mycustomstring.getString());//testing no changes to string  
           }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
    	mycustomstring.setString("123");
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("OneTwoThree", mycustomstring.getString());//testing just numbers
    }
    
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
    	mycustomstring.setString("123test123");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("One23test123", mycustomstring.getString());//testing just one index checked
    }

}
