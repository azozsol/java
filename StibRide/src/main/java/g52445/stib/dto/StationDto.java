package g52445.stib.dto;

public class StationDto extends Dto<Integer> {
    private String name;

    public StationDto(Integer key, String name) {
        super(key);
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Station name : " + name + ", id : " +super.key;
    }
}
