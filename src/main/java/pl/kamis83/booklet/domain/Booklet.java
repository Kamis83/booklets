package pl.kamis83.booklet.domain;
import pl.kamis83.booklet.service.WeightAwareProduct;

public record Booklet(int pageCount, double xDimension, double yDimension, int grammage, String certificate) implements WeightAwareProduct {
    @Override
    public double getWeight() {
         return  0.00025 * pageCount * grammage * xDimension*0.001 * yDimension*0.001;
    }
}
