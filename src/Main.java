import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer arr[] = new Integer[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập min: ");
        int min = sc.nextInt();
        System.out.println("Nhập max: ");
        int max = sc.nextInt();
        while (min>max){
            System.err.println("min<max");
            System.out.println("Nhập lại min :");
            min = sc.nextInt();
            System.out.println("Nhập lại max: ");
            max = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        int closestGreaterIndex = -1;
        int closestLesserIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && closestGreaterIndex == -1) {
                closestGreaterIndex = i;
            }
            if (arr[i] <= max) {
                closestLesserIndex = i;
            }
            if (closestGreaterIndex != -1 && closestLesserIndex != -1) {
                break;
            }
        }

        if (closestGreaterIndex != -1 && closestLesserIndex != -1) {
            for (int i = closestGreaterIndex; i <= closestLesserIndex; i++) {
                list.add(arr[i]);
            }
        }
        // Tìm vị trí số lớn hơn min gần nhất
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                closestGreaterIndex = i;
                break;
            }
        }

        if (closestGreaterIndex != -1) {
            int closestGreaterValue = arr[closestGreaterIndex];
            System.out.println("Số lớn hơn " + min + " gần nhất: " + closestGreaterValue);
        } else {
            System.out.println("Không tìm thấy số lớn hơn " + min);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < max) {
                closestLesserIndex = i;
                break;
            }
        }

        if (closestLesserIndex != -1) {
            int closestLesserValue = arr[closestLesserIndex];
            System.out.println("Số nhỏ hơn " + max + " gần nhất: " + closestLesserValue);
        } else {
            System.out.println("Không tìm thấy số nhỏ hơn " + max);
        }

        System.out.println("Số lượng số tìm thấy: " + list.size());
        System.out.println("Thông tin chi tiết về các số tìm thấy: " + list);
    }
}