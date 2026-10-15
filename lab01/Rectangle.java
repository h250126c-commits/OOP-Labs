public  class Rectangle {
     double width;
    double height;

    // EXPLAIN: area uses the object's own fields, so no parameters are needed
    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {
        double[] widths  = {2, 4, 7, 6, 1};
        double[] heights = {3, 5, 3, 6, 9};

        // EXPLAIN: this creates an array that can hold 5 references; the objects don't exist yet
        Rectangle[] rects = new Rectangle[5];

        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();      // create each object
            rects[i].width = widths[i];
            rects[i].height = heights[i];
            System.out.println("Rectangle " + (i + 1) + ": " + rects[i].width + " x "
                    + rects[i].height + ", area = " + rects[i].area()
                    + ", perimeter = " + rects[i].perimeter());
        }

        // EXPLAIN: keep a reference to the biggest one seen so far
        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }
        System.out.println("Largest area: " + largest.area()
                + " (" + largest.width + " x " + largest.height + ")");
    }
}
    

