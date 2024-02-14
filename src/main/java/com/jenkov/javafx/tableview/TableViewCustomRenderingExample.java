package com.jenkov.javafx.tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewCustomRenderingExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {

        TableView<Customer> tableView = new TableView<>();

        TableColumn<Customer, String> customerColumn = getCustomerStringTableColumn();

        tableView.getColumns().add(customerColumn);

        tableView.getItems().add(new Customer("007", "Jane", "Deer"));
        tableView.getItems().add(new Customer("006", "John", "Doe"));
        tableView.getItems().add(new Customer("008", "Mack", "Alamo"));

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX TableView Example");

        primaryStage.show();
    }

    private static TableColumn<Customer, String> getCustomerStringTableColumn() {
        TableColumn<Customer, String> customerColumn = new TableColumn<>("Customer");

        customerColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customerColumn.setCellFactory((tableColumn) -> {
            return new TableCell<Customer, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    this.setText(null);
                    this.setGraphic(null);

                    if(!empty){
                        this.setText(item.toUpperCase());
                    }
                }
            };
        });
        return customerColumn;
    }
}
