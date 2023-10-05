import java.util.*;
import java.io.*;

public class Graph {	
	
	int v;
	ArrayList<Integer> graph[];
	String[] bats;
	
	
	public Graph(int v)
	{
		this.v=v;
		graph = new ArrayList[v];
		for(int i=0;i<v;i++) graph[i] = new ArrayList<Integer>();
		
		bats = new String[v];
		try {
			Scanner sc = new Scanner(new File("Indian_test_Batsmans.txt"));
			int i=0;
			while(sc.hasNextLine()){
				if(i>=v) break;
				//System.out.println(i);
				bats[i] = sc.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	//	for(String s : this.bats) System.out.println(s);
		
	}
	
	public void addEdge(int s, int d){
		graph[s].add(d);
		graph[d].add(s);
	}
	
	public void addEdges() {
		try {
			Scanner sc = new Scanner(new File("Graph_Edges.txt"));
			while(sc.hasNext()){
				int a = sc.nextInt();
				int b = sc.nextInt();
				this.addEdge(a,b);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAdj(int s,int d){
		for(int i : this.graph[s]){
			if(i==d) return true;
		}
		return false;
	}
	
	public void print(){
		for(ArrayList<Integer> i : graph){
			for(int j : i) System.out.print(j+"=>");
				
				System.out.println();
		}
	}
	
	public double avgDegree(){
		int sum=0,max=0,in=-1,i=0;
		for(ArrayList<Integer> ar : this.graph){
			
			int tm = ar.size();
			//System.out.println(tm);
			sum += tm;
			if(tm>max) {
				max=tm;
				in=i;
			}
			i++;
		}
		System.out.println("avg Degree = "+(sum/((double)v)));
		System.out.println("Max Degree = "+ max+" of "+in+" - "+this.bats[in]);
		return (sum/((double)v));
	}
	
	public double clusteringCoefficiant(){
		double sum=0;
		for(int i=0;i<v;i++){
			double ci = this.culstCoeff(i);
			//System.out.println(ci);
			sum += ci;
		}
		System.out.println("Clustering Coefficiant = "+ (sum/v));
		return sum/v;
	}
	
	public double culstCoeff(int ver){
		int n = this.graph[ver].size();
		if(n<=1) return 0.0;
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(this.isAdj(this.graph[ver].get(i), this.graph[ver].get(j)))
					count++;
			}
		}
		return (double)count/((n*(n-1)/2));
	}
	
}
