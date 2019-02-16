package main.LeetCode.easy_to.question168;

public class Excel_Sheet_Column_Title {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }


    public static void main(String[] args) {
        Excel_Sheet_Column_Title test = new Excel_Sheet_Column_Title();
        System.out.println(test.convertToTitle(703));
    }
}
