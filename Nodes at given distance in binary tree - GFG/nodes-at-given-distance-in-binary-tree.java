//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    
    static Node FindTarget(Node root,int target) {
		if(root==null||root.data==target) {
			return root;
		}
		Node left=FindTarget(root.left, target);
		Node right=FindTarget(root.right, target);
		
		if(left !=null)
			return left;
		
		return right;
	}

		static void markPrent(Node root,HashMap<Node,Node>hm) {
			Queue<Node> q=new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()) {
                    Node cur=q.poll();
                    
					if(cur.left!=null) {
						hm.put(cur.left,cur);
						q.add(cur.left);
					}
					if(cur.right!=null) {
						hm.put(cur.right, cur);
						q.add(cur.right);
					}
					
					
				
			}
			
		}
	static ArrayList<Integer> findAns(HashMap<Node,Node>hm,Node target,int k){
	    
		ArrayList<Integer> ans=new ArrayList<>();
		
		HashSet<Node>hs=new HashSet<>();
		Queue<Node>q=new LinkedList<>();
		
		q.add(target);
		hs.add(target);
		int c=0;
		while(!q.isEmpty()) {
		    
			if(c==k){
			    	break;
			}
			
		c++;
		int size=q.size();
		for(int i=0;i<size;i++) {
		    
			Node cur=q.poll();
			
			if(cur.left!=null && !hs.contains(cur.left)) {
				q.add(cur.left);
				hs.add(cur.left);
			}
			
			if(cur.right!=null && !hs.contains(cur.right)) {
				q.add(cur.right);
				hs.add(cur.right);
				
			}
			
			if(hm.get(cur)!=null && !hs.contains(hm.get(cur))) {
				q.add(hm.get(cur));
				hs.add(hm.get(cur));
			}

		}
		
		
		}
		
		while(!q.isEmpty()) {
			ans.add(q.poll().data);
		}
		Collections.sort(ans);
		return ans;
	}
	
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        Node t=FindTarget(root,target);
        HashMap<Node,Node>hm=new HashMap<>();
        markPrent(root,hm);
        return findAns(hm,t,k);
    }
};