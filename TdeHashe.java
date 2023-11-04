package com.mycompany.tdehashe;

import java.util.Random;

public class TdeHashe {
    public static long[][] calcular(Registro[] r, TabelaHash hashResto, TabelaHash hashMulti, TabelaHash hashDob){

  long[][] total = new long[3][3];

  // Create threads for each hash function
  Thread t1 = new Thread(() -> {
    long tempoInicio = System.currentTimeMillis();
    for (Registro i : r) {
      total[0][0] += hashResto.restoDivisao(i.valor);
    }  
    long tempoFim = System.currentTimeMillis();
    total[1][0] = tempoFim - tempoInicio;

    tempoInicio = System.currentTimeMillis();
    for (Registro i : r) {
      hashResto.busca_resto(i.valor);
    }
    tempoFim = System.currentTimeMillis();
    total[2][0] = tempoFim - tempoInicio;
  });

  Thread t2 = new Thread(() -> { 
    long tempoInicio = System.currentTimeMillis();
    for (Registro i : r) {
      total[0][1] += hashMulti.hashMultiplicacao(i.valor);
    }
    long tempoFim = System.currentTimeMillis();
    total[1][1] = tempoFim - tempoInicio;

    tempoInicio = System.currentTimeMillis();
    for (Registro i : r) {
      hashMulti.busca_mult(i.valor);
    }
    tempoFim = System.currentTimeMillis();
    total[2][1] = tempoFim - tempoInicio;
  });

  Thread t3 = new Thread(() -> {
    long tempoInicio = System.currentTimeMillis();
    for (Registro i : r) {
      total[0][2] += hashDob.dobramento(i.valor);
    }
    long tempoFim = System.currentTimeMillis();
    total[1][2] = tempoFim - tempoInicio;

    tempoInicio = System.currentTimeMillis();
    for (Registro i : r) {
      hashDob.busca_dob(i.valor);
    }
    tempoFim = System.currentTimeMillis();
    total[2][2] = tempoFim - tempoInicio;
  });

  // Start threads
  t1.start();
  t2.start();
  t3.start();

  // Join threads
  try {
    t1.join();
    t2.join();
    t3.join();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }

  return total;
}
    
