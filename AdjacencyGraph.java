import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyGraph {
  ArrayList<Vertex> vertices;
  public AdjacencyGraph(){
      vertices=new ArrayList<Vertex>();
  }
  public void addVertex(Vertex v){
      vertices.add(v);
  }
  public void addEdge(Vertex f,Vertex t, Integer w){
      if(!(vertices.contains(f) && vertices.contains(t)) ) {
          System.out.println(" Vertex not in graph");
          return;
      }
      Edge e=new Edge(f, t,w);
      Edge e2= new Edge(t,f,w);
  }

  public void MSTPrims(){
      MinHeap<Vertex> Q = new MinHeap<>();

      if (vertices.size()>0){
          vertices.get(0).dist = 0;
      }
      for (int i = 0; i<vertices.size(); i++){
          Q.Insert(vertices.get(i));
      }
      int MST = 0;
      while (!Q.isEmpty()){
          Vertex u = Q.extractMin();
          System.out.println(u.name);

          for (int v = 0; v < u.OutEdges.size(); v++){
                  if (u.OutEdges.get(v).weight < u.OutEdges.get(v).to.dist){

                          u.OutEdges.get(v).to.dist = u.OutEdges.get(v).weight;
                          u.OutEdges.get(v).to.prev = u;
                          int pos = Q.getPosition(u.OutEdges.get(v).to);
                          Q.decreasekey(pos);
                  }
          }
          MST+= u.dist;
      }
      System.out.println("minimum spanning tree distance: " + MST);
      for (int i = 0; i< vertices.size(); i++){
          if (vertices.get(i).prev != null)
          System.out.println("Parent " + vertices.get(i).prev.name + " to " + vertices.get(i).name + " EdgeWeight: " + vertices.get(i).dist);
      }
      System.out.println("Price of grid: " + MST*100000 + " DKK");
  }

  public  void PrintGraph(){
      for (int i=0;i<vertices.size();i++)
      {
          System.out.println(" From Vertex: "+ vertices.get(i).name);
          Vertex currentfrom=vertices.get(i);
          for(int j=0; j<currentfrom.OutEdges.size();j++){
              Edge currentEdge=currentfrom.OutEdges.get(j);
              System.out.println(" To: "+ currentEdge.to.name + " weight: "+currentEdge.weight);
          }
          System.out.println(" ");
      }
  }
}

class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist= Integer.MAX_VALUE;
    Vertex prev = null;
    boolean visited = false;

    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    @Override // det er den der sorterer minheap
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }
}

class Edge{
    Integer weight;
    Vertex from;
    Vertex to;
    public Edge(Vertex from, Vertex to, Integer cost){
        this.from=from;
        this.to=to;
        this.weight=cost;
        this.from.addOutEdge(this);
    }
}
//kan slettes helt
class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;

    public Pair(Integer distance, Integer index){
        this.distance = distance;
        this.index = index;

    }

    @Override
    public int compareTo(Pair p){
        return this.distance.compareTo(p.distance);
    }
}