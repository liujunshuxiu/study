package study.daily;

import com.alibaba.fastjson.JSONArray;
import study.anno.Member;
import study.concurrence.product.Consumer;

import java.util.Collections;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        String str = "+18188698631";
        String str1 = "jun.liu";
        String str2 = "df";

        String regex = "^[0-9a-zA-Z\\x{3400}-\\x{4db5}\\x{4e00}-\\x{9fa5}& ，.（）(),-_]{1,32}$";
        String regex1 = "^[a-z ._A-Z-]{1,32}$";
        String regexRealNameSingle = "^[0-9a-zA-Z\\x{3400}-\\x{4db5}\\x{4e00}-\\x{9fa5}& ，.（）(),-_]$";

        System.out.println(str.matches(regex));

        System.out.println(str.length());
        for(int i=0;i<str.length();i++){
            String subStr = str.substring(i, i+1);
            System.out.println("subStr:"+subStr+",result："+subStr.matches(regexRealNameSingle));
        }


//        System.out.println(str.length());
//        System.out.println(str.matches(regex));
//        System.out.println(str1.matches(regex1));
//        System.out.println(str2.matches(regexRealNameSingle));

//       System.out.println(JSONArray.toJSONString(Collections.emptyList()));
//
//
//       List<Member> res = JSONArray.parseArray(String.valueOf("[]"), Member.class);
//       System.out.println(res);
    }


}
