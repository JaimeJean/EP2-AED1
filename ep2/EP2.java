
package ep2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class EP2 {
   
    public static void main(String[] args) throws IOException{
        System.out.printf("Digite o intervalo dos arquivos que serão processados. Por exemplo: 3000 54000 (o programa processará as tarefas de tarefas30000 até tarefas54000)." + " Em seguida aperte enter!\n");
       Scanner in = new Scanner(System.in);

       int x = in.nextInt();
       int y = in.nextInt();
       
        
        Gerador tipoEscolhido = null;

        
        
        String metodoEscolhido = escolha();
        tipoEscolhido = criacaoObjeto(metodoEscolhido);

            while (x<=y){
            List<String> linhas = null;
            linhas = criacaoLista();   
           
                    String nomeDoArquivo = arquivoNome(x);
                   
                    try{
                        FileReader arquivo = new FileReader(nomeDoArquivo);
                        BufferedReader leArquivo = new BufferedReader(arquivo);
                        
                        String entrada = leArquivo.readLine();
                        
                        
                        

                        while (entrada != null){
                        
                            linhas.add(entrada);
                        
                            entrada = leArquivo.readLine();
                        }
                        
                        arquivo.close();
                        
                        processamento(linhas, tipoEscolhido, nomeDoArquivo);
                       
                    }
                    
                                        
                    catch (IOException e){
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage());
            }
                    
            x += 1000;
        }
       
    }
    
        static String arquivoNome(int x){
            String numeroDaTarefa = String.valueOf(x);
            return "tarefas" + numeroDaTarefa + ".txt";
        }
        
        static String escolha(){
            System.out.printf("Digite a letra correspondente ao tipo de processamento que deseja ser feito: PilhaIngênua = A ou Solução Correta = B." + " Em seguida aperte enter!\n");    
            Scanner in = new Scanner(System.in);      
            String escolhido = in.nextLine();
            return escolhido;
        }
        
    static List criacaoLista(){
        
        List<String> linhas = new ArrayList<>();
        return linhas;
    
    }    
        
    static Gerador criacaoObjeto(String escolhido){
         
         Gerador tipoEscolhido = null;

        switch (escolhido) {
            case "A":
                tipoEscolhido = new PilhaIngenua2();
                break;
            case "B":
                tipoEscolhido = new SolucaoCorreta();
                break;
            default:
                break;
        }
         
        return tipoEscolhido;
     
     } 
    
    static void processamento(List<String> linhas, Gerador tipoEscolhido, String nomeDoArquivo) throws IOException{
             
        PilhaSaida pilhaResultado = new PilhaSaida();
        String path = " ";
        
                       
        path = "Saida" + "_" + nomeDoArquivo;
        
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path))) {
            for(String linhaAtual : linhas){
                if(!linhaAtual.isEmpty()){
                    int linha = Integer.parseInt(linhaAtual);                
                    tipoEscolhido.add(linha);
                }else{                      
                    int processado = tipoEscolhido.remove();
                    pilhaResultado.push(processado);
                }
                
            }
                                 
            for(int p=0;p<pilhaResultado.topoDaPilha;p++){
                int entrada;
                entrada = pilhaResultado.saida[p];
                buffWrite.append(entrada + "\n");
            }
            buffWrite.close(); 
        }    
        }
    }
         

