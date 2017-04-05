package Box;

public class Box {

    private Double length;
    private Double width;
    private Double height;

    public Box(double l, double w, double h) throws Exception {
        this.setLength(l);
        this.setWidth(w);
        this.setHeight(h);
    }

    private void setLength(double length) throws Exception {
        if (length <= 0){
            throw new Exception("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    private void setWidth(double width) throws Exception {
        if (width <= 0){
            throw new Exception("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    private void setHeight(double height) throws Exception {
        if (height <= 0){
            throw new Exception("Height cannot be zero or negative.");
        }

        this.height = height;
    }

    public Double surfaceArea(){
        return 2 * (length * height + height * width + width * length);
    }

    public Double lateralArea(){
        return 2.0 * this.height * (this.width + this.length);
    }

    public Double volume(){
        return this.height * this.length * this.width;
    }
}
