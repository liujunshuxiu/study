package study.daily;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

public class JsonTest {


    private static String getString(Object obj) {
        String result = null;
        if (obj instanceof String) {
            result = (String) obj;
        } else if (obj instanceof Integer
                ||
                obj instanceof Boolean) {
            result = String.valueOf(obj);
        } else if (obj instanceof Double) {
            result = String.valueOf(obj);
        } else if (obj instanceof BigDecimal) {
            result = String.valueOf(obj);
        }
        return result;
    }


    public static void main(String[] args) {
        String text = "{\"code\":0,\"msg\":\"\",\"data\":{\"name\":\"8#右\",\"weight\":0.0,\"height\":0.0,\"floor\":0.0,\"people_num\":0.0,\"speed\":0.0,\"wind_speed\":0,\"windLevel\":0,\"dip_angle_X\":0.0,\"dip_angle_Y\":0.0,\"safe_weight\":0.0,\"height_max\":0.0,\"limited_person\":0,\"data_time\":\"2019-07-06 15:37:33\"}}";

        JSONObject jsonObject = JSON.parseObject(text);
        JSONObject jsonObj = (JSONObject) jsonObject.get("data");

        String weight = getString(jsonObj.get("weight"));
        String height = getString(jsonObj.get("height"));

        System.out.println("weight:"+weight);
        System.out.println("height:"+height);

        String s = "系统异常!!";
        JSONObject.parseObject(s);
    }
}
