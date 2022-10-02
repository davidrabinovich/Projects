package assignment3370;
public class MyCustomString implements MyCustomStringInterface{
	private String string = null;
	@Override
public String getString() {
	return this.string;
}
@Override
public void setString (String string) {
	this.string=string;
}
@Override
public int countNumbers() {
	if (this.string ==null) {
		throw new NullPointerException("string is null");
	}
	int count = 0;
	int i = 0;
	while (i<this.string.length()) {
		char c = string.charAt(i);
		if(ifnumber(c)) {
			count++;
			while(i<this.string.length()) {
				if (i+1 == this.string.length()) {
					i++;
					break;
				}
				
				i++;
				char c2 = string.charAt(i);
				if(!ifnumber(c2)) {
					break;
				}
				
		}
			
		}
		else {
			i++;
		}
	}
	return count;
}
private Boolean ifnumber(char c) {
	return(c>=48 && c<= 57);	
}
@Override
public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
	String answer = new String();
	if (n<=0) {
		throw new IllegalArgumentException("n<=0");
	}
	if (this.string==null && n>0) {
		throw new NullPointerException("string null and n>0");
	}
	if (startFromEnd) {
		for (int i = this.string.length()-n;i >=0; i = i -n) {
			char c = string.charAt(i);
			answer = answer + c;
		}
	}
	else {
		for(int i = n-1 ;i<this.string.length();i=i+n) {
				char c = string.charAt(i);
				answer = answer + c;
		}
	}
	return answer;
}

@Override
public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws MyIndexOutOfBoundsException {
	if (startPosition>endPosition) {
		throw new IllegalArgumentException("start is bigger than end");		
	}
	else if(startPosition<1 ||startPosition>this.string.length()||endPosition<1 || endPosition>this.string.length()){
	throw new MyIndexOutOfBoundsException("out of bounds");
	}
	if (startPosition<=endPosition && startPosition>0&&endPosition>0&&this.string==null) {
		throw new NullPointerException("string is null");
	}
	String a1 = this.string.substring(0, startPosition-1);
	String a2 = this.string.substring(startPosition-1, endPosition);	
	String a3 = this.string.substring(endPosition, this.string.length());	

	for (int i = 0; i<a2.length();i++) {
		char c = a2.charAt(i);
		if(ifnumber(c)) {
			String temp = number(c);
			a2 = a2.substring(0, i)+temp+a2.substring(i+1);
		}
	}
	this.string=a1 + a2 + a3;
}
private String number(char c) {
	String newstring = null;
	if(c == 48)
		newstring = "Zero";
	else if (c==49)
		newstring = "One";
	else if (c==50)
		newstring = "Two";
	else if (c==51)
		newstring = "Three";
	else if (c==52)
		newstring = "Four";
	else if (c==53)
		newstring = "Five";
	else if (c==54)
		newstring = "Six";
	else if (c==55)
		newstring = "Seven";
	else if (c==56)
		newstring = "Eight";
	else if (c==57)
		newstring = "Nine";
	return newstring;
}
}
