//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    
    public void newFun(Stack<Integer> s, int ele){
        if(s.isEmpty() || s.peek()<=ele){
            s.push(ele);
            return;
        }
        int e = s.pop();
        newFun(s,ele);
        s.push(e);
    }
    
    public void helper(Stack<Integer> s){
        if(!s.isEmpty()){
            int ele = s.pop();
            helper(s);
            newFun(s, ele);
        }
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		helper(s);
		return s;
	}
}