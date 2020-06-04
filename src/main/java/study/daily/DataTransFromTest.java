package study.daily;

public class DataTransFromTest {

    static class TestObj{
        private String name ;

        public TestObj(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        TestObj obj = new TestObj("lj");;

        tranFormTest(obj);
        
        System.out.println(obj==null);
        System.out.println(obj.getName());
        System.out.println("123:");
    }

    private static void tranFormTest(TestObj obj) {
//        obj = new TestObj();
        obj.setName("haha");
        System.out.println("in");
    }
}
