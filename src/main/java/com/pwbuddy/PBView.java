package com.pwbuddy;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * @author Jakob Klepp
 * @since 2013-04-09
 */
public class PBView extends JPanel{
    private PBModel m;

    private GridBagLayout gridBag;
    private JPanel content;
    private JScrollPane scrollPane;

    public PBView(PBModel m){
        super(new GridLayout(1, 1));
        this.m = m;

        this.gridBag = new GridBagLayout();
        this.content = new JPanel(gridBag);
        this.content.setBackground(Color.CYAN);

        this.scrollPane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Blub");
        this.scrollPane.removeAll();
        int width = this.getWidth();

        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(1,1,1,1); //Abstand zwischen den Elementen, (oben, unten, links, rechts)
        con.gridx = 0;
        con.gridy = 0;

        //Über alle categories iterieren und sie dem scrollPane hinzufügen
        for(PBCategory category : m.getCategories()){
            //Grösse des category Headers anpassen
            Dimension d = new Dimension(width, category.getView().getHeight());
            category.getView().setPreferredSize(d);

            //category zum scrollPane hinzufügen
            this.content.add(category.getView(), con);
            con.gridy ++;

            //Wenn eine categorie geöffnet ist soll auch ihr Inhalt gezeichnet werden
            if(category.isOpened()){
                for(Iterator<PBDataSet> dataSetIterator = category.iterator(); dataSetIterator.hasNext();){
                    PBDataSet dataSet = dataSetIterator.next();

                    //Größe des dataset headers anpassen
                    d = new Dimension(width, dataSet.getView().getHeight());
                    dataSet.getView().setPreferredSize(d);

                    //zum scrollPane hinzufügen
                    this.content.add(dataSet.getView(), con);

                    con.gridy += dataSet.getGridHeight();
                }
            }
        }
        this.scrollPane.repaint();
    }
}
