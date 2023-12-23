package analise_de_algoritmo;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		
		int tamanho = 10000;
		double[] resultado_final = new double[15];//
		
		Estatistica estatistica = new Estatistica();
		VetorAleatorio vetorAleatorio = new VetorAleatorio();
		Quicksort quicksort = new Quicksort();
		Grafico grafico = new Grafico();
			
		for(int k=0;k<15;k++) {
				
			int[] vetor = new int[tamanho];
			double[] resultado_parcial = new double[30];
					
			vetor = vetorAleatorio.geraVetor(tamanho); //cria um vetor aleatório com o tamanho exato a cada iteração de k
					
			for (int i=0;i<50;i++) {
					
				int[] vetorClone = vetor.clone(); //cria um clone para que  ordenação seja feita sempre a partir do mesmo vetor e assim tirar a média do tempo de execução
				
				//quarda o tempo de inicio e fim da execução da ordenação
				double tempoInicial = System.nanoTime(); 
				quicksort.ordenar(vetorClone, 0, vetorClone.length - 1);
				double tempoFinal = System.nanoTime();
				
				//o codigo irá rodar 20x para aquecer e evitar interferencia no tempo( indicação do professor)
				if(i >19) { 
					resultado_parcial[i-20]=((tempoFinal - tempoInicial)/1000); //quarda tempo em picossegundos 10^-12
				}
			}
			
		estatistica.setArray(resultado_parcial);
		
		resultado_final[k] = estatistica.getMediaAritmetica();
		System.out.println(" vetor de tempo para "+tamanho+" elementos: "+Arrays.toString(resultado_parcial));
		System.out.println(" Media Aritmetica: "+estatistica.getMediaAritmetica());
		System.out.println(" mediana: "+ estatistica.getMediana());
		System.out.println(" Variancia Populacional: "+estatistica.getVariancia()+"\n");
	
		tamanho += 10000;
		}
	grafico.geraGrafico(resultado_final);
	}
}