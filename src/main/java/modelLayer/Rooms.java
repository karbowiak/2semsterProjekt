package modelLayer;

import tools.databaseQuery;

public class Rooms {
    databaseQuery db = new databaseQuery();

    private int roomID; // the room ID
    private String roomDescription; // the room description
    private int status; // 0 free, 1 taken
    private float discount; // the discount applied to this room by default (if it's a haunted room for example)
    private float pricePerNight; // the price of the room pr. night


    //databaseQuery dbQ = new databaseQuery();
    //Map<String,String> parameters = new QuickHash(":name", "1", ":value", "palle");
    //dbQ.dbQuery("INSERT INTO test (name, value) VALUES (:name, :value)", parameters);
}
