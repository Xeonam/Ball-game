package Controller;

import Model.PlayerDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import org.tinylog.Logger;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LeaderboardController implements javafx.fxml.Initializable{

    @FXML
    AnchorPane sceneLeaderboard;

    @FXML
    private TableView<PlayerDatabase> leaderboard;

    @FXML
    private TableColumn<PlayerDatabase, SimpleStringProperty> name;

    @FXML
    private TableColumn<PlayerDatabase, SimpleIntegerProperty> playerSteps;

    @FXML
    private TableColumn<PlayerDatabase, SimpleStringProperty> created;

    ObservableList<PlayerDatabase> playerInfoList = getPlayerInfoList();

    public LeaderboardController() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //CreateLeaderboard.IsLeaderboardFileExists();
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        playerSteps.setCellValueFactory(new PropertyValueFactory<>("playerSteps"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));
        leaderboard.setItems(playerInfoList);
    }


    @FXML
    private void onMenuButton(ActionEvent event) throws IOException {
        Logger.debug("Clicked on: " + ((Button) event.getSource()).getText());
        new SceneSwitch(sceneLeaderboard, "/menu.fxml");
    }

    public ObservableList<PlayerDatabase> getPlayerInfoList() throws IOException {
        playerInfoList = FXCollections.observableArrayList();

        Gson gson = new GsonBuilder().create();

        // Read the JSON file into a 2D array of Blocks
        InputStream inputStream = new FileInputStream("leaderboard.json");

        // Create a Reader from the input stream
        Reader reader = new InputStreamReader(inputStream);
        PlayerDatabase[] playerDatabaseArray = gson.fromJson(reader, PlayerDatabase[].class);

        playerInfoList.addAll(Arrays.asList(playerDatabaseArray));

        return playerInfoList;
    }

}
