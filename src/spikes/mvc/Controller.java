package spikes.mvc;


import javax.swing.*;
import javax.swing.event.DocumentEvent;

public class Controller{

    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        view.getNumGoodsTextField().getDocument().addDocumentListener(new DocumentListener(view.getNumGoodsTextField(),new UpdateNumGoods()));
        view.getMinNumGoodsPerLevelTextField().getDocument().addDocumentListener(new DocumentListener(view.getMinNumGoodsPerLevelTextField(),new UpdateMinGoodsPerLevel()));
        view.getNumLevelsTextField().getDocument().addDocumentListener(new DocumentListener(view.getNumLevelsTextField(),new UpdateNumLevels()));
        view.getNumIOTTextField().getDocument().addDocumentListener(new DocumentListener(view.getNumIOTTextField(),new UpdateNumIOT()));
    }


    private class DocumentListener implements javax.swing.event.DocumentListener{

        private JTextField textField;
        private UpdateModelCommand command;

        public DocumentListener(JTextField textField, UpdateModelCommand command){
            this.textField = textField;
            this.command = command;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
           if (notEmptyField()) command.update(textField.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (notEmptyField()) command.update(textField.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

        private boolean notEmptyField() {
            return !textField.getText().isEmpty();
        }
    }

    private interface UpdateModelCommand{
        public void update(Object newValue);
    }

    private class UpdateNumGoods implements UpdateModelCommand{
        @Override
        public void update(Object newValue) {
            model.setNumGoods((String) newValue);
        }
    }

    private class UpdateMinGoodsPerLevel implements UpdateModelCommand {
        @Override
        public void update(Object newValue) {
            model.setMinGoodsPerLevel((String) newValue);
        }
    }

    private class UpdateNumLevels implements UpdateModelCommand{
        @Override
        public void update(Object newValue) {
            model.setNumLevels((String) newValue);
        }
    }

    private class UpdateNumIOT implements UpdateModelCommand{
        @Override
        public void update(Object newValue) {
            model.setNumIOT((String) newValue);

        }
    }
}
