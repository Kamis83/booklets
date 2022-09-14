package pl.kamis83.booklet.domain;

import pl.kamis83.booklet.service.WeightAwareProduct;

public record ComplexBooklet(int pageMiddleUnitCount, int pageCoverCount, double xDimension, double yDimension,
                              int unitGrammage,int coverGrammage, String certificate) implements WeightAwareProduct {

    @Override
    public double getWeight() {
        return ((0.00000025*2 * xDimension * yDimension) *
                ((pageMiddleUnitCount * unitGrammage) + (pageCoverCount * coverGrammage))) * 0.001;
    }
}
