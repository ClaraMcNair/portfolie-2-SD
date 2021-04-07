import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;

//Grafen er en liste af vertices
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
    //grafen er undirected, så alle edges går begge veje
      Edge e=new Edge(f, t,w);
      Edge e2= new Edge(t,f,w);
  }

  //Implementering af Prims
  public void MSTPrims(){
      MinHeap<Vertex> Q = new MinHeap<>(); //Opretter minheap til vertices

      if (vertices.size()>0){
          vertices.get(0).dist = 0; //Vores implementering af Prims tager udgangspunkt i vertex på index 0.
      }
      for (int i = 0; i<vertices.size(); i++){ //Sætter alle vertices ind i minheap
          Q.Insert(vertices.get(i));
      }
      int MST = 0;
      while (!Q.isEmpty()){ //Følgende kode kører så længe der er vertices i vores minheap.
          Vertex u = Q.extractMin(); //udtræk øverste/mindste element i vores minheap
          for (int v = 0; v < u.OutEdges.size(); v++){ //loop der løber alle vertices u og deres outedges igennem
                  if (u.OutEdges.get(v).weight < u.OutEdges.get(v).to.dist){ //er weight mellem u og v mindre end dist mellem u og v?
                          u.OutEdges.get(v).to.dist = u.OutEdges.get(v).weight; //dist mellem u og v sættes til weight mellem u og v 
                          u.OutEdges.get(v).to.prev = u; //v's prev sættes til u
                          int pos = Q.getPosition(u.OutEdges.get(v).to);  //v fjernes fra Q
                          Q.decreasekey(pos);
                  }
          }
          MST+= u.dist; //opdater størrelsen på MST ved løbende at tilføje dist mellem u.
      }
      System.out.println("minimum spanning tree distance: " + MST);
      for (int i = 0; i< vertices.size(); i++){ //løb alle vertices igennem.
          if (vertices.get(i).prev != null) //print info for alle vertices der har en prev
          System.out.println("Parent " + vertices.get(i).prev.name + " to " + vertices.get(i).name + " EdgeWeight: " + vertices.get(i).dist);
      }
      System.out.println("Price of grid: " + MST*100000 + " DKK");
  }

  public  void PrintGraph(){ //metode til print af alle edges i grafen
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

class Vertex implements Comparable<Vertex>{ //vertex-objekt
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist= Integer.MAX_VALUE; //dist sættes som udgangspunkt til uendelig iflg. Prims
    Vertex prev = null; //forrige vertex sættes som udgangspunkt til null iflg. Prims
    

    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    @Override // Sorterer minheap på baggrund af distancen.
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }
}

class Edge{ //Edge-objekt, der består af to vertices og vægten mellem disse.
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

