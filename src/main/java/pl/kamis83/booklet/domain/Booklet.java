package pl.kamis83.booklet.domain;
import pl.kamis83.booklet.service.WeightAwareProduct;

public record Booklet(int pageCount, double xDimension, double yDimension, int grammage) implements WeightAwareProduct {
    @Override
    public double getWeight() {
         return  0.00025 * pageCount * grammage * xDimension * yDimension;
    }
}
