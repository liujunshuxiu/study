package study;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.List;

public class mainTest {



    private static void deal(int a,List<Integer> list){
        a = 1;
        List<Integer>  newLIst = list;


        newLIst.add(0,5);
        newLIst.add(1,6);
        newLIst.add(2,7);
    }

    private static void merge(int[] nums1,int m ,int[] nums2,int n){
        int index1 = m - 1, index2 = n - 1 ;
        int indexMerge = m + n - 1;
        while(index1 >= 0 || index2 >= 0){
            if(index1 < 0){
                nums1[indexMerge --] = nums2[index2 --];
            }else if(index2 < 0){
                nums1[indexMerge --] = nums1[index1 --];
            }else if(nums1[index1] > nums2[index2]){
                nums1[indexMerge --] = nums1[index1 --];
            }else {
                nums1[indexMerge --] = nums2[index2 --];
            }
        }
    }

    public static String parsePassword(String papssword) {
        return isCorrectPassword(papssword) ? papssword : "dc483e80a7a0bd9ef71d8cf973673924";
    }

    public static boolean isCorrectPassword(String papssword) {
        if (papssword == null) {
            return false;
        }
        return papssword.length() >= 6 && papssword.length() < 64;
    }

    private final static String regexRealName = "^[0-9a-zA-Z\\x{4e00}-\\x{9fa5}& ._（）(),-]{1,32}$";

    public static void main(String[] args){
//        String str = "afdd0b4ad2ec172c586e2150770fbf9e";
//        System.out.println(parsePassword(str));
//
//        String str2= "哒哒会员_qMvJ5y";
//        System.out.println(str2.matches(regexRealName));

//        PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();
//        PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();

        String swissNumberStr = "+9647518094704";
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

        Phonenumber.PhoneNumber swissNumberProto = null;
        try {
            swissNumberProto = phoneUtil.parse(swissNumberStr, null);
            System.out.println(swissNumberProto);
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }


//        String carrierZh = "";
//        carrierZh += geocoder.getDescriptionForNumber(swissNumberProto, Locale.CHINESE);
//
//        System.out.println("carrierZh:"+ carrierZh);
//
//        String carrierEn = carrierMapper.getNameForNumber(swissNumberProto, Locale.ENGLISH);
//        System.out.println("carrierEn:"+ carrierEn);

//        String str = "军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军军";
//        String str1 = "jun.liu";
//
//        String regex = "^[0-9a-zA-Z\\x{3400}-\\x{4db5}\\x{4e00}-\\x{9fa5}& ，.（）(),-_]{1,32}$";
//        String regex1 = "^[a-z ._A-Z-]{1,32}$";
//        System.out.println(str.length());
//        System.out.println(str.matches(regex));
//        System.out.println(str1.matches(regex1));


//        String str = "+099118690333121";
//        System.out.println(str.substring(1,str.length()-11));
//        System.out.println(str.substring(str.length()-11));


//        String str = "Uid 4575 has existed!";
//        System.out.println(str.contains("has existed"));
//
//        List<Integer> list = new LinkedList<>();
//        list.add(537);
//        list.add(23);
//        System.out.println(StringUtils.join(list, ","));

//        int a = 0;
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
//        deal(a,list);
//        System.out.println(a);
//        System.out.println(list);
        // 取出明天日期
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DATE, 1);
//        Date nextDate = calendar.getTime();
//        // 取明天是星期几
//        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE",Locale.CHINESE);
//        String week = dateFm.format(nextDate);
//
//        System.out.printf("week:%s",week);
//
//
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
//        list.sort((i1,i2) -> i1.compareTo(i2));
//
//        String str = "";
//        System.out.println("长度:"+str.length());

//        BigDecimal bg = new BigDecimal(-12.5).setScale(0, RoundingMode.UP);
//        System.out.println("bg:"+bg);

//        BigDecimal bignum1 = new BigDecimal("19");
//        BigDecimal bignum2 = new BigDecimal("5");
//        BigDecimal bignum3 = null;
//        //除法
//        bignum3 = bignum1.divide(bignum2,0,BigDecimal.ROUND_DOWN);
//        System.out.println("除  是：" + bignum3);


//            int[] nums1 = {1,2,3,0,0,0};
//            int[] nums2 = {4,5,6};
//            int m = 3,n = 3;
//            merge(nums1,m,nums2, n);
//
//            for(int i : nums1){
//                System.out.println(i);
//            }

//        int i = 10 ;
//        System.out.println("i/2="+i/2 );
//        i = 10 >>1;
//        System.out.println("i>>1="+ i);
        
//        String str1 = "lj";
//        String str2 = "lj";
//        System.out.println(str1 == str2);


//        String str1 = new String("lj");
//        String str2 = new String("lj");
//        System.out.println(str1 == str2);


//        int a = 1;
//        int b = 5;
//
//        int c = b > a ? b -a : a;
//
//        System.out.println(c);

//        Map<String,Integer> companyInNumMap = new HashMap<>();
//        Integer num = null;
//        int x = 1;
//        companyInNumMap.put("test1",x);
//
//        if ((num = companyInNumMap.get("test")) == null) {
//            companyInNumMap.put("test", new Integer(1));
//        } else {
////            companyInNumMap.get("test") + 1;
////            Integer.sum(num,1) ;
//
//            num ++;
//        }
//        if ((num = companyInNumMap.get("test")) == null) {
//            companyInNumMap.put("test", new Integer(1));
//        } else {
////            companyInNumMap.get("test") + 1;
////            Integer.sum(num,1) ;
////            companyInNumMap.put("test", ++ num );
//            ++ num  ;
//        }
//        System.out.println(companyInNumMap);
//        ++x;
//        System.out.println(companyInNumMap);
    }



}
