package analise_de_algoritmo;

import java.util.Random;

public class VetorAleatorio{
 
    public int[] geraVetor( int a)
    {
        Random random = new Random();
        int[] array = new int[a];
        
        for(int i=0;i<a;i++) {
       	 array[i]=i+1;   //preenche o vetor com numeros de acordo com o i
        }
        
        // Começa do ultimo e vai alterando cada elemento pela posição do valor aleatório
        for (int i = a-1; i > 0; i--) { 

            int j = random.nextInt(i+1); //cri um valor aleatorio com no maximo o tamanho da posicção atual -1
            
            //troca a posiçã atual com a aleatoria
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
    
}