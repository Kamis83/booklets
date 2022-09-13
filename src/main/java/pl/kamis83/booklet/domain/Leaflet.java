package pl.kamis83.booklet.domain;

import pl.kamis83.booklet.service.WeightAwareProduct;

public record Leaflet(double xDimension, double yDimension, int grammage, String certificate) implements WeightAwareProduct {
    @Override
    public double getWeight() {

        return grammage * 0.001*xDimension *0.001*yDimension * 0.001;
    }
}
