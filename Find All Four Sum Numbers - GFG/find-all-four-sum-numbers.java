//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        HashSet<ArrayList<Integer>>set=new HashSet<>();
    	ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
    	Arrays.sort(arr);
    	for(int i=0;i<arr.length-3;i++) {
    		for(int j=i+1;j<arr.length-2;j++) {
    			for(int l=j+1;l<arr.length-1;l++) {
    				for(int m=l+1;m<arr.length;m++) {
    					int sum=arr[i]+arr[j]+arr[l]+arr[m];
    					if(sum==k) {
    						ArrayList<Integer>temp=new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[l],arr[m]));
    					if(!set.contains(temp)) {
    								ans.add(temp);
    								set.add(temp);
    						
    						}
    					}
    				}
    			}
    		}
    	}
    	return ans;
    }
}