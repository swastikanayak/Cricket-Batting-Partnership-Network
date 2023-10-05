
public class Make_Graph {

	public static void main(String[] args){
		Graph g = new Graph(292);
		g.addEdges();
		//g.print();
		g.avgDegree();
		//System.out.println(g.isAdj(10, 12));
		
		g.clusteringCoefficiant();
	}
}
