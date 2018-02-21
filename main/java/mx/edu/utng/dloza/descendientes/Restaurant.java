package mx.edu.utng.dloza.descendientes;

/**
 * Created by Daniel on 15/02/2018.
 */

public class Restaurant {
    private int imageId;  //referencia a un drawable
    private String name;
    private String location;


    public Restaurant(int imageId, String name, String location){
        this.imageId=imageId;
        this.name=name;
        this.location=location;

    }

    public Restaurant(){
        this(R.mipmap.ic_launcher_round, "unamed", "unlocation");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }


}
