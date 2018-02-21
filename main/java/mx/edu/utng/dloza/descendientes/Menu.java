package mx.edu.utng.dloza.descendientes;

/**
 * Created by Daniel on 13/02/2018.
 */

public class Menu {
    private int imageId;
    private String name;

    public Menu(int imageId,
                      String name){
        this.imageId = imageId;
        this.name = name;


    }
    public Menu(){
        this(R.mipmap.ic_launcher_round,
                "unamed");
    }
    public int getImageId(){
        return imageId;
    }

    public String getName() {
        return name;
    }

}


