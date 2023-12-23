package analise_de_algoritmo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Grafico {
    public void geraGrafico(double[] vetorValores) {

    	int numero_de_elementos=10000;
        // Criar um conjunto de dados
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Adicionar os valores do vetor ao conjunto de dados
        for (int i = 0; i < vetorValores.length; i++) {
            dataset.addValue(vetorValores[i], "Série 1", String.valueOf(numero_de_elementos));
            numero_de_elementos+=10000;
        }

        // Criar o gráfico de linhas
        JFreeChart chart = ChartFactory.createLineChart(
                "Tempo de Ordenação de Vetores", // Título do gráfico
                "Numero de Elementos", // Rótulo do eixo x (categorias)
                "Picosegundos (1s / 1.000.000.000.000)", // Rótulo do eixo y (valores)
                dataset, // Conjunto de dados
                PlotOrientation.VERTICAL, // Orientação do gráfico
                true, // Incluir legenda
                true, // Usar tooltips
                false // Usar URLs
        );
        
        // Criar um painel para exibir o gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        // Criar uma janela para exibir o gráfico
        JFrame frame = new JFrame("Gráfico de Linhas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
