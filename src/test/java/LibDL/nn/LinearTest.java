package LibDL.nn;

import LibDL.Tensor;
import LibDL.data.StatelessDataLoader;
import LibDL.data.datasets.MNIST;
import LibDL.data.util;
import LibDL.ld;

public class LinearTest {

    static {
        System.load("/home/meowch/Dezeal/LibDL-LibTorch/build/libLibDL.so");
    }

    @org.junit.Test
    public void print() {
        Linear linear = new Linear(1, 2);
        linear.print();

        Tensor a = ld.ones(6);
        Tensor b = ld.randn(6);

        Tensor c = a.add(b);
        c.print();
    }
}