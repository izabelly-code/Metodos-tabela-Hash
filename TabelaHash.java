package com.mycompany.tdehashe;
public class TabelaHash {
    int tamanho;
    LinkedList [] hashTable;

    public TabelaHash(int tam){
        tamanho = tam;
        hashTable=new LinkedList[tamanho];
        for (int i=0;i<tamanho;i++){
        hashTable[i]=new LinkedList();
        }
    }
    public int inserir(int posicao, int chave){
        if(hashTable[posicao].list!=null){
        hashTable[posicao].insert(chave); 
        return 1;
        }
        else{
        hashTable[posicao].insert(chave); 
        return 0;}
    }
    //mudar 1000 para tamanho da tabela, ser um numero primo =1021
    public int restoDivisao(int chave) {
        //System.out.println("Dentro da função"+chave.valor);
        int posicao=((int)chave) % this.tamanho;
        //System.out.println(posicao+" :"+chave.valor);
        return inserir(posicao,chave);
    }
    public int hashMultiplicacao(int chave) {
        double a = 0.61803398887; 
        double val= chave *a;     
        val=val -(int) val;
        int posicao= (int)(val*tamanho);
       return inserir(posicao, chave);
    }
    public int dobramento(int chave){
    /*int hash = 0;
    int a = chave;
    for(int i=0; i<9; i++){
        int digito = a % 10;
        hash = (hash << 5) + hash + digito;
         a /= 10;
         }*/
    int num_bits=3;
    int parte1 = chave >>num_bits;
    int parte2= chave & (tamanho-1);
    int posicao = parte1 ^ parte2;  
    posicao= posicao %tamanho;
    
    return inserir(posicao,chave);
    }
    
    public void busca_resto(int chave){
    int posicao=((int)chave) % this.tamanho;
        hashTable[posicao].busca(chave);    
    }
    
    public void busca_mult(int chave){
        double a = 0.61803398887; 
        double val= chave *a;     
        val=val -(int) val;
        int posicao= (int)(val*tamanho);
        hashTable[posicao].busca(chave);
    }
    public void busca_dob(int chave){
         int num_bits=3;
         int parte1 = chave >>num_bits;
        int parte2= chave & (tamanho-1);
        int posicao = parte1 ^ parte2;  
        posicao= posicao %tamanho;
        hashTable[posicao].busca(chave);
    }
    
}
