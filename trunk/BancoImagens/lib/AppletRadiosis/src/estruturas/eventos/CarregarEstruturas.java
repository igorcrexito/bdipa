/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas.eventos;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor-Note
 */
public class CarregarEstruturas {

    final File arquivoEstruturas = new File("src/estruturas/resources/Estruturas.txt");
    public ArrayList<EstruturaAnatomica> estruturas = new ArrayList<EstruturaAnatomica>();

    public CarregarEstruturas() {
        carregar();
        
    }

    public ArrayList<EstruturaAnatomica> getEstruturas() {
        return estruturas;
    }

    public void setEstruturas(ArrayList<EstruturaAnatomica> estruturas) {
        this.estruturas = estruturas;
    }

    public void carregar() {

        ArrayList<Point> pontos = new ArrayList<Point>();
        pontos.add(new Point(30,40));
        pontos.add(new Point(60,40));
        pontos.add(new Point(60,70));
        pontos.add(new Point(30,70));
        estruturas.add(new EstruturaAnatomica("Molar Superior", pontos));

        /*
        try {
            FileReader leitor = new FileReader(arquivoEstruturas);
            BufferedReader bleitor = new BufferedReader(leitor);
            String linha = "";
            try {

                while ((linha = bleitor.readLine()) != null) {

                    String nome = bleitor.readLine();
                    int numPontos = Integer.parseInt(bleitor.readLine());
                    ArrayList<Point> pontos = new ArrayList<Point>();

                    for (int i = 0; i < numPontos; i++) {
                        linha = bleitor.readLine();
                        String[] vetor = linha.split(",");
                        pontos.add(new Point(Integer.parseInt(vetor[0]), Integer.parseInt(vetor[1])));
                    }

                    estruturas.add(new EstruturaAnatomica(nome,pontos));
                }

                leitor.close();
                bleitor.close();
            } catch (IOException ex) {
                Logger.getLogger(CarregarEstruturas.class.getName()).log(Level.SEVERE, null, ex);
            }


        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarEstruturas.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }

 
}
