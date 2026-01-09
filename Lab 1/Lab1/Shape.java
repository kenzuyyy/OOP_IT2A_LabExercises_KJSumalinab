public abstract class Shape {

    public abstract double getArea();
    public abstract double getPerimeter();

    public static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static class Rectangle extends Shape {
        private final double length;
        private final double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }

        @Override
        public double getPerimeter() {
            return 2 * (length + width);
        }
    }

    public static class Square extends Shape {
        private final double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }

        @Override
        public double getPerimeter() {
            return 4 * side;
        }
    }

    public static class Triangle extends Shape {
        private final double a, b, c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double getPerimeter() {
            return a + b + c;
        }

        @Override
        public double getArea() {
            double s = getPerimeter() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }
}
