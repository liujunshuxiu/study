package study.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuavaBasicUtiliesTest {

    public static class User {
        private String username;
        private int age;
        private String password;
        public User() {
        }
        public User(String username, int age) {
            super();
            this.username = username;
            this.age = age;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {



        //guava
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // returns true
        possible.get(); // returns 5
        System.out.println(possible);


        // Returns "MyObject{x=1}"
        System.out.println(MoreObjects.toStringHelper("MyObject")
                .add("x", 1)
                .toString());


        //排序
        User user1 = new User();
        user1.setUsername("zhagnsan");
        user1.setAge(22);
        user1.setPassword("123");
        User user2 = new User();
        user2.setUsername("aisi");
        user2.setAge(2);
        user2.setPassword("123");
        User user3 = new User();
        user3.setUsername("wangwu");
        user3.setAge(56);
        user3.setPassword("123");
        List<User> us = new ArrayList<User>();
        us.add(user1);
        us.add(user2);
        us.add(user3);

//        us.sort((User o1, User o2) -> o1.getAge() - o2.getAge());
//        us.forEach(user -> System.out.println(user.getUsername()+"..."+user.getAge()+"..."+user.getPassword()));

        //创建ordering实例，并编写排序规则
        Ordering<User> ordering = new Ordering<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Ints.compare(u1.getAge(), u2.getAge());
            }
        };
        Collections.sort(us, ordering);
        for (User user : us) {
            System.out.println(user.getUsername()+"..."+user.getAge()+"..."+user.getPassword());
        }

    }
}
