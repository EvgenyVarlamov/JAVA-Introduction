public class Task01 {

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        int sum1 = 0;
        int sum2 = 0;
        String sum = "";
        String index = "Такого индекса нет";
        for (int i = 0; i < nums.length - 1; i++) {
            sum1 = sum1 + nums[i];
            for (int j = 1; j < nums.length; j++) {
                sum2 = sum2 + nums[nums.length - j];
                if (sum1 == sum2 && i < nums.length - j) {
                    int temp = (i + nums.length - j) / 2;
                    sum = "Сумма - " + sum2;
                    index = "Индекс - " + temp;
                }
            }
            sum2 = 0;
        }
        System.out.println(sum);
        System.out.println(index);
    }
}