    public static void main(String[] args) {
       
        // TODO vector size 10000
        // TODO vector size 100000
        // TODO vector size 1000000
        // TODO vector size 10000000
        
//Colecao objetos
        Random rand = new Random();
        rand.setSeed(420000000);
            
        Registro[] registers20 = new Registro[20000];
        Registro[] registers100 = new Registro[100000];
        Registro[] registers500 = new Registro[500000];
        Registro[] registers1m = new Registro[1000000];
        Registro[] register5m = new Registro[5000000]; 
        for (int i = 0; i < 20000; i++) {
          registers20[i] = new Registro( rand.nextInt(900000000) + 100000000); 
        }
        for (int i = 0; i < 100000; i++) {
          registers100[i] = new Registro( rand.nextInt(900000000) + 100000000); 
        }
        for (int i = 0; i < 100000; i++) {
          registers100[i] = new Registro( rand.nextInt(900000000) + 100000000); 
        }
        for (int i = 0; i < 500000; i++) {
          registers500[i] = new Registro( rand.nextInt(900000000) + 100000000); 
        }
        for (int i = 0; i < 1000000; i++) {
          registers1m[i] = new Registro( rand.nextInt(900000000) + 100000000); 
        }
        for (int i = 0; i < 5000000; i++) {
          register5m[i] = new Registro( rand.nextInt(900000000) + 100000000); 
        } 
        
 //vetor 101

        TabelaHash hashResto = new TabelaHash(101);
        TabelaHash hashMulti = new TabelaHash(101);
        TabelaHash hashDob = new TabelaHash(101);
        
        //fazer matrix colisoes linhas da tabela hash e colunas tamanho da coleção 
        long [][] totalCol_res= new long[5][5];
        long [][] totalCol_mul=new long[5][5];
        long [][] totalCol_dob= new long[5][5];
        
        //matriz tempo
        long [][] temp_res= new long[5][5];
        long [][] temp_mul=new long[5][5];
        long [][] temp_dob= new long[5][5];
         
        //matrix tempo busca
        long [][] bus_res=new long[5][5];
        long [][] bus_mul= new long[5][5];
        long [][] bus_dob= new long[5][5];
        
        
       //20 mil elementos
        long [][] elementos;
        /*elementos=calcular(registers20,hashResto,hashMulti,hashDob);
        
        totalCol_res[0][0]=elementos[0][0];
        totalCol_mul[0][0]=elementos[0][1];        
        totalCol_dob[0][0]=elementos[0][2];
        
        temp_res[0][0]=elementos[1][0];
        temp_mul[0][0]=elementos[1][1];
        temp_dob[0][0]=elementos[1][2];
        
        bus_res[0][0]=elementos[2][0];
        bus_mul[0][0]=elementos[2][1];
        bus_dob[0][0]=elementos[2][2];
        
        
              
        
        
        
        //100 mil elementos
        elementos=calcular(registers100,hashResto,hashMulti,hashDob);
        
        totalCol_res[0][1]=elementos[0][0];
        totalCol_mul[0][1]=elementos[0][1];        
        totalCol_dob[0][1]=elementos[0][2];
        
        temp_res[0][1]=elementos[1][0];
        temp_mul[0][1]=elementos[1][1];
        temp_dob[0][1]=elementos[1][2];
        
        bus_res[0][1]=elementos[2][0];
        bus_mul[0][1]=elementos[2][1];
        bus_dob[0][1]=elementos[2][2];

        // 500 mil elementos
        elementos=calcular(registers500,hashResto,hashMulti,hashDob);

        totalCol_res[0][2]=elementos[0][0];
        totalCol_mul[0][2]=elementos[0][1];        
        totalCol_dob[0][2]=elementos[0][2];
        
        temp_res[0][2]=elementos[1][0];
        temp_mul[0][2]=elementos[1][1];
        temp_dob[0][2]=elementos[1][2];
        
        bus_res[0][2]=elementos[2][0];
        bus_mul[0][2]=elementos[2][1];
        bus_dob[0][2]=elementos[2][2];*/
        
         // 1 milhão de elementos
        elementos=calcular(registers1m,hashResto,hashMulti,hashDob);
        totalCol_res[0][3]=elementos[0][0];
        totalCol_mul[0][3]=elementos[0][1];        
        totalCol_dob[0][3]=elementos[0][2];
        
        temp_res[0][3]=elementos[1][0];
        temp_mul[0][3]=elementos[1][1];
        temp_dob[0][3]=elementos[1][2];
        
        bus_res[0][3]=elementos[2][0];
        bus_mul[0][3]=elementos[2][1];
        bus_dob[0][3]=elementos[2][2];
 
for (int i=3;i<4;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[0][i]);
System.out.println(";"+totalCol_mul[0][i]+';'+totalCol_dob[0][i]+';'+temp_res[0][i]+';'+temp_mul[0][i]+';'+temp_dob[0][i]+';'+bus_res[0][i]+';'+bus_mul[0][i]+';'+bus_dob[0][i]); 
    }
       
    /* 5 milhões de elementos
       elementos=calcular(register5m,hashResto,hashMulti,hashDob);
        totalCol_res[0][4]=elementos[0][0];
        totalCol_mul[0][4]=elementos[0][1];        
        totalCol_dob[0][4]=elementos[0][2];
        
        temp_res[0][4]=elementos[1][0];
        temp_mul[0][4]=elementos[1][1];
        temp_dob[0][4]=elementos[1][2];
        
        bus_res[0][4]=elementos[2][0];
        bus_mul[0][4]=elementos[2][1];
        bus_dob[0][4]=elementos[2][2];
   for (int i=4;i<5;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[0][i]);
System.out.println(";"+totalCol_mul[0][i]+';'+totalCol_dob[0][i]+';'+temp_res[0][i]+';'+temp_mul[0][i]+';'+temp_dob[0][i]+';'+bus_res[0][i]+';'+bus_mul[0][i]+';'+bus_dob[0][i]); 
    }
    

//vetor 1021

        hashResto = new TabelaHash(1021);
        hashMulti = new TabelaHash(1021);
        hashDob = new TabelaHash(1021);

      //20 mil elementos
        elementos=calcular(registers20,hashResto,hashMulti,hashDob);
       
        totalCol_res[1][0]=elementos[0][0];
        totalCol_mul[1][0]=elementos[0][1];        
        totalCol_dob[1][0]=elementos[0][2];
        
        temp_res[1][0]=elementos[1][0];
        temp_mul[1][0]=elementos[1][1];
        temp_dob[1][0]=elementos[1][2];
        
        bus_res[1][0]=elementos[2][0];
        bus_mul[1][0]=elementos[2][1];
        bus_dob[1][0]=elementos[2][2];
        for (int i=0;i<1;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[1][i]);
System.out.println(";"+totalCol_mul[1][i]+';'+totalCol_dob[1][i]+';'+temp_res[1][i]+';'+temp_mul[1][i]+';'+temp_dob[1][i]+';'+bus_res[1][i]+';'+bus_mul[0][i]+';'+bus_dob[0][i]); 
    }*/
        
