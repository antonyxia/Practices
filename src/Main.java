import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write your code here
        guessing();
    }

//    public static void sorting(){
//
//        int[] paixu = {2,5,3,4,1};
//
//        for (int i = 0; i < paixu.length; i++){
//
//            int minidx = i;
//
//            for (int j = i + 1; j < paixu.length; j++){
//
//                if(paixu[minidx] > paixu[j]){
//                    minidx = j;
//                }
//
//            }
//
//            if (minidx != i){
//
//                int t = paixu[i];
//                paixu[i] = paixu[minidx];
//                paixu[minidx] = t;
//
//            }
//
//
//        }
//
//        for (int i = 0; i < paixu.length; i++)
//            System.out.print(paixu[i]+",");
//    }

    public static void guessing() {

        int[] answer = new int[4];  //答案数组

        for (int i = 0; i <= 3; i++) { //从0位开始赋值

            answer[i] = (int) (9 * Math.random() + 1); //赋值随机数1-9

            if (i > 0) { //检查索引位是否大于0

                for (int j = 1; j <= i; j++) {   //从1索引位开始逐个比较重复数值

                    for (int k = 0; k < 10; k++) { //循环检查赋值重复，重复则重新赋值，直到不重复

                        if (answer[i] == answer[j - 1]) { //如果当前索引位数字等于前一位
                            answer[i] = (int) (9 * Math.random() + 1); //重新赋值
                            k = k - 1; //无限循环
                        } else k = 10; //跳出循环

                    }

                }

            }


        }

//        for (int tt = 0; tt < answer.length; tt++) //Debug打印数组结果
//            System.out.print(answer[tt]);

        int[] guess = new int[4]; //用户输入数组

        int maxtime = 7;

        for (int i = 0; i < maxtime; i++) {   //maxtime次输入机会

            int typein;

            int check;

            do {

                check = 0;

                System.out.println("输入四位数字：");
                Scanner scanner = new Scanner(System.in);
                typein = scanner.nextInt(); //初始化并输入数字

                if (typein < 1234 || typein > 9876) {
                    System.out.println("输入数字有误，请重新输入！");
                    check = 1;
                }

            } while (check == 1);


            guess[0] = typein / 1000;  //获取首位数字
            guess[1] = (typein - guess[0] * 1000) / 100;  //获取第二位数字
            guess[2] = (typein - guess[0] * 1000 - guess[1] * 100) / 10;  //获取第三位数字
            guess[3] = (typein - guess[0] * 1000 - guess[1] * 100 - guess[2] * 10);  //获取末尾数字

//            for (int tt = 0; tt < guess.length; tt++) //Debug打印数组结果
//                System.out.print(guess[tt] + " ");

            int a = 0, b = 0;

            for (int j = 0; j <= 3; j++) {   //检查数位匹配情况

                for (int k = 0; k <= 3; k++) {

                    if (guess[j] == answer[k]) {

                        if (j == k) a++;
                        else b++;

                    }

                    if (a == 4) {
                        System.out.println("恭喜你猜对啦！");
                        System.exit(0);
                    }

                }


            }

            System.out.println(a + "A" + b + "B\n"+"还有"+(maxtime-i-1)+"次机会。\n");


        }

        System.out.println("对不起，您没有猜对，正确答案是：");

        for (int tt = 0; tt < answer.length; tt++) //打印答案
            System.out.print(answer[tt]);

    }

}

