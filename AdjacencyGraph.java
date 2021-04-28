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

  //Følgende kode er implementering af Prims

  //Opretter minheap til vertices
  public void MSTPrims(){
      MinHeap<Vertex> Q = new MinHeap<>();

      //Vores implementering af Prims tager udgangspunkt i vertex på index 0.
      if (vertices.size()>0){
          vertices.get(0).dist = 0;
      }

      //Sætter alle vertices ind i minheap
      for (int i = 0; i<vertices.size(); i++){
          Q.Insert(vertices.get(i));
      }

      //Følgende kode kører så længe der er vertices i vores minheap.
      // Vi udtrækker øverste/mindste element i minheap, og løber alle vertices u og tilhørende outedges igennem.
      //Hvis weight mellem u og v er mindre end dist mellem u og v,
      // skal dist opdateres og v skal fjernes fra q.
      int MST = 0;
      while (!Q.isEmpty()){
          Vertex u = Q.extractMin();
          for (int v = 0; v < u.OutEdges.size(); v++){
                  if (u.OutEdges.get(v).weight < u.OutEdges.get(v).to.dist){
                          u.OutEdges.get(v).to.dist = u.OutEdges.get(v).weight;
                          u.OutEdges.get(v).to.prev = u;
                          int pos = Q.getPosition(u.OutEdges.get(v).to);
                          Q.decreasekey(pos);
                  }
          }
          //opdater størrelsen på MST ved løbende at tilføje dist mellem u.
          MST+= u.dist;
      }

      //print info for alle vertices der har en prev
      System.out.println("minimum spanning tree distance: " + MST);
      for (int i = 0; i< vertices.size(); i++){
          if (vertices.get(i).prev != null)
          System.out.println("Parent " + vertices.get(i).prev.name + " to " + vertices.get(i).name + " EdgeWeight: " + vertices.get(i).dist);
      }
      System.out.println("Price of grid: " + MST*100000 + " DKK");
  }

    //metode til print af alle edges i grafen
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

//Vores vertex-objekt
//dist sættes som udgangspunkt til uendelig iflg. Prims
//forrige vertex sættes som udgangspunkt til null iflg. Prims
class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist= Integer.MAX_VALUE;
    Vertex prev = null;
    

    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    // Sorterer minheap på baggrund af distancen.
    @Override
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }
}

//Edge-objekt, der består af to vertices og vægten mellem disse.
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

