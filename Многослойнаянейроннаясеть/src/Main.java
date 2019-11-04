public class Main {
    public static void main(String[] args) {
        Perceptron1 perceptron1 = new Perceptron1(new double[]{-0.2, 0.1, -0.1});
        Perceptron2 perceptron2 = new Perceptron2(new double[]{0.1, -0.2, 0.1});
        Perceptron3 perceptron3 = new Perceptron3(new double[]{0.1, -0.5, 0.2});
        checkPredict(perceptron3);
        for (int i = 0; i < 1_000; i++) {
            perceptron3.learn(new double[]{0, 0, 0}, 0);
            perceptron3.learn(new double[]{1, 0, 0}, 1);
            perceptron3.learn(new double[]{0, 1, 0}, 0);
            perceptron3.learn(new double[]{0, 0, 1}, 1);
            perceptron3.learn(new double[]{1, 1, 0}, 0);
            perceptron3.learn(new double[]{1, 0, 1}, 1);
            perceptron3.learn(new double[]{0, 1, 1}, 0);
            perceptron3.learn(new double[]{1, 1, 1}, 1);
        }
        System.out.println(perceptron3);
        checkPredict(perceptron3);
    }

    public static void checkPredict(Perceptron3 perceptron3) {
        System.out.println(perceptron3.predict(new double[]{0, 0, 0}) == 0);
        System.out.println(perceptron3.predict(new double[]{1, 0, 0}) == 1);
        System.out.println(perceptron3.predict(new double[]{0, 1, 0}) == 0);
        System.out.println(perceptron3.predict(new double[]{0, 0, 1}) == 1);
        System.out.println(perceptron3.predict(new double[]{1, 1, 0}) == 0);
        System.out.println(perceptron3.predict(new double[]{1, 0, 1}) == 1);
        System.out.println(perceptron3.predict(new double[]{0, 1, 1}) == 0);
        System.out.println(perceptron3.predict(new double[]{1, 1, 1}) == 1);
    }
}
