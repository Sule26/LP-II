public class cubo {
    public static void main(String[] args) {
        Rect r1 = new Rect(5, 10, 10);
        r1.print();
    }
}

class Rect {
    int a;
    int w, h;

    Rect(int a, int w, int h) {
        this.a = a;
        this.w = w;
        this.h = h;
    }

    void print() {
        System.out.format("Lado do cubo: %d\nPosição: (%d,%d).\n", this.a, this.w, this.h);
    }
}
