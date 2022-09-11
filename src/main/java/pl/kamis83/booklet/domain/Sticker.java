package pl.kamis83.booklet.domain;

import pl.kamis83.booklet.service.WeightAwareProduct;

public class Sticker implements WeightAwareProduct {
    @Override
    public double getWeight() {
        return 0;
    }
}
