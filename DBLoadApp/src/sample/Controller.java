package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.sql.*;

public class Controller {
    public TextField NameEd;
    public TextField AgeEd;
    public TextField GenderEd;
    public Button getBtn;
    public Button sendBtn;
    public Button clearBtn;
    public TableColumn<Data, String> nameCol;
    public TableColumn<Data, Integer> ageCol;
    public TableColumn<Data, String> genderCol;
    public TableView<Data> tableView;
    private ResultSet rs;

    private Connection connection;
    private Statement statement;

    void handleWindowShown(WindowEvent event) {
        try {
            connect();
            refresh();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws SQLException {
        final String url = "jdbc:mysql://localhost:3306/test";
        final String user = "root";
        final String password = "792051";

        try {
            new com.mysql.jdbc.Driver();
        } catch (Exception e) {
            System.err.println("Driver not found");
        }

        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }


    private void disconnect() throws SQLException {
        try {
        } finally {
            if (!connection.isClosed())
                connection.close();

            if (!statement.isClosed())
                statement.close();

            if (!rs.isClosed())
                rs.close();
        }
    }

    public void loadData(ActionEvent actionEvent) {
        try {
            connect();
            refresh();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void sendData(ActionEvent actionEvent) {
        String name = " ";
        Integer age = 0;
        String gender = " ";
        try {
            if (NameEd.getText().length() != 0)
                name = NameEd.getText();

            if (AgeEd.getText().length() != 0 ) {
                AgeEd.setBorder(Border.EMPTY);
                age = Integer.parseInt(AgeEd.getText());
                if(age > 130 || age <= 0)
                    throw new NumberFormatException("Invalid age value");
            }

            if (GenderEd.getText().length() != 0)
                gender = GenderEd.getText();

            connect();
            statement.execute("INSERT INTO testable (Name, Age, Gender) VALUES" +
                    " ('" + name + "', '" + age + "', '" + gender + "');");
            refresh();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            AgeEd.setBorder(new Border(new BorderStroke(Color.rgb(255, 0, 50),
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

            System.out.println(e.getClass());
        }


    }

    private void refresh() throws SQLException {
        ObservableList<Data> list = FXCollections.observableArrayList();

        Data element;
        if (statement.isClosed())
            connect();

        rs = statement.executeQuery("SELECT name,age,gender FROM testable;");

        while (rs.next()) {
            element = new Data(rs.getString(1), rs.getInt(2), rs.getString(3));
            list.add(element);
        }

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tableView.setItems(list);
    }

    public void clear(ActionEvent actionEvent) {
        try {
            connect();
            statement.execute("DELETE FROM testable;");
            refresh();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}