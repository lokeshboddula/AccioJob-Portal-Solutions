import java.io.*;
import java.util.*;

class Solution{
    static String complement(String bi){
        //flip all the bits after the rsb 
		// 2's comp
		StringBuilder sb = new StringBuilder();
		int i = bi.length() - 1;
		if (bi.charAt(i) == '1') {
			sb.append('1');
			i--;
		} else {
			while(bi.charAt(i) != '1') {
				sb.insert(0, bi.charAt(i));
				i--;
			}
			sb.insert(0, '1');
			i--;
		}
		
		
		for(; i >=0 ; i--) {
			if(bi.charAt(i) == '1') {
				sb.insert(0, '0');
			}else {
				sb.insert(0, '1');
			}
		}
		return sb.toString();
     }
}
public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String bi = in.readLine();
        Solution ob = new Solution();
        System.out.println(ob.complement(bi));
    }
}