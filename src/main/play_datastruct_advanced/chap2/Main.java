package main.play_datastruct_advanced.chap2;

public class Main {

    public static void main(String[] args) {

        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }

}
