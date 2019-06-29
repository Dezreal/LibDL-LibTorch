package LibDL.nn.data.caser;

import LibDL.data.caser.Interactions;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InteractionsTest {
    @Test
    public void testInit() {
        try {
            Interactions interactions = new Interactions("/home/meowch/Dezeal/LibDL-LibTorch/build/src/main/java/LibDL/data/caser/datasets/ml1m/validation/train.txt", null, null);
        } catch (IOException e) {
            e.printStackTrace();
            assert false;
        }
    }
}
