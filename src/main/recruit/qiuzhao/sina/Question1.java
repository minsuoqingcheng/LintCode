package main.recruit.qiuzhao.sina;

public class Question1 {

    public String getMinVersion(String[] list) {
        // 在这里编写代码
        String base = list[0];
        String[] data = base.split("\\.");
        for (int i = 1; i < list.length; i++) {
            String version = list[i];
            String[] split = version.split("\\.");
            if (Integer.valueOf(data[0]) < Integer.valueOf(split[0])) {
                continue;
            } else if (Integer.valueOf(data[0]).equals(Integer.valueOf(split[0]))){
                int m = 1;
                int n = 1;
                boolean less = true;
                while (m < data.length && n < split.length) {
                    if (Integer.valueOf(data[m]) > Integer.valueOf(data[n])) {
                        base = version;
                        data = split;
                        less = false;
                        break;
                    }
                    m++;
                    n++;
                }
                if (less && data.length > split.length) {
                    base = version;
                    data = split;
                }
            } else {
                base = version;
                data = split;

            }
        }

        return base;
    }


    public static void main(String[] args) {
        Question1 question1 = new Question1();
        System.out.println(question1.getMinVersion(new String[]{"3", "4.3.5.4", "2.10.3", "2.4"}));
    }
}
