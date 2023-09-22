//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    static ArrayList<Integer> helper(int arr[],int s,int e,int x){
       ArrayList<Integer>ans=new ArrayList<>();
       while(s<=e){
        int mid=(s+e)/2;
        if(arr[mid]==x){
            int i=mid;
           
            while(i>=s&&arr[i]==x){
                i--;
            }
            ans.add(i+1);
            i=mid;
            while(i<=e&&arr[i]==x){
                i++;
            }
            ans.add(i-1);
            break;
        }else if(x>arr[mid]){
                s=mid+1;
        }else{
            e=mid-1;
        }
           
       }
       ans.add(-1);
       ans.add(-1);
       return ans;
    }
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        return helper(arr,0,arr.length-1,x);
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends