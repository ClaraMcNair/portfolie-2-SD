// hej
// hej igen
<<<<<<< HEAD
// gecjhf
=======

public class Main {

    public static void main(String[] args) {
        AdjacencyGraph MyGraph=new AdjacencyGraph();
        Vertex eskildstrup = new Vertex("Eskildstrup");
        Vertex haslev = new Vertex("Haslev");
        Vertex holbæk = new Vertex( "Holbæk");
        Vertex jægerspris = new Vertex("Jægerspris");
        Vertex kalundborg = new Vertex("Kalundborg");
        Vertex korsør = new Vertex( "Korsør");
        Vertex køge = new Vertex("Køge");
        Vertex maribo = new Vertex("Maribo");
        Vertex nakskov = new Vertex("Nakskov");
        Vertex nykøbingF = new Vertex("Nykøbing F");
        Vertex næstved = new Vertex("Næstved");
        Vertex ringsted = new Vertex("Ringsted");
        Vertex roskilde = new Vertex("Roskilde");
        Vertex slagelse = new Vertex("Slagelse");
        Vertex sorø = new Vertex("Sorø");
        Vertex vordingborg = new Vertex("Vordingborg");
        MyGraph.addVertex(eskildstrup);
        MyGraph.addVertex(haslev);
        MyGraph.addVertex(holbæk);
        MyGraph.addVertex(jægerspris);
        MyGraph.addVertex(kalundborg);
        MyGraph.addVertex(korsør);
        MyGraph.addVertex(køge);
        MyGraph.addVertex(maribo);
        MyGraph.addVertex(nakskov);
        MyGraph.addVertex(nykøbingF);
        MyGraph.addVertex(næstved);
        MyGraph.addVertex(ringsted);
        MyGraph.addVertex(roskilde);
        MyGraph.addVertex(slagelse);
        MyGraph.addVertex(sorø);
        MyGraph.addVertex(vordingborg);

        MyGraph.addEdge(eskildstrup,maribo,28);
        MyGraph.addEdge(eskildstrup,nykøbingF, 13);
        MyGraph.addEdge(eskildstrup,vordingborg,24);
        MyGraph.addEdge(haslev,korsør,60);
        MyGraph.addEdge(haslev,køge,24);
        MyGraph.addEdge(haslev,næstved,25);
        MyGraph.addEdge(haslev,ringsted,19);
        MyGraph.addEdge(haslev,roskilde, 47);
        MyGraph.addEdge(haslev,slagelse, 48);
        MyGraph.addEdge(haslev,sorø,34);
        MyGraph.addEdge(haslev,vordingborg, 40);
        MyGraph.addEdge(holbæk,jægerspris,34);
        MyGraph.addEdge(holbæk,kalundborg, 44);
        MyGraph.addEdge(holbæk,korsør, 66);
        MyGraph.addEdge(holbæk,ringsted, 36);
        MyGraph.addEdge(holbæk,roskilde, 32);
        MyGraph.addEdge(holbæk,slagelse, 46);
        MyGraph.addEdge(holbæk,sorø, 34);
        MyGraph.addEdge(jægerspris,korsør, 95);
        MyGraph.addEdge(jægerspris,køge, 58);
        MyGraph.addEdge(jægerspris,ringsted, 56);
        MyGraph.addEdge(jægerspris,roskilde, 33);
        MyGraph.addEdge(jægerspris,slagelse, 74);
        MyGraph.addEdge(jægerspris,sorø, 63);
        MyGraph.addEdge(kalundborg,ringsted, 62);
        MyGraph.addEdge(kalundborg,roskilde, 70);
        MyGraph.addEdge(kalundborg,slagelse, 39);
        MyGraph.addEdge(kalundborg,sorø, 51);
        MyGraph.addEdge(korsør,næstved, 45);
        MyGraph.addEdge(korsør,slagelse, 20);
        MyGraph.addEdge(køge,næstved, 45);
        MyGraph.addEdge(køge,ringsted, 28);
        MyGraph.addEdge(køge,roskilde, 25);
        MyGraph.addEdge(køge,vordingborg, 60);
        MyGraph.addEdge(maribo,nakskov, 27);
        MyGraph.addEdge(maribo,nykøbingF, 26);
        MyGraph.addEdge(næstved,roskilde, 57);
        MyGraph.addEdge(næstved,ringsted, 26);
        MyGraph.addEdge(næstved,slagelse, 37);
        MyGraph.addEdge(næstved,sorø, 32);
        MyGraph.addEdge(næstved,vordingborg, 28);
        MyGraph.addEdge(ringsted,roskilde, 31);
        MyGraph.addEdge(ringsted,sorø, 15);
        MyGraph.addEdge(ringsted,vordingborg, 58);
        MyGraph.addEdge(slagelse,sorø, 14);



        MyGraph.PrintGraph();
    }
}

