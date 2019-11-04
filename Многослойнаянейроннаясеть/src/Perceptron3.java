public class Perceptron3 {
    private static double[] weightthree;
    private static double learningrate = 0.1;

    public Perceptron3(double[] weightthree) {
        this.weightthree = weightthree;
    }

    public static double[] sumthree(double[] imp3,double[] imp) {
        double p=0;
        double[] res = new double[imp3.length];
        for (int i = 0; i < res.length; i++) {
            p=Perceptron2.sumtwo(imp3,imp)[i];
            res[i]=p;
        }
        if (weightthree.length == imp3.length) {
            for (int i = 0; i < weightthree.length; i++) {
                for (int j = 0; j < imp3.length; j++) {
                    res[i] += weightthree[j] * imp3[i];
                }
            }
        }
        return res;
    }

    public double result3(double[] t) {
        int k = t.length;
        double p = 0;
        for (int i = 0; i < k; i++) {
            p += t[i];
        }
        return p;
    }

    private static double sigmoid(double x) {
        return 1.0 / (1 + Math.pow(Math.E, -1 * x));
    }
    public double sumOfImpulsWithWeights(double[] impuls) {
        double result = 0;
        if (weightthree.length == impuls.length) {
            for (int i = 0; i < weightthree.length; i++) {
                result += weightthree[i] * Perceptron2.sumtwo(Perceptron1.sum(impuls),impuls)[i];
            }
        }
        return result;
    }

    public double predict(double[] impuls) {
        double result3 = sigmoid(sumOfImpulsWithWeights(impuls));
        if (result3 > 0.5) {
            return 1;
        } else {
            return 0;
        }
    }

    public void learn(double[] impuls, double answer) {
        double sumimpulsweights = result3(Perceptron3.sumthree(Perceptron2.sumtwo(Perceptron1.sum(impuls),impuls),impuls));
        double sigmoid = sigmoid(sumimpulsweights);
        double error = sigmoid - answer;
        double weightsDelta = error * sigmoid * (1 - sigmoid);
        for (int i = 0; i < weightthree.length; i++) {
           Perceptron1.weight[i]=Perceptron1.weight[i]-impuls[i] * weightsDelta * learningrate;
           Perceptron2.weighttwo[i]=Perceptron2.weighttwo[i]-(Perceptron1.sum(impuls))[i] * weightsDelta * learningrate;
           Perceptron3.weightthree[i]=Perceptron3.weightthree[i]-Perceptron2.sumtwo(Perceptron1.sum(impuls),impuls)[i]* weightsDelta * learningrate;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < weightthree.length; i++) {
            result += "Вес " + i + ": " + weightthree[i] + "\n";
        }
        result += "\n";

        return result;
    }

}

