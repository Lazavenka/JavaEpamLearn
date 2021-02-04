package by.roger.epamLearn.moduleFour.triangle;

public class Triangle {
    private Dot a;
    private Dot b;
    private Dot c;

    public Triangle(Dot a, Dot b, Dot c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
        Dot aTemp = new Dot();
        this.a = aTemp;
        Dot bTemp = new Dot();
        while(bTemp.equals(aTemp)){
            bTemp = new Dot();
        }
        this.b = new Dot();
        Dot cTemp = new Dot();
        while (cTemp.equals(aTemp)||cTemp.equals(bTemp)){
            cTemp = new Dot();
        }
        this.c = new Dot();
    }

    public double findPerimeter(){
        return a.findDistance(b) + a.findDistance(c) + b.findDistance(c);
    }
    public double findSquare(){
        double ab = a.findDistance(b);
        double ac = a.findDistance(c);
        double bc = b.findDistance(c);
        double p = findPerimeter()/2;   // Полупериметр
        return Math.sqrt(p*(p-ab)*(p-ac)*(p-bc)); // Формула Герона
    }
    public Dot findMedianCross(){
        double x = (a.getX()+b.getX()+c.getX())/3;
        double y = (a.getY()+b.getY()+c.getY())/3;
        return new Dot(x,y);
    }
    public void printTriangle(){
        System.out.println("Точка А - "+a.toString());
        System.out.println("Точка B - "+b.toString());
        System.out.println("Точка C - "+c.toString());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle that = (Triangle) o;

        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (b != null ? !b.equals(that.b) : that.b != null) return false;
        return c != null ? c.equals(that.c) : that.c == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }
}
