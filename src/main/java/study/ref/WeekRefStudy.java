package study.ref;

import java.lang.ref.WeakReference;

public class WeekRefStudy {

    static WeakReference<User> weakRef = null;

    public static void main(String[] args) {
        // user 是 "对象user" 的强引用
        User user = new User("123", "mitre", 21);
        // weakRef 是 "对象user" 的弱引用
        weakRef = new WeakReference<>(user);

        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + weakRef.get());
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + user);

        System.out.println("---GC---");
        System.gc();
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + weakRef.get());
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + user);

        System.out.println("\n移除user对象持有的强引用");
        user = null;
        System.out.println("---GC---");
        System.gc();
        System.out.println("只有 弱引用 指向的内存区域：" + weakRef.get());
    }

}
