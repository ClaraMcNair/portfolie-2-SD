import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap<T extends Comparable<T> >{
    HashMap<T,Integer> positionTable=new HashMap<>();

    // Opret minheap som generic arraylist. Rodens position sættes til index 0.
    ArrayList<T> minheap;
    private int size;
    public MinHeap(){
        this.minheap=new ArrayList<T>();
        this.size=0; 
    }
    public int getPosition(T item){return positionTable.get(item);}
    public boolean isEmpty(){return size <= 0;}
    private int Parent(int pos){return (pos-1)/2;}//Fordi roden er på index 0, udregnes parent ved (index-1)/2

    private int leftChild(int pos){return pos*2 +1;} // udregnes på denne måde fordi roden er på index 0

    private int rightChild(int pos){return pos*2 +2;}// udregnes på denne måde fordi roden er på index 0

    private void swap(int pos1, int pos2){ //metode til at bytte elementer
        T dummy= minheap.get(pos1); //midlertidig liste, hvor elementet på pos1 opbevares

        minheap.set(pos1, minheap.get(pos2)); //overwriter pos1 med element på pos2
        minheap.set(pos2,dummy); // overwriter pos2 med element i dummy/ forrige pos1
        positionTable.put(minheap.get(pos1),pos1); //opdaterer hashmap
        positionTable.put(minheap.get(pos2),pos2);
    }
    
    //metode til at insætte generic element T
    public void Insert(T item){
        minheap.add(item);
        positionTable.put(item,size);
        size++; //size øges når vi tilføjer et nyt element
        decreasekey(size-1); // undersøg om nederste element i listen(det vi har tilføjet) skal rykkes op. 
    }
    public void decreasekey(int pos){ //metode til at rykke element op i heapen
        int currentpos=pos;
        while (minheap.get(currentpos).compareTo(minheap.get(Parent(currentpos)))<0){ //er det element vi ser på mindre end dens parent?
            swap(currentpos,Parent(currentpos)); //bytter dem
            currentpos=Parent(currentpos); //parents position er den nye currentpos, så vi kan tjekke parent til parent
        }
    }

    public T viewMin(){ //metode til at se mindste element, som altid vil befinde sig på index 0
        return minheap.get(0);
    }
    private boolean movedown(int pos){
        boolean leftsmaller = leftChild(pos)<size
                && (minheap.get(leftChild(pos)).compareTo(minheap.get(pos))<0);
        boolean rightsmaller = rightChild(pos)<size
                && (minheap.get(rightChild(pos)).compareTo(minheap.get(pos))<0);
        return leftsmaller || rightsmaller;
    }
    public void increasekey(int pos){ 
        int currentpos=pos;
        while (movedown(currentpos))
        {
            int rpos= rightChild(currentpos);
            int lpos= leftChild(currentpos);
            if (rpos< size && minheap.get(rpos).compareTo(minheap.get(lpos))<0){
                swap(rpos,currentpos);
                currentpos=rpos;
            }
            else{
                swap(lpos,currentpos);
                currentpos=lpos;
            }
        }
    }
    public T extractMin(){ //metode til at fjerne det mindste element fra listen
        T min = minheap.get(0); //træk element på index 0 ud.
        minheap.set(0, minheap.get(size-1)); //sæt listens sidste element ind på index 0. 
        positionTable.put(minheap.get(0),0); //opdater hashmap
        size--; //listens størrelse skal mindskes
        increasekey(0);
        return min;
    }
}
