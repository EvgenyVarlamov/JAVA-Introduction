public class Task02 {
    public static void main(String[] args) {
        String[] array = {"aabb", "aabbb", "aaaabb"};
        PrefixFind(array);
    }

    static void PrefixFind(String[] arr) {
        int count = 0;
        int[] size = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[0].charAt(0) == arr[i].charAt(j)) count++;
                else break;
            }
            size[i] = count;
            count = 0;
        }
        int prefix = size[0];
        for (int i = 0; i < size.length; i++) {
            if (prefix > size[i]) prefix = size[i];
        }
        String res = "";
        for (int i = 0; i < prefix; i++) {
            res = res + arr[0].charAt(0);
        }
        System.out.println(res);
    }
}
