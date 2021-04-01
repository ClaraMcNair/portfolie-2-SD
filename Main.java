public class Main {

    public static void main(String[] args) {
        AdjacencyGraph MyGraph=new AdjacencyGraph();
        Vertex a = new Vertex("0");
        Vertex b = new Vertex("1");
        Vertex c = new Vertex( "2");
        Vertex d = new Vertex("3");
        Vertex e = new Vertex("4");
        Vertex f = new Vertex( "5");
        Vertex g = new Vertex("6");
        MyGraph.addVertex(a);
        MyGraph.addVertex(b);
        MyGraph.addVertex(c);
        MyGraph.addVertex(d);
        MyGraph.addVertex(e);
        MyGraph.addVertex(f);
        MyGraph.addVertex(g);
        MyGraph.addEdge(a,b,1);
        MyGraph.addEdge(a,c, 5);
        MyGraph.addEdge(a,e,3);
        MyGraph.addEdge(b,e,1);
        MyGraph.addEdge(b,f,7);
        MyGraph.addEdge(c,d,1);
        MyGraph.addEdge(d,e,1);
        MyGraph.addEdge(d,g, 1);
        MyGraph.addEdge(e,c, 1);
        MyGraph.addEdge(e,d,3);
        MyGraph.addEdge(e,f, 3);
        MyGraph.addEdge(e,g,4);
        MyGraph.addEdge(f,g, 1);
        MyGraph.PrintGraph();
    }
}
