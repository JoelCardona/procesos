
package tema1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ContadorCompleto implements Runnable{ //creamos el runnable del hilo que esta implenetado
                          // se introducen cada 
  BufferedReader bufread;
  String name;
  char letraa;
  int cont = 0; // no va incluido en el constructor
  
  
  public RunnableContadorCompleto(String nameh,char letra,BufferedReader br) {
    // TODO Auto-generated constructor stub
    this.name = nameh;// los nombres tienen que ser diferente a la varible
    this.bufread = br;
    this.letraa = letra;
  }

  @Override
  public void run() {    
    try {
      String linea;//declaro la linea para que pueda leer
      while ((linea= bufread.readLine())!=null) { // mientras que comparo que no este vacia o sea diferente de null 
        linea.toLowerCase();// pasa todas a minusculas para no comparar minusculas con mayúsculas
        for(int i= 0; i<linea.length();i++) { //Ahora hago un bucle para poder recorre el texto
          if(linea.charAt(i)==this.letraa) { //Recorro cada caracter
            cont++;              // Si conincide con la letra el carcater empieza a contar
          }
        }
        
      }
      System.out.format("El hilo %s ha encontrado %d  %c\n",this.name,this.cont,this.letraa); // imprimo el resultado
    } catch (IOException e) {
      // TODO Auto-generated catch block
      //Aquí solo se usa como una excepcion para poner las letras en rojo.
      
      
      e.printStackTrace();
    }
    
  }
  
}



public class ContadorVocales {

  public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    
    String archivo = "C:\\Users\\User\\Downloads\\Lorem.txt"; //determino el archivo 
        
    
    // lo introduzco en un try y catch para que no se colapse, que te lo pide
    // debo de crear un bufferReader para cada uno porque no se pueden unir , deben de realizarse separadaos.
    try {
      RunnableContadorVocales r1 = new RunnableContadorVocales("hilo_a",'a',new BufferedReader(new FileReader(archivo)));
      Thread t1 = new Thread(r1);
      t1.start();
      
      RunnableContadorVocales r2 = new RunnableContadorVocales("hilo_e",'e',new BufferedReader(new FileReader(archivo)));
      Thread t2 = new Thread(r2);
      t1.join();//con este se introduce el anterior ya realizado(Función RUN)
      t2.start();// comienza
      
      RunnableContadorVocales r3 = new RunnableContadorVocales("hilo_i",'i',new BufferedReader(new FileReader(archivo)));
      Thread t3 = new Thread(r3);
      t2.join();
      t3.start();
      
      RunnableContadorVocales r4 = new RunnableContadorVocales("hilo_o",'o',new BufferedReader(new FileReader(archivo)));
      Thread t4 = new Thread(r4);
      t3.join();
      t4.start();
      
      RunnableContadorVocales r5 = new RunnableContadorVocales("hilo_u",'u',new BufferedReader(new FileReader(archivo)));
      Thread t5 = new Thread(r5);
      t4.join();
      t5.start();

      RunnableContadorVocales r6 = new RunnableContadorVocales("hilo_b",'b',new BufferedReader(new FileReader(archivo)));
      Thread t6 = new Thread(r6);
      t5.join();
      t6.start();
      
      RunnableContadorVocales r7 = new RunnableContadorVocales("hilo_c",'c',new BufferedReader(new FileReader(archivo)));
      Thread t7 = new Thread(r7);
      t6.join();
      t7.start();
      
      
    
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  
}

public class ContadorConsonantes {
  public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    
    
  }
}