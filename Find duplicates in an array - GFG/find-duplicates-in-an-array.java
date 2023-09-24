//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
	HashMap<Integer,Integer>hm=new HashMap<>();
	ArrayList<Integer>ans=new ArrayList<>();
	for(int i=0;i<arr.length;i++) {
		if(hm.get(arr[i])==null) {
			hm.put(arr[i],1);
		}else if(hm.get(arr[i])==1) {
			ans.add(arr[i]);
			hm.put(arr[i],hm.get(arr[i])+1);
		}else {
			hm.put(arr[i],hm.get(arr[i])+1);
		}
		
	}
	
	if(ans.size()==0) {
		ans.add(-1);
		return ans;
	}
	Collections.sort(ans);
	return ans;
    }
}