       /* //100 mil elementos
        elementos=calcular(registers100,hashResto,hashMulti,hashDob);
        
        totalCol_res[1][1]=elementos[0][0];
        totalCol_mul[1][1]=elementos[0][1];        
        totalCol_dob[1][1]=elementos[0][2];
        
        temp_res[1][1]=elementos[1][0];
        temp_mul[1][1]=elementos[1][1];
        temp_dob[1][1]=elementos[1][2];
        
        bus_res[1][1]=elementos[2][0];
        bus_mul[1][1]=elementos[2][1];
        bus_dob[1][1]=elementos[2][2];
                for (int i=1;i<2;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[1][i]);
System.out.println(";"+totalCol_mul[1][i]+';'+totalCol_dob[1][i]+';'+temp_res[1][i]+';'+temp_mul[1][i]+';'+temp_dob[1][i]+';'+bus_res[1][i]+';'+bus_mul[1][i]+';'+bus_dob[1][i]); 
               }*/ 
       /* // 500 mil elementos
        elementos=calcular(registers500,hashResto,hashMulti,hashDob);

        totalCol_res[1][2]=elementos[0][0];
        totalCol_mul[1][2]=elementos[0][1];        
        totalCol_dob[1][2]=elementos[0][2];
        
        temp_res[1][2]=elementos[1][0];
        temp_mul[1][2]=elementos[1][1];
        temp_dob[1][2]=elementos[1][2];
        
        bus_res[1][2]=elementos[2][0];
        bus_mul[1][2]=elementos[2][1];
        bus_dob[1][2]=elementos[2][2];
                for (int i=2;i<3;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[1][i]);
System.out.println(";"+totalCol_mul[1][i]+';'+totalCol_dob[1][i]+';'+temp_res[1][i]+';'+temp_mul[1][i]+';'+temp_dob[1][i]+';'+bus_res[1][i]+';'+bus_mul[1][i]+';'+bus_dob[1][i]); 
                } 
   /*     // 1 milhão de elementos
        elementos=calcular(registers1m,hashResto,hashMulti,hashDob);
        totalCol_res[1][3]=elementos[0][0];
        totalCol_mul[1][3]=elementos[0][1];        
        totalCol_dob[1][3]=elementos[0][2];
        
        temp_res[1][3]=elementos[1][0];
        temp_mul[1][3]=elementos[1][1];
        temp_dob[1][3]=elementos[1][2];
        
        bus_res[1][3]=elementos[2][0];
        bus_mul[1][3]=elementos[2][1];
        bus_dob[1][3]=elementos[2][2];
                        for (int i=3;i<4;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[1][i]);
System.out.println(";"+totalCol_mul[1][i]+';'+totalCol_dob[1][i]+';'+temp_res[1][i]+';'+temp_mul[1][i]+';'+temp_dob[1][i]+';'+bus_res[1][i]+';'+bus_mul[1][i]+';'+bus_dob[1][i]); 
                        }
      
        // 5 milhões de elementos
        elementos=calcular(register5m,hashResto,hashMulti,hashDob);
        totalCol_res[1][4]=elementos[0][0];
        totalCol_mul[1][4]=elementos[0][1];        
        totalCol_dob[1][4]=elementos[0][2];
        
        temp_res[1][4]=elementos[1][0];
        temp_mul[1][4]=elementos[1][1];
        temp_dob[1][4]=elementos[1][2];
        
        bus_res[1][4]=elementos[2][0];
        bus_mul[1][4]=elementos[2][1];
        bus_dob[1][4]=elementos[2][2];
                           for (int i=4;i<5;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[1][i]);
System.out.println(";"+totalCol_mul[1][i]+';'+totalCol_dob[1][i]+';'+temp_res[1][i]+';'+temp_mul[1][i]+';'+temp_dob[1][i]+';'+bus_res[1][i]+';'+bus_mul[1][i]+';'+bus_dob[1][i]); 
                        }
  */ 
        
//vetor 10007
/*
        hashResto = new TabelaHash(10007);
        hashMulti = new TabelaHash(10007);
        hashDob = new TabelaHash(10007);

        //20 mil elementos
        elementos=calcular(registers20,hashResto,hashMulti,hashDob);
       
        totalCol_res[2][0]=elementos[0][0];
        totalCol_mul[2][0]=elementos[0][1];        
        totalCol_dob[2][0]=elementos[0][2];
        
        temp_res[2][0]=elementos[1][0];
        temp_mul[2][0]=elementos[1][1];
        temp_dob[2][0]=elementos[1][2];
        
        bus_res[2][0]=elementos[2][0];
        bus_mul[2][0]=elementos[2][1];
        bus_dob[2][0]=elementos[2][2];
               for (int i=0;i<1;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[2][i]);
System.out.println(";"+totalCol_mul[2][i]+';'+totalCol_dob[2][i]+';'+temp_res[2][i]+';'+temp_mul[2][i]+';'+temp_dob[2][i]+';'+bus_res[2][i]+';'+bus_mul[2][i]+';'+bus_dob[2][i]); 
                   }

  */           
    /*    //100 mil elementos
        elementos=calcular(registers100,hashResto,hashMulti,hashDob);
        
        totalCol_res[2][1]=elementos[0][0];
        totalCol_mul[2][1]=elementos[0][1];        
        totalCol_dob[2][1]=elementos[0][2];
        
        temp_res[2][1]=elementos[1][0];
        temp_mul[2][1]=elementos[1][1];
        temp_dob[2][1]=elementos[1][2];
        
        bus_res[2][1]=elementos[2][0];
        bus_mul[2][1]=elementos[2][1];
        bus_dob[2][1]=elementos[2][2];
              for (int i=1;i<2;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[2][i]);
System.out.println(";"+totalCol_mul[2][i]+';'+totalCol_dob[2][i]+';'+temp_res[2][i]+';'+temp_mul[2][i]+';'+temp_dob[2][i]+';'+bus_res[2][i]+';'+bus_mul[2][i]+';'+bus_dob[2][i]); 
                   }

    
        // 500 mil elementos
        elementos=calcular(registers500,hashResto,hashMulti,hashDob);

        totalCol_res[2][2]=elementos[0][0];
        totalCol_mul[2][2]=elementos[0][1];        
        totalCol_dob[2][2]=elementos[0][2];
        
        temp_res[2][2]=elementos[1][0];
        temp_mul[2][2]=elementos[1][1];
        temp_dob[2][2]=elementos[1][2];
        
        bus_res[2][2]=elementos[2][0];
        bus_mul[2][2]=elementos[2][1];
        bus_dob[2][2]=elementos[2][2];
                  for (int i=2;i<3;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[2][i]);
System.out.println(";"+totalCol_mul[2][i]+';'+totalCol_dob[2][i]+';'+temp_res[2][i]+';'+temp_mul[2][i]+';'+temp_dob[2][i]+';'+bus_res[2][i]+';'+bus_mul[2][i]+';'+bus_dob[2][i]); 
    */               
    /*
        // 1 milhão de elementos
        elementos=calcular(registers1m,hashResto,hashMulti,hashDob);
        totalCol_res[2][3]=elementos[0][0];
        totalCol_mul[2][3]=elementos[0][1];        
        totalCol_dob[2][3]=elementos[0][2];
        
        temp_res[2][3]=elementos[1][0];
        temp_mul[2][3]=elementos[1][1];
        temp_dob[2][3]=elementos[1][2];
        
        bus_res[2][3]=elementos[2][0];
        bus_mul[2][3]=elementos[2][1];
        bus_dob[2][3]=elementos[2][2];
                          for (int i=3;i<4;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[2][i]);
System.out.println(";"+totalCol_mul[2][i]+';'+totalCol_dob[2][i]+';'+temp_res[2][i]+';'+temp_mul[2][i]+';'+temp_dob[2][i]+';'+bus_res[2][i]+';'+bus_mul[2][i]+';'+bus_dob[2][i]); 
                  }
      */  
       /* // 5 milhões de elementos
        elementos=calcular(register5m,hashResto,hashMulti,hashDob);
        totalCol_res[2][4]=elementos[0][0];
        totalCol_mul[2][4]=elementos[0][1];        
        totalCol_dob[2][4]=elementos[0][2];
        
        temp_res[2][4]=elementos[1][0];
        temp_mul[2][4]=elementos[1][1];
        temp_dob[2][4]=elementos[1][2];
        
        bus_res[2][4]=elementos[2][0];
        bus_mul[2][4]=elementos[2][1];
        bus_dob[2][4]=elementos[2][2];
        
                        for (int i=4;i<5;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[2][i]);
System.out.println(";"+totalCol_mul[2][i]+';'+totalCol_dob[2][i]+';'+temp_res[2][i]+';'+temp_mul[2][i]+';'+temp_dob[2][i]+';'+bus_res[2][i]+';'+bus_mul[2][i]+';'+bus_dob[2][i]); 
                  }

    
// vetor 100129
        hashResto = new TabelaHash(100129);
        hashMulti = new TabelaHash(100129);
        hashDob = new TabelaHash(100129);

        //20 mil elementos
  /*      elementos=calcular(registers20,hashResto,hashMulti,hashDob);
       
        totalCol_res[3][0]=elementos[0][0];
        totalCol_mul[3][0]=elementos[0][1];        
        totalCol_dob[3][0]=elementos[0][2];
        
        temp_res[3][0]=elementos[1][0];
        temp_mul[3][0]=elementos[1][1];
        temp_dob[3][0]=elementos[1][2];
        
        bus_res[3][0]=elementos[2][0];
        bus_mul[3][0]=elementos[2][1];
        bus_dob[3][0]=elementos[2][2];
        int j=3;
                              for (int i=0;i<1;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
                  }
        
       
        //100 mil elementos
        elementos=calcular(registers100,hashResto,hashMulti,hashDob);
        
        totalCol_res[3][1]=elementos[0][0];
        totalCol_mul[3][1]=elementos[0][1];        
        totalCol_dob[3][1]=elementos[0][2];
        
        temp_res[3][1]=elementos[1][0];
        temp_mul[3][1]=elementos[1][1];
        temp_dob[3][1]=elementos[1][2];
        
        bus_res[3][1]=elementos[2][0];
        bus_mul[3][1]=elementos[2][1];
        bus_dob[3][1]=elementos[2][2];
        for (int i=1;i<2;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
        // 500 mil elementos
        elementos=calcular(registers500,hashResto,hashMulti,hashDob);

        totalCol_res[3][2]=elementos[0][0];
        totalCol_mul[3][2]=elementos[0][1];        
        totalCol_dob[3][2]=elementos[0][2];
        
        temp_res[3][2]=elementos[1][0];
        temp_mul[3][2]=elementos[1][1];
        temp_dob[3][2]=elementos[1][2];
        
        bus_res[3][2]=elementos[2][0];
        bus_mul[3][2]=elementos[2][1];
        bus_dob[3][2]=elementos[2][2];
        
        for (int i=2;i<3;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
        // 1 milhão de elementos
        elementos=calcular(registers1m,hashResto,hashMulti,hashDob);
        totalCol_res[3][3]=elementos[0][0];
        totalCol_mul[3][3]=elementos[0][1];        
        totalCol_dob[3][3]=elementos[0][2];
        
        temp_res[3][3]=elementos[1][0];
        temp_mul[3][3]=elementos[1][1];
        temp_dob[3][3]=elementos[1][2];
        
        bus_res[3][3]=elementos[2][0];
        bus_mul[3][3]=elementos[2][1];
        bus_dob[3][3]=elementos[2][2];
         for (int i=3;i<4;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
       
        // 5 milhões de elementos
        elementos=calcular(register5m,hashResto,hashMulti,hashDob);
        totalCol_res[3][4]=elementos[0][0];
        totalCol_mul[3][4]=elementos[0][1];        
        totalCol_dob[3][4]=elementos[0][2];
        
        temp_res[3][4]=elementos[1][0];
        temp_mul[3][4]=elementos[1][1];
        temp_dob[3][4]=elementos[1][2];
        
        bus_res[3][4]=elementos[2][0];
        bus_mul[3][4]=elementos[2][1];
        bus_dob[3][4]=elementos[2][2];
        int j=3;
       for (int i=4;i<5;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
// vetor 1.000.019
        hashResto = new TabelaHash(1000019);
        hashMulti = new TabelaHash(1000019);
        hashDob = new TabelaHash(1000019);

     /*   //20 mil elementos
        elementos=calcular(registers20,hashResto,hashMulti,hashDob);
       
        totalCol_res[4][0]=elementos[0][0];
        totalCol_mul[4][0]=elementos[0][1];        
        totalCol_dob[4][0]=elementos[0][2];
        
        temp_res[4][0]=elementos[1][0];
        temp_mul[4][0]=elementos[1][1];
        temp_dob[4][0]=elementos[1][2];
        
        bus_res[4][0]=elementos[2][0];
        bus_mul[4][0]=elementos[2][1];
        bus_dob[4][0]=elementos[2][2];
        int j=4;
        for (int i=0;i<1;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
        //100 mil elementos
        elementos=calcular(registers100,hashResto,hashMulti,hashDob);
        
        totalCol_res[4][1]=elementos[0][0];
        totalCol_mul[4][1]=elementos[0][1];        
        totalCol_dob[4][1]=elementos[0][2];
        
        temp_res[4][1]=elementos[1][0];
        temp_mul[4][1]=elementos[1][1];
        temp_dob[4][1]=elementos[1][2];
        
        bus_res[4][1]=elementos[2][0];
        bus_mul[4][1]=elementos[2][1];
        bus_dob[4][1]=elementos[2][2];
        j=4;
        for (int i=1;i<2;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
        // 500 mil elementos
        elementos=calcular(registers500,hashResto,hashMulti,hashDob);

        totalCol_res[4][2]=elementos[0][0];
        totalCol_mul[4][2]=elementos[0][1];        
        totalCol_dob[4][2]=elementos[0][2];
        
        temp_res[4][2]=elementos[1][0];
        temp_mul[4][2]=elementos[1][1];
        temp_dob[4][2]=elementos[1][2];
        
        bus_res[4][2]=elementos[2][0];
        bus_mul[4][2]=elementos[2][1];
        bus_dob[4][2]=elementos[2][2];
         
        for (int i=2;i<3;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
        // 1 milhão de elementos
        elementos=calcular(registers1m,hashResto,hashMulti,hashDob);
        totalCol_res[4][3]=elementos[0][0];
        totalCol_mul[4][3]=elementos[0][1];        
        totalCol_dob[4][3]=elementos[0][2];
        
        temp_res[4][3]=elementos[1][0];
        temp_mul[4][3]=elementos[1][1];
        temp_dob[4][3]=elementos[1][2];
        
        bus_res[4][3]=elementos[2][0];
        bus_mul[4][3]=elementos[2][1];
        bus_dob[4][3]=elementos[2][2];
             
        for (int i=3;i<4;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }
        // 5 milhões de elementos
        elementos=calcular(register5m,hashResto,hashMulti,hashDob);
        totalCol_res[4][4]=elementos[0][0];
        totalCol_mul[4][4]=elementos[0][1];        
        totalCol_dob[4][4]=elementos[0][2];
        
        temp_res[4][4]=elementos[1][0];
        temp_mul[4][4]=elementos[1][1];
        temp_dob[4][4]=elementos[1][2];
        
        bus_res[4][4]=elementos[2][0];
        bus_mul[4][4]=elementos[2][1];
        bus_dob[4][4]=elementos[2][2];
        int j=4;
      for (int i=4;i<5;i++){  
       System.out.println("====================================================================================");
    System.out.println(totalCol_res[j][i]);
System.out.println(";"+totalCol_mul[j][i]+';'+totalCol_dob[j][i]+';'+temp_res[j][i]+';'+temp_mul[j][i]+';'+temp_dob[j][i]+';'+bus_res[j][i]+';'+bus_mul[j][i]+';'+bus_dob[j][i]); 
        }*/
        }




}
