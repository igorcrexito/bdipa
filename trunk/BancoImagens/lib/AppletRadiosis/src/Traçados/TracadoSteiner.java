/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Traçados;

import gui.PontosCefalometricos;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Igor-Note
 */
public class TracadoSteiner implements Tracado {

    public ArrayList<PontosCefalometricos> listadePontos = new ArrayList<PontosCefalometricos>();
    public ArrayList<Medidas> listaMedidas;

    public void realizarTracado(Graphics g) {

        for (int i = 0; i < listadePontos.size(); i++) {
            if (listadePontos.get(i).getNome().equals("S")) {
                PontosCefalometricos ponto = listadePontos.set(0, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("N")) {
                PontosCefalometricos ponto = listadePontos.set(1, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("A")) {
                PontosCefalometricos ponto = listadePontos.set(2, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("B")) {
                PontosCefalometricos ponto = listadePontos.set(3, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("D")) {
                PontosCefalometricos ponto = listadePontos.set(4, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Go")) {
                PontosCefalometricos ponto = listadePontos.set(5, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Gn")) {
                PontosCefalometricos ponto = listadePontos.set(6, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Pog")) {
                PontosCefalometricos ponto = listadePontos.set(7, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Pog'")) {
                PontosCefalometricos ponto = listadePontos.set(8, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Labio Sup.")) {
                PontosCefalometricos ponto = listadePontos.set(9, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Apice Inc. Sup.")) {
                PontosCefalometricos ponto = listadePontos.set(10, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Apice Inc. Inf.")) {
                PontosCefalometricos ponto = listadePontos.set(11, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Incisal Inc. Sup.")) {
                PontosCefalometricos ponto = listadePontos.set(12, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Incisal Inc. Inf.")) {
                PontosCefalometricos ponto = listadePontos.set(13, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Or")) {
                PontosCefalometricos ponto = listadePontos.set(14, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("MPM")) {
                PontosCefalometricos ponto = listadePontos.set(15, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Me")) {
                PontosCefalometricos ponto = listadePontos.set(16, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("Ponto 6")) {
                PontosCefalometricos ponto = listadePontos.set(17, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("1")) {
                PontosCefalometricos ponto = listadePontos.set(18, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("1'")) {
                PontosCefalometricos ponto = listadePontos.set(19, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("PM1")) {
                PontosCefalometricos ponto = listadePontos.set(20, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("PM2")) {
                PontosCefalometricos ponto = listadePontos.set(21, listadePontos.get(i));
                listadePontos.set(i, ponto);
            } else if (listadePontos.get(i).getNome().equals("PMX")) {
                PontosCefalometricos ponto = listadePontos.set(22, listadePontos.get(i));
                listadePontos.set(i, ponto);
            }
        }
        
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(2).getPonto().x, listadePontos.get(2).getPonto().y); //N-A
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(3).getPonto().x, listadePontos.get(3).getPonto().y); //N-B
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(4).getPonto().x, listadePontos.get(4).getPonto().y); //N-D
        g.drawLine(listadePontos.get(1).getPonto().x, listadePontos.get(1).getPonto().y, listadePontos.get(0).getPonto().x, listadePontos.get(0).getPonto().y); //S-N
        g.drawLine(listadePontos.get(0).getPonto().x, listadePontos.get(0).getPonto().y, listadePontos.get(6).getPonto().x, listadePontos.get(6).getPonto().y); //S-Gn
        g.drawLine(listadePontos.get(10).getPonto().x, listadePontos.get(10).getPonto().y, listadePontos.get(12).getPonto().x, listadePontos.get(12).getPonto().y); //Ápice dos incisivos superiores
        g.drawLine(listadePontos.get(11).getPonto().x, listadePontos.get(11).getPonto().y, listadePontos.get(13).getPonto().x, listadePontos.get(13).getPonto().y); //Ápice dos incisivos inferiores
        g.drawLine(listadePontos.get(8).getPonto().x, listadePontos.get(8).getPonto().y, listadePontos.get(9).getPonto().x, listadePontos.get(9).getPonto().y); //Pog'-LS
        g.drawLine(listadePontos.get(5).getPonto().x, listadePontos.get(5).getPonto().y, listadePontos.get(6).getPonto().x, listadePontos.get(6).getPonto().y); //Go-Gn
        g.drawLine(listadePontos.get(22).getPonto().x, listadePontos.get(22).getPonto().y, listadePontos.get(16).getPonto().x, listadePontos.get(16).getPonto().y); //PMX - Me
        g.drawLine(listadePontos.get(20).getPonto().x, listadePontos.get(20).getPonto().y, listadePontos.get(21).getPonto().x, listadePontos.get(21).getPonto().y); //PM1 - PM2
        g.drawLine(listadePontos.get(11).getPonto().x, listadePontos.get(11).getPonto().y, listadePontos.get(17).getPonto().x, listadePontos.get(17).getPonto().y); //Ápice Inc. Inf. - Ponto 6

        
        final float dash1[] = {10.0f};
        final BasicStroke dashed = new BasicStroke(1.0f,
                                          BasicStroke.CAP_BUTT,
                                          BasicStroke.JOIN_MITER,
                                          10.0f, dash1, 0.0f);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(dashed);

        Point[] bissetriz = calcularBissetriz(listadePontos.get(20),listadePontos.get(21),listadePontos.get(22),listadePontos.get(16));
       
        g2.drawLine(bissetriz[0].x, bissetriz[0].y, bissetriz[1].x, bissetriz[1].y); //Mostrar a bissetriz
        calcularMedidas();
    }

    public ArrayList<PontosCefalometricos> carregaPontos() {
        listadePontos.add(new PontosCefalometricos(new Point(), "S"));
        listadePontos.add(new PontosCefalometricos(new Point(), "N"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Or"));
        listadePontos.add(new PontosCefalometricos(new Point(), "A"));
        listadePontos.add(new PontosCefalometricos(new Point(), "B"));
        listadePontos.add(new PontosCefalometricos(new Point(), "D"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Go"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Gn"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Pog"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Ponto 6"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Apice Inc. Sup."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Incisal Inc. Sup."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Apice Inc. Inf."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Incisal Inc. Inf."));
        listadePontos.add(new PontosCefalometricos(new Point(), "Labio Sup."));
        listadePontos.add(new PontosCefalometricos(new Point(), "MPM"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Me"));
        listadePontos.add(new PontosCefalometricos(new Point(), "Pog'"));
        listadePontos.add(new PontosCefalometricos(new Point(), "PM1"));
        listadePontos.add(new PontosCefalometricos(new Point(), "PM2"));
        listadePontos.add(new PontosCefalometricos(new Point(), "PMX"));
        listadePontos.add(new PontosCefalometricos(new Point(), "1"));
        listadePontos.add(new PontosCefalometricos(new Point(), "1'"));

        return listadePontos;
    }

    public void setListaPontos(ArrayList<PontosCefalometricos> pontos) {
        this.listadePontos = pontos;
    }

    public void calcularMedidas() {
    }

    public ArrayList<Medidas> getListaMedidas() {
        return listaMedidas;
    }

    private float[] geraEqGeral(PontosCefalometricos ponto1, PontosCefalometricos ponto2) {

        int Cx = ponto1.getPonto().x * ponto2.getPonto().y - (ponto2.getPonto().x * ponto1.getPonto().y);
        int Bx = ponto1.getPonto().x - ponto2.getPonto().x;
        int Ax = ponto1.getPonto().y - ponto2.getPonto().y;

        float[] array = {Cx, Bx, Ax};

        return array;
    }


    private Point[] calcularBissetriz(PontosCefalometricos p1, PontosCefalometricos p2, PontosCefalometricos p3, PontosCefalometricos p4) {

        float eq1[] = geraEqGeral(p1,p2);
        float eq2[] = geraEqGeral(p3,p4);

        double a1 = eq1[2];
        double b1 = eq1[1];
        double c1 = eq1[0];
        double a2 = eq2[2];
        double b2 = eq2[1];
        double c2 = eq2[0];

        double v1 = Math.sqrt(Math.pow(a1, 2) + Math.pow(b1, 2));
        double v2 = Math.sqrt(Math.pow(a2, 2) + Math.pow(b2, 2));

        double aBisse = (double) (((a1 * v2) - (a2 * v1)) / ((b1 * v2) - (b2 * v1)));
        double bBisse = (double) (((c1 * v2) - (c2 * v1)) / ((b1 * v2) - (b2 * v1)));

        Point ponto1 = new Point(0, (int) Math.round((double) (aBisse * 0 + bBisse)));
        Point ponto2 = new Point(800, (int) Math.round((double) (aBisse * 800 + bBisse)));

        Point[] bissetriz = {ponto1,ponto2};

        return bissetriz;
    }
}
