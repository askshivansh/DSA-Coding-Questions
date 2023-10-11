//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    List<Integer> tmp = new ArrayList<>();
    public long dfs(int node, int p, int[] vis, int[] par, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = 1;
        par[node] = p;
        tmp.add(node);
        
        ArrayList<Integer> sub = adj.get(node);
        
        for(int i: adj.get(node)){
            if(vis[i] == 0){
                long z = dfs(i, node, vis, par, adj);
                if(z!=-1) return z;
            }
            
            else if(vis[i] == 1){
                long sum = i;
                while(i!=node){
                    sum += node;
                    node = par[node];
                }
                if(node==i) return sum;
                else return -1;
            }
        }
        return -1;
        
    }
    public long largesSumCycle(int N, int Edge[]){
        
        int[] vis = new int[N];
        int[] par = new int[N];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<Edge.length; i++){
            adj.add(new ArrayList<>());
            if(Edge[i] != -1){
                adj.get(i).add(Edge[i]);
            }
        }
        

        long ans = -1;
        for(int i = 0; i<N; i++){
            if(vis[i] == 0){
                ans = Math.max(ans, dfs(i, -1, vis, par, adj));
                for(int j: tmp) vis[j] = 2;
                tmp.clear();
            }
        }
        
        return ans;
        
    }
}