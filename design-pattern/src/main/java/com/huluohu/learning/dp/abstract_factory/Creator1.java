package com.huluohu.learning.dp.abstract_factory;

/**
 * Created by huluobo on 15-12-13.
 */
public class Creator1 extends AbstratCreator{
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
