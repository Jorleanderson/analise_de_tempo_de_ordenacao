package analise_de_algoritmo;

import java.util.Arrays;

public class Estatistica {
private double[] array;

public double getMediaAritmetica() {
return getSomaDosElementos() / array.length;
}

public double getSomaDosElementos() {
double total = 0;
for (int counter = 0; counter < array.length; counter++)
total += array[counter];
return total;
}

public double getSomaDosElementosAoQuadrado() {
double total = 0;
for (int counter = 0; counter < array.length; counter++)
total += Math.pow(array[counter], 2);
return total;
}

public void ordenar() {
Arrays.sort(array);
}

// Array não pode conter valores duplicados
public int buscaPor(int value) {
return Arrays.binarySearch(array, value);
}

// Variancia
public double getVariancia() {

	double resultado=0;
	for(int i=0;i<array.length;i++) {
		resultado += Math.pow(array[i]-getMediaAritmetica(), 2);	
	}
return resultado/array.length;
}
// Desvio Padrao
public double getDesvioPadrao() {
return Math.sqrt(getVariancia());
}
//Mediana
public double getMediana() {
this.ordenar();
int tipo = array.length % 2;
if (tipo == 1) {
return array[((array.length + 1) / 2) - 1];
} else {
int m = array.length / 2;
return (array[m - 1] + array[m]) / 2;
}
}

public double[] getArray() {
return array;
}
public void setArray(double[] array) {
this.array = array;
}
}