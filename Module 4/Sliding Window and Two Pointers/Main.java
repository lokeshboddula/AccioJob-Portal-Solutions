import java.io.*;
import java.util.*;

class Solution {
	public boolean isAnswer (int[] tfreq, int[] currWin) {
		for(int i = 0; i < tfreq.length; i++) {
			if(tfreq[i] > currWin[i]) return false;
		}
		return true;
	}
    public String minWindow(String s, String t) {
		int[] currWinFreq = new int[130];
		int[] tfreq = new int[130];
		int ansS = -1; 
		int ansE = -1;
		int ansSize = Integer.MAX_VALUE;
		int st = 0;
		int e = 0;
		for(int i = 0; i < t.length(); i++) tfreq[t.charAt(i)]++;
		while (e < s.length()) {
			currWinFreq[s.charAt(e)]++;

			while(isAnswer(tfreq, currWinFreq)) {
				
				if(ansSize > e - st + 1) {
					ansS = st;
					ansE = e;
					ansSize = e - st + 1;
				}
				
				currWinFreq[s.charAt(st)]--;
				st++;
			}
			e++;
		}
		if (ansS == -1) return "";
		return s.substring(ansS, ansE + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}