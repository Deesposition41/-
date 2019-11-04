public class Perceptron1 {
    public static double[] weight;
    public Perceptron1(double[] weight) {
        this.weight = weight;
    }

    public static double[] sum(double[] imp1) {
        double[] imp2 = new double[imp1.length];
        if (weight.length == imp1.length) {
            for (int i = 0; i < weight.length; i++) {
                imp2[i] = weight[i] * imp1[i];

            }
        }
        return imp2;
    }

    public static double result1(double[] t) {
        int k = t.length;
        double p = 0;
        for (int i = 0; i < k; i++) {
            p += t[i];
        }
        return p;
    }
}
