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
  }

  public void MSTPrims(){
      int[] Distance =  new int[vertices.size()];
      int[] Predecessor = new int[vertices.size()];
      boolean[] visited = new boolean[vertices.size()];
      MinHeap<Pair> Q = new MinHeap<>();

      ArrayList<Pair> vertexPairs = new ArrayList<>();
      Arrays.fill(Distance, Integer.MAX_VALUE);
      Arrays.fill(Predecessor, -1);
      Arrays.fill(visited, false);
      if (vertices.size()>0){
          Distance[0] = 0;
      }
      for (int i = 0; i<vertices.size(); i++){
          vertexPairs.add(new Pair(Distance[i],i));
          Q.Insert(vertexPairs.get(i));
      }
      int MST = 0;
      while (!Q.isEmpty()){
          Pair u = Q.extractMin();
          Vertex currentfrom = vertices.get(u.index);
          //for (int v = 0; v<vertices.size(); v++){
          for (int v = 0; v < currentfrom.OutEdges.size(); v++){
              //Vertex currentfrom = vertices.get(u.index);
                  if (currentfrom.OutEdges.get(v).weight < Distance[v]){

                      if (!visited[v]) {
                          Distance[v] = currentfrom.OutEdges.get(v).weight;
                          Predecessor[v] = u.index;
                          int pos = Q.getPosition(vertexPairs.get(v));
                          vertexPairs.get(v).distance = currentfrom.OutEdges.get(v).weight;
                          Q.decreasekey(pos);
                      }
                  }
          }
          MST+=Distance[u.index];
      }
      System.out.println("minimum spanning tree distance: " + MST);
      for (int i = 0; i< vertices.size(); i++){
          System.out.println("Parent " + Predecessor[i] + " to " + i + " EdgeWeight: " + Distance[i]);
      }

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
    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    @Override
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