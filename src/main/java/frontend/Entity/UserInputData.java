package frontend.Entity;

import frontend.Enum.Sectors;
import frontend.Enum.Town;
import frontend.Enum.Village;

public class UserInputData {
    static private Town town;
    static private Village village;
    static private Sectors sectors;

    public static Town getTown(){
        return town;
    }
    public static Village getVillage(){
        return village;
    }
    public static Sectors getSectors(){
        return sectors;
    }
    public static void setTown(Town input_town){
        town = input_town;
    }
    public static void setVillage(Village input_village){
        village = input_village;
    }
    public static void setSectors(Sectors input_sectors){
        sectors = input_sectors;
    }
}
