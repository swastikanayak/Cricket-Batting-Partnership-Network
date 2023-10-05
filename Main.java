import java.util.*;
import java.io.*;

public class Main {
	
	public static String all_batsman_file = "Indian_test_Batsmans.txt";
	public static String all_partnerships_file = "Indian_test_Batting_Partnerships";
	public static String output = "Graph_Edges.txt"; 
	public static String adjecency_matrix = "adjecency_Matrix.txt";
	
	public static  void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(new File(all_batsman_file));
		
		HashMap<String,Integer> bat_map = new HashMap<String,Integer>();
		
		int i=0;
		while(sc.hasNextLine())
		{
			bat_map.put(sc.nextLine(), i++);
		}
		
		//for(String s : bat_map.keySet()) System.out.println(bat_map.get(s)+" "+s);
		//System.out.println(bat_map.keySet().size());
		
		sc = new Scanner(new File(all_partnerships_file));
		PrintWriter pw = new PrintWriter(new File(output));
		
		int nodes = bat_map.size()+1;
		int arr[][] = new int[nodes][nodes];
		for(int j=0;j<nodes;j++){
			for(int k=0;k<nodes;k++){
				arr[j][k]=0;
			}
		}
		int count=0;
		while(sc.hasNextLine())
		{
			String s = sc.nextLine();
			String[] sarr = s.split(",");
			//System.out.println(sarr[0]+" "+sarr[1]);
			sarr[1] = sarr[1].substring(1);
			
			int a = bat_map.get(sarr[0]);
			int b = bat_map.get(sarr[1]);
			
			arr[a][b]=1;
			arr[b][a]=1;
			pw.println(a+"	"+b);
			count++;
		}
		
		pw.close();
		sc.close();
		System.out.println("Done...Total Edges = "+count);
		
		System.out.println();
		
		pw = new PrintWriter(new File(adjecency_matrix));
		
		count=0;
		for(int j=0;j<nodes;j++){
			for(int k=0;k<nodes;k++){
				if(arr[j][k]==1) count++;
				pw.print(arr[j][k]+"	");
			}
			pw.println();
		}
		
		pw.close();
		//System.out.println(count);
	}
}
