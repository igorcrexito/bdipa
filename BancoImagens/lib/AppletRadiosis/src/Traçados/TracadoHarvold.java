/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Traçados;

import gui.PontosCefalometricos;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Igor-Note
 */
public class TracadoHarvold implements Tracado {

    public ArrayList<PontosCefalometricos> listadePontos = new ArrayList<PontosCefalometricos>();
    public ArrayList<Medidas> listaMedidas;

    public void realizarTracado(Graphics g) {
        for (int i=0;i<listadePontos.size();i++) {
            if (listadePontos.get(i).getNome().equals("ENA")) {
                PontosCefalometricos ponto = listadePontos.set(0, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("ATM")) {
                PontosCefalometricos ponto = listadePontos.set(1, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Gn")) {
                PontosCefalometricos ponto = listadePontos.set(2, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("PGn")) {
                PontosCefalometricos ponto = listadePontos.set(3, listadePontos.get(i));
                listadePontos.set(i, ponto);
            }
        }

        g.drawLine(listadePontos.get(0).getPonto().x, listadePontos.get(0).getPonto().y, listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y);
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(3).getPonto().x, listadePontos.get(3).getPonto().y);
        g.drawLine(listadePontos.get(0).getPonto().x, listadePontos.get(0).getPonto().y, listadePontos.get(2).getPonto().x, listadePontos.get(2).getPonto().y);

        calcularMedidas();
    }

    public ArrayList<PontosCefalometricos> carregaPontos() {
        listadePontos.add(new PontosCefalometricos(new Point(), "ENA"));
        listadePontos.add(new PontosCefalometricos(new Point(), "ATM"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Gn"));
        listadePontos.add(new PontosCefalometricos(new Point(), "PGn"));

        return listadePontos;
    }

    public void setListaPontos(ArrayList<PontosCefalometricos> pontos) {
        this.listadePontos = pontos;
    }

    public void calcularMedidas() {

        listaMedidas = new ArrayList<Medidas>();

        float ComprimentoMandibular = (float) Math.sqrt(Math.abs(listadePontos.get(1).getPonto().x-listadePontos.get(3).getPonto().x)+ Math.abs(listadePontos.get(1).getPonto().y-listadePontos.get(3).getPonto().y));
        float ComprimentoMaxilar = (float) Math.sqrt(Math.abs(listadePontos.get(1).getPonto().x-listadePontos.get(0).getPonto().x)+ Math.abs(listadePontos.get(1).getPonto().y-listadePontos.get(0).getPonto().y));
        float AlturaFacial = (float) Math.sqrt(Math.abs(listadePontos.get(0).getPonto().x-listadePontos.get(2).getPonto().x)+ Math.abs(listadePontos.get(0).getPonto().y-listadePontos.get(2).getPonto().y));
        float DifComprimento = ComprimentoMandibular-ComprimentoMaxilar;

        listaMedidas.add(new Medidas(ComprimentoMandibular, "Comprimento Mandibular"));
        listaMedidas.add(new Medidas(ComprimentoMaxilar, "Comprimento Maxilar"));
        listaMedidas.add(new Medidas(AlturaFacial, "Altura Facial"));
        listaMedidas.add(new Medidas(DifComprimento, "Diferença Comprimento Maxilomandibular"));

    }

    public ArrayList<Medidas> getListaMedidas() {
        return listaMedidas;
    }

    public void setListaMedidas(ArrayList<Medidas> listaMedidas) {
        this.listaMedidas = listaMedidas;
    }


}
