
package ep2;

public class PilhaSaida extends EP2{
    int []saida = new int [999999];
    int topoDaPilha = 0;
    
   
    void push(int chave){
       this.saida[topoDaPilha()] = chave;
       this.topoDaPilha++;
    }
    
    int topoDaPilha(){
    return this.topoDaPilha;
    }
    
    void imprimePilha(){
    for(int i=0;i<topoDaPilha();i++){
        System.out.println(saida[i]);
    }
    }
}
