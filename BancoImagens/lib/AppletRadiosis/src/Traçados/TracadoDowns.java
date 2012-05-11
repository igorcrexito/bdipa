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
public class TracadoDowns implements Tracado {

    public ArrayList<PontosCefalometricos> listadePontos = new ArrayList<PontosCefalometricos>();
    public ArrayList<Medidas> listaMedidas;

    public void realizarTracado(Graphics g) {
        for (int i=0;i<listadePontos.size();i++) {
            if (listadePontos.get(i).getNome().equals("S")) {
                PontosCefalometricos ponto = listadePontos.set(0, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("N")) {
                PontosCefalometricos ponto = listadePontos.set(1, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Or")) {
                PontosCefalometricos ponto = listadePontos.set(2, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Po")) {
                PontosCefalometricos ponto = listadePontos.set(3, listadePontos.get(i));
                listadePontos.set(i, ponto);
            }  else if (listadePontos.get(i).getNome().equals("A")) {
                PontosCefalometricos ponto = listadePontos.set(4, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("B")) {
                PontosCefalometricos ponto = listadePontos.set(5, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Gn")) {
                PontosCefalometricos ponto = listadePontos.set(6, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Me")) {
                PontosCefalometricos ponto = listadePontos.set(7, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Pog")) {
                PontosCefalometricos ponto = listadePontos.set(8, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("PMA")) {
                PontosCefalometricos ponto = listadePontos.set(9, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("PMP")) {
                PontosCefalometricos ponto = listadePontos.set(10, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("MPM")) {
                PontosCefalometricos ponto = listadePontos.set(11, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Incisal Inc. Inf.")) {
                PontosCefalometricos ponto = listadePontos.set(12, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Incisal Inc. Sup.")) {
                PontosCefalometricos ponto = listadePontos.set(13, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Apice Inc. Inf.")) {
                PontosCefalometricos ponto = listadePontos.set(14, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Apice Inc. Sup.")) {
                PontosCefalometricos ponto = listadePontos.set(15, listadePontos.get(i));
                listadePontos.set(i, ponto);
            }
        }

        g.drawLine(listadePontos.get(2).getPonto().x, listadePontos.get(2).getPonto().y, listadePontos.get(3).getPonto().x, listadePontos.get(3).getPonto().y); //Po-Or
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(8).getPonto().x, listadePontos.get(8).getPonto().y); //N-Pog
        g.drawLine(listadePontos.get(0).getPonto().x, listadePontos.get(0).getPonto().y, listadePontos.get(6).getPonto().x, listadePontos.get(6).getPonto().y); //S-Gn
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(4).getPonto().x, listadePontos.get(4).getPonto().y); //N-A
        g.drawLine(listadePontos.get(8).getPonto().x, listadePontos.get(8).getPonto().y, listadePontos.get(4).getPonto().x, listadePontos.get(4).getPonto().y); //A-Pog
        g.drawLine(listadePontos.get(4).getPonto().x, listadePontos.get(4).getPonto().y, listadePontos.get(5).getPonto().x, listadePontos.get(5).getPonto().y); //A-B
        g.drawLine(listadePontos.get(9).getPonto().x, listadePontos.get(9).getPonto().y, listadePontos.get(10).getPonto().x, listadePontos.get(10).getPonto().y); //PMA-PMB
        g.drawLine(listadePontos.get(11).getPonto().x, listadePontos.get(11).getPonto().y, listadePontos.get(12).getPonto().x, listadePontos.get(12).getPonto().y); //Inc. Ii - MPM
        g.drawLine(listadePontos.get(12).getPonto().x, listadePontos.get(12).getPonto().y, listadePontos.get(14).getPonto().x, listadePontos.get(14).getPonto().y); //Apice - Incisal Ii
        g.drawLine(listadePontos.get(13).getPonto().x, listadePontos.get(13).getPonto().y, listadePontos.get(15).getPonto().x, listadePontos.get(15).getPonto().y); //Apice - Incisal Is

    }

    public ArrayList<PontosCefalometricos> carregaPontos() {
        listadePontos.add(new PontosCefalometricos(new Point(), "S"));
        listadePontos.add(new PontosCefalometricos(new Point(), "N"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Or"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Po"));
        listadePontos.add(new PontosCefalometricos(new Point(), "A"));
        listadePontos.add(new PontosCefalometricos(new Point(), "B"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Gn"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Me"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Pog"));
        listadePontos.add(new PontosCefalometricos(new Point(), "PMA"));
        listadePontos.add(new PontosCefalometricos(new Point(), "PMP"));
        listadePontos.add(new PontosCefalometricos(new Point(), "MPM"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Incisal Inc. Inf."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Incisal Inc. Sup."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Apice Inc. Inf."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Apice Inc. Sup."));


        return listadePontos;
    }

    public void setListaPontos(ArrayList<PontosCefalometricos> pontos) {
        this.listadePontos = pontos;
    }

    public void calcularMedidas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Medidas> getListaMedidas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
