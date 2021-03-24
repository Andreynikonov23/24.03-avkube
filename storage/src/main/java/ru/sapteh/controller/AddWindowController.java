package ru.sapteh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoipml.RadioElementsImpl;
import ru.sapteh.model.RadioElements;

public class AddWindowController {

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label manufacturerLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label costLabel;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField manufacturerText;

    @FXML
    private TextField descriptionText;

    @FXML
    private TextField quantityText;

    @FXML
    private TextField costText;

    @FXML
    private Button buttonOK;

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @FXML
    public void onActionButtonOK(ActionEvent event) {
        RadioElements radioElements = new RadioElements();
        radioElements.setName(nameText.getText());
        radioElements.setManufacturer(manufacturerText.getText());
        radioElements.setDescription(descriptionText.getText());
        radioElements.setQuantity(Integer.parseInt(quantityText.getText()));
        radioElements.setCost(costText.getText());

        DAO<RadioElements, Integer> radioElementsDAO = new RadioElementsImpl(factory);
        radioElementsDAO.create(radioElements);
    }

}