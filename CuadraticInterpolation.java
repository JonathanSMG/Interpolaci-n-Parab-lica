public class CuadraticInterpolation {

    public static void main(String[] args) {
        double x0 = 0;
        double x1 = 1;
        double x2 = 4;

        // Valores iniciales de la función f(x) = 2 * sin(x) - x^2 / 10
        double fx0 = calculateFunctionValue(x0);
        double fx1 = calculateFunctionValue(x1);
        double fx2 = calculateFunctionValue(x2);

        // Realizar 5 iteraciones
        for (int i = 0; i < 5; i++) {
            // Encontrar el máximo o mínimo usando interpolación cuadrática
            double result = quadraticInterpolation(x0, fx0, x1, fx1, x2, fx2);

            // Actualizar valores para la siguiente iteración
            x0 = x1;
            x1 = x2;
            x2 = result;

            fx0 = fx1;
            fx1 = fx2;
            fx2 = calculateFunctionValue(result);

            System.out.println("Iteración " + (i + 1) + ":");
            System.out.println("El valor de x que aproxima un máximo o mínimo es: " + result);
            System.out.println("El valor de f(x) en ese punto es: " + calculateFunctionValue(result));
        }
    }

    // Función que calcula el valor de f(x) = 2 * sin(x) - x^2 / 10
    private static double calculateFunctionValue(double x) {
        return 2 * Math.sin(x) - (x * x) / 10;
    }

    // Método de interpolación cuadrática
    private static double quadraticInterpolation(double x0, double fx0, double x1, double fx1, double x2, double fx2) {
        double a = fx0 / ((x0 - x1) * (x0 - x2)) + fx1 / ((x1 - x0) * (x1 - x2)) + fx2 / ((x2 - x0) * (x2 - x1));
        double b = (-fx0 * (x1 + x2) / ((x0 - x1) * (x0 - x2))) - (fx1 * (x0 + x2) / ((x1 - x0) * (x1 - x2))) - (fx2 * (x0 + x1) / ((x2 - x0) * (x2 - x1)));
        double c = (fx0 * x1 * x2 / ((x0 - x1) * (x0 - x2))) + (fx1 * x0 * x2 / ((x1 - x0) * (x1 - x2))) + (fx2 * x0 * x1 / ((x2 - x0) * (x2 - x1)));

        // Encontrar el mínimo de la función cuadrática ax^2 + bx + c
        double result = -b / (2 * a);
        return result;
    }
}
