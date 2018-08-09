package com.LJ.study.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OneTest {



    public static void main(String[] args){
        List<String> alist = new ArrayList<String>();
        alist.add("ljlj");
        Optional<List<String>> securityCheckRecAndRevVOsOp = Optional.ofNullable(alist);
        Optional<Boolean> resultOp = securityCheckRecAndRevVOsOp.map(vos -> {

            for(String vo : vos){
                List<String> details = null;
                details.add(vo);
                if(details != null && details.size() > 0){
                    return  true;
                }
            }

            return  false;
        });


        Object o = resultOp.get();
        System.out.println(o.toString());


        File file = new File("d://a/b");
        file.listFiles();
    }

}
