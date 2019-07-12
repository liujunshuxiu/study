package study.daily;

public class BitTest {


    /**
     * Bit0 震动报警
     * Bit1 平安报
     * Bit2 撤防
     * Bit3 布防
     * Bit4 倾斜报警
     * Bit5 传感器故障
     * Bit6 烟雾报警
     * Bit7 保留
     */
//    private static final String[] smoke = new String[]{"震动报警", "平安报", "撤防", "布防", "倾斜报警", "传感器故障", "烟雾报警", "保留"};
    private static final String[] smoke = new String[]{"保留","烟雾报警","传感器故障","倾斜报警","布防","撤防","平安报","震动报警"};


    public static void main(String[] args) {
//        String warningType = "01100000";
        String warningType = "00000010";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < warningType.length() - 1 ; i++) {
            if (i != 6 && warningType.charAt(i) == 49) {
                sb.append(smoke[i]).append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
