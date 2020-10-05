package Lv4;

class Drawer {
    private final int R, D;
    private final short[][] initialData;

    Drawer(int R, short[][] data) {
        this.R = R;
        this.initialData = data;
        D = R * 2;
    }

    void drawFunction() {
        short[][] middleData = calculateIntegralCircuit(initialData);
        drawArray(middleData);
    }

    /**
     * 计算出一个完整的圆形图案，并把计算结果转化为d*d的数组
     *
     * @param initialData 传入的，第一象限的圆形（r*r）的数组
     * @return 完整的圆形
     */
    short[][] calculateIntegralCircuit(short[][] initialData) {
        short[][] temp;
        int size = initialData.length * 2;
        temp = new short[size][size];
        //遍历行，从上到下
        for (int i = size - 1; i >= 0; i--) {
            /*外循环分为上下两节，这个上面的1/2圆
            判断上面的半个圆循环完了没有，完了就循环下一个
             */


            if (i < initialData.length) {

                //圆的下半部分遍历，这个循环遍历行
                //第三象限部分
                if (size >= 0) System.arraycopy(temp[2 * R - 1 - i], 0, temp[i], 0, size);

            } else {
                //这个循环遍历一个行中的列元素，一个元素为单位,共2r个元素
                for (int j = 0; j < size; j++) {
                    /*将两个相加，判断是否加完了，再加上另一个
                    第二象限
                     */
                    if (j < initialData.length) {
                        temp[i][j] = initialData[i - R][(R - 1) - j];
                    } else {
                        //第一象限
                        temp[i][j] = initialData[i - R][j - R];
                    }
                }
            }
        }
        return temp;
    }

    /**
     * 将0 和1 数据转化成图形
     *
     * @param data 传入一个要打印的数组
     */
    private void drawArray(short[][] data) {
        for (int m = data.length - 1; m >= 0; m--) {
            if (m == data.length / 2) {
                //这个循环使中间一整行都打印*
                for (int n = 0; n < data.length; n++) {
                    System.out.print(" *");
                }
            } else {
                //正常打印圆形
                for (int n = 0; n < data.length; n++) {
                    if (data[m][n] == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print("  ");
                    }

                    //这个循环打印列中的那个横线

                    if (n == (data.length - 1) / 2) {
                        System.out.print("*");
                    }


                }
                System.out.println();
            }

        }
    }
}
