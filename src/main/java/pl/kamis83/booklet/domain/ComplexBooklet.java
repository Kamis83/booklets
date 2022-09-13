package pl.kamis83.booklet.domain;

import pl.kamis83.booklet.service.WeightAwareProduct;

public record ComplexBooklet(int pageMiddleUnitCount, double xDimension, double yDimension,
                             int coverGrammage, int unitGrammage, String certificate) implements WeightAwareProduct {

    @Override
    public double getWeight() {
        return ((xDimension*0.001 * yDimension*0.001) * (0.25 * pageMiddleUnitCount * unitGrammage + coverGrammage)) * 0.001;
    }
}
