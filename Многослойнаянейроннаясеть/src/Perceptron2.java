public class Perceptron2 {
    public static double[] weighttwo;

    public Perceptron2(double[] weighttwo) {
        this.weighttwo = weighttwo;
    }

    public static double[] sumtwo(double[] imp2,double[] imp) {
        double p = 0;
        double[] imp3 = new double[imp2.length];
        for (int i = 0; i < imp3.length; i++) {
            p = Perceptron1.sum(imp)[i];
            imp3[i]=p;
        }
        if (weighttwo.length == imp2.length) {
            for (int i = 0; i < weighttwo.length; i++) {
                for (int j = 0; j < imp2.length; j++) {
                    imp3[i] += weighttwo[j] * imp2[i];
                }
            }
        }
        return imp3;
    }

    public static double result2(double[] t) {
        int k = t.length;
        double p = 0;
        for (int i = 0; i < k; i++) {
            p += t[i];
        }
        return p;
    }
}
