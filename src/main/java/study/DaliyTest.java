package study;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DaliyTest {

    public static int parseDate2Int(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year * 10000 + month * 100 + day;
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Long minute = 10L;
        LocalDateTime time = LocalDateTime.now().minusMinutes(minute);
        System.out.println(time);
    }
}
