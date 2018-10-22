package study;

public class MapStudyKey {

    private int value;


    public MapStudyKey() {
    }

    public MapStudyKey(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int a = 1;
        if(value == 1 || value == 2){
            return a;
        }else{
            return value;
        }
    }



}
