package main.recruit.qiuzhao.vmware;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int numCount = scanner.nextInt();
            int index = scanner.nextInt();
            switch (numCount) {
                case 1:
                    System.out.println(index-1);
                    break;
                case 2:
                    System.out.println(index+""+index);
                    break;
                default: {
                    if (numCount % 2 == 1) {
                        int mid = 0;
                        int base = (int) Math.pow(10, (numCount-1)/2-1);
                        boolean add = false;
                        while (index > (base * 10)) {
                            base += 10;
                            add = true;

                        }
                        int left = index;
                        if (index > (base-10)*10 && add) {
                            left = index - base*10;
                        }
                        while (left > base) {
                            left -= base;
                            mid++;
                        }
                        for (int j = 1; j < left; j++) {
                            base += 1;
                        }
                        String reverse = new StringBuilder().append(base).reverse().toString();
                        System.out.println(base+""+mid+""+reverse);
                    } else {
                        int base = (int) Math.pow(10, numCount/2-1);
                        int newBase = base;
                        int addCount = 0;
                        while (index > newBase) {
                            newBase += base;
                            addCount++;
                        }
                        index -= addCount * base;
                        int left = index;
                        if (index > newBase) {
                            left = index - newBase;
                        }
                        while (left > base / 10) {
                            newBase += (base / 10);
                            left -= (base / 10);
                        }
                        for (int j = 1; j < left; j++) {
                            newBase += 1;
                        }
                        String reverse = new StringBuilder().append(newBase).reverse().toString();
                        System.out.println(newBase+reverse);
                    }

                }

            }
        }
    }

}
