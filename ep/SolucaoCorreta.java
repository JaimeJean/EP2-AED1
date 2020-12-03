
package ep2;

public class SolucaoCorreta implements Gerador{
    protected int capacity;
    public static final int CAPACITY = 8;
    protected Integer[] pilha;
    protected int size;
    long cronometro;
    
        public SolucaoCorreta(){
        this.capacity = this.CAPACITY;
        this.pilha = new Integer[capacity];
        this.size = 0;
        this.cronometro = System.currentTimeMillis();
    }
      
    @Override
    public void add(int newElement){
    if(size == capacity){
        this.capacity *= 2;
        Integer[] tmp = new Integer[capacity];
        for(int j =0; j < size; j++)
            tmp[j] = this.pilha[j];
            this.pilha = tmp;
    }
    
    this.pilha[size] = newElement;
    this.size++;  
    
    }
    
    @Override
    public int remove(){      
        int tmp = pilha[size-1];
        
        this.size--;
             
        return tmp;
    }

    public int tamanho(){
    return this.size;
    }
    
    @Override
    public long getTempo() {
        return this.cronometro;
    }
}
