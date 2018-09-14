package study.mode.stack;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<Class<?>,Object>();

    public <T> void putFavorites(Class<T> type,T instance){
        favorites.put(type,type.cast(instance));
    }


    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorites.get(type));
    }



    public static void main(String[] args){
        Favorites favorites = new Favorites();
        favorites.putFavorites(String.class,"LJLJ");
        favorites.putFavorites(String.class,"shuxiushuxiu");
        System.out.println(favorites.toString());
    }
}
