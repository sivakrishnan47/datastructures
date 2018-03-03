package uniq;
import java.util.HashMap;

class CountIndex{
	int count, index;
	public CountIndex(int index)
	{
		this.count = 1;
		this.index = index;
	}
	public void incCount()
	{
		this.count++;
	}
}

public class uniq {
	static final int MAX = 256;
	static HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(MAX);
	
	static void getCharCountArray(String str)
	{
		for(int i =0; i <str.length(); i++)
		{
			if (hm.containsKey(str.charAt(i)))
			{
				hm.get(str.charAt(i)).incCount();
			}
			else {
				hm.put(str.charAt(i), new CountIndex(i));
			}
		}
	}
	
	static int firstNonRepeatingCharacter(String str)
	{
        if (str.length()==0)
        {
           return -1; 
        }
		getCharCountArray(str);
		int result = Integer.MAX_VALUE, i;
		for(i=0;i<str.length();i++)
		{
			if(hm.get(str.charAt(i)).count==1 && result > hm.get(str.charAt(i)).index)
			{
				result = hm.get(str.charAt(i)).index;
			}
		}
		
        if (result > str.length()-1){
            result = -1;
        }
		
		return result;
	}
	
	public static void main(String args[])
	{
		String str = "dacca";
		int index  = firstNonRepeatingCharacter(str);
		System.out.println("First non repeating character \t"+ index);
	}
}
