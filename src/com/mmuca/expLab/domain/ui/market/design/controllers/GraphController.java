package com.mmuca.expLab.domain.ui.market.design.controllers;

import com.mmuca.expLab.domain.ui.market.design.views.GraphPanel;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GraphController {

    private GraphPanel view;

    public GraphController(GraphPanel view){
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        view.addComponentListener(new GraphListener());
    }

    private class GraphListener implements ComponentListener{
        @Override
        public void componentResized(ComponentEvent e) {
           if (e.getComponent().getWidth() > 0 && e.getComponent().getHeight() >0)
                view.refresh();
        }
        @Override
        public void componentMoved(ComponentEvent e) {}
        @Override
        public void componentShown(ComponentEvent e) {}
        @Override
        public void componentHidden(ComponentEvent e) {}
    }
}
