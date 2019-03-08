package study;

import java.lang.reflect.Field;

public class MapStudyKey {

    private int value;

    private String key;

    public MapStudyKey() {
    }

    public MapStudyKey(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int a = 1;
        if(value < 20){
            return a;
        }else{
            return value;
        }
    }


    public static void main(String[] args){
        Field[] fields = MapStudyKey.class.getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        System.out.println("fieldsSize:"+fields);
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getName());
        }
    }

}
