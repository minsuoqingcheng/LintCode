package main.recruit.internship.huawei;

public class Test {

    public static void main(String[] args) {
        String a = "==                 +";
        String[] split = a.split(" ");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i] + ":" + split[i].length());
        }
    }

}
