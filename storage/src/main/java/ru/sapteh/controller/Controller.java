package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoipml.RadioElementsImpl;
import ru.sapteh.model.RadioElements;

import java.io.IOException;
import java.util.List;

public class Controller {

    private final ObservableList<RadioElements> radioList = FXCollections.observableArrayList();

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private RadioElements selectedItem;

    @FXML
    private TableView<RadioElements> mainTableView;

    @FXML
    private TableColumn<RadioElements, Integer> idColumn;

    @FXML
    private TableColumn<RadioElements, String> nameColumn;

    @FXML
    private TableColumn<RadioElements, String> manufacturerColumn;

    @FXML
    private TableColumn<RadioElements, String> descriptionColumn;

    @FXML
    private TableColumn<RadioElements, Integer> quantityColumn;

    @FXML
    private TableColumn<RadioElements, String> costColumn;

    @FXML
    private Button newButton;


//    Вывод данных из бд в TableView
    @FXML
    public void initialize(){
            DAO<RadioElements, Integer> radioElementsDAO = new RadioElementsImpl(factory);
            List<RadioElements> list = radioElementsDAO.findByAll();
            radioList.addAll(list);

            idColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getId()));
            nameColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getName()));
            manufacturerColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getManufacturer()));
            descriptionColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDescription()));
            quantityColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getQuantity()));
            costColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getCost()));
            mainTableView.setItems(radioList);
    }

//    Открытие окна при нажатии на кнопку New
    @FXML
    public void onActionNewButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddWindow.fxml"));
        stage.setTitle("Add object");
        stage.setScene(new Scene(root));
        stage.show();
    }

//  Удаление данных из таблицы
    @FXML
    public void onActionButtonDelete(ActionEvent event) {
        RadioElements selectedItems = mainTableView.getSelectionModel().getSelectedItem();
        mainTableView.getItems().remove(selectedItems);
        DAO<RadioElements, Integer> radioElementsDAO = new RadioElementsImpl(factory);
        radioElementsDAO.delete(selectedItems);
    }
}