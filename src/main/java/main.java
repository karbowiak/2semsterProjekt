import tools.databaseQuery;

public class main {
    public static void main(String[] args) {
        // Init the db
        new databaseQuery();

        // Run the UI
        startUI ui = new startUI();
        ui.start();
    }
}