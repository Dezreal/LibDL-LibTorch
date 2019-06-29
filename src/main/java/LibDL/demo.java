package LibDL;

import LibDL.nn.Module;
import LibDL.nn.Linear;
import LibDL.nn.Conv2d;
import LibDL.nn.LinearModuleType;
import LibDL.nn.Conv2dModuleType;
import LibDL.data.MNISTDataLoader;

/*
struct Net : torch::nn::Module {
    torch::nn::Linear fc1{nullptr}, fc2{nullptr};
    torch::nn::Conv2d conv1{nullptr}, conv2{nullptr};

    Net() {
        conv1 = register_module("conv1", torch::nn::Conv2d(1, 20, 5));
        conv2 = register_module("conv2", torch::nn::Conv2d(20, 50, 5));
        fc1 = register_module("fc1", torch::nn::Linear(4 * 4 * 50, 500));
        fc2 = register_module("fc2", torch::nn::Linear(500, 10));
    }

    torch::Tensor forward(torch::Tensor x) {
        x = torch::relu(conv1->forward(x));
        x = torch::max_pool2d(x, 2, 2);
        x = torch::relu(conv2->forward(x));
        x = torch::max_pool2d(x, 2, 2);
        x = x.view({-1, 4 * 4 * 50});
        x = torch::relu(fc1->forward(x));
        x = fc2->forward(x);
        x = torch::log_softmax(x, 1);
        return x;
    }
};
 */

class Net extends Module {
    private LinearModuleType fc1;
    private LinearModuleType fc2;
    private Conv2dModuleType conv1;
    private Conv2dModuleType conv2;

    Net() {
        conv1 = register_conv2d_module("conv1", new Conv2d(1, 20, 5));
        conv2 = register_conv2d_module("conv2", new Conv2d(20, 50, 5));
        fc1 = register_linear_module("fc1", new Linear(4 * 4 * 50, 500));
        fc2 = register_linear_module("fc2", new Linear(500, 10));
    }

    Tensor forward(Tensor x) {
        x = ld.relu(conv1.forward(x));
        x = ld.max_pool2d(x, 2, 2);
        x = ld.relu(conv2.forward(x));
        x = ld.max_pool2d(x, 2, 2);
        x = x.reshape(new int[]{-1, 4 * 4 * 50});
        x = ld.relu(fc1.forward(x));
        x = fc2.forward(x);
        x = ld.log_softmax(x, 1);
        return x;
    }
}

public class demo {

    static int log_interval = 100;
    static int batch_size = 64;
    static double lr = 0.01;
    static double momentum = 0.5;
    static int epochs = 10;

    static {
        System.load("/home/meowch/Dezeal/LibDL-LibTorch/build/libLibDL.so");
    }

    /*

    void train(std::shared_ptr<Net> &model, MNIST_DATA_LOADER &train_loader, torch::optim::SGD &optimizer, int &epoch) {
    model->train();

    size_t batch_idx = 0;
    for (auto &batch : *train_loader) {
        torch::Tensor data = batch.data;
        torch::Tensor target = batch.target;
        optimizer.zero_grad();
        torch::Tensor output = model->forward(data);
        torch::Tensor loss = torch::nll_loss(output, target);
        loss.backward();
        optimizer.step();

        if ((++batch_idx) % log_interval == 0) {
            std::cout
                    << "Train Epoch "
                    << epoch
                    << " batch_idx "
                    << batch_idx * data.size(0)
                    << " loss "
                    << loss.item<float>()
                    << std::endl;
        }
    }
}
     */

    private static void train(Net model, MNISTDataLoader train_loader, LibDL.optim.SGD optimizer, int epoch) throws InterruptedException {
        model.train();

        int batch_idx = 0;
        for (LibDL.data.Example batch : train_loader) {
            Tensor data = batch.getData();
            Tensor target = batch.getTarget();
            optimizer.zero_grad();
            Tensor output = model.forward(data);
            Tensor loss = ld.nll_loss(output, target);
            loss.backward();
            optimizer.step();

            if ((++batch_idx) % log_interval == 0) {
                System.out.println("Train Epoch " + epoch + " batch_idx " + batch_idx + " loss " + loss.item());
                System.gc();
            }
        }
    }

//    void test(std::shared_ptr<Net>&model, MNIST_DATA_LOADER &test_loader) {
//        model -> eval();
//        torch::Tensor test_loss = torch::zeros (1);
//
//        torch::NoGradGuard no_grad;
//        for (auto & batch : *test_loader){
//            torch::Tensor data = batch.data;
//            torch::Tensor target = batch.target;
//            torch::Tensor output = model -> forward(data);
//            test_loss += torch::nll_loss (output, target).item();
//        }
//
//        std::cout
//                << "Loss: "
//                << test_loss
//                << std::endl;
//    }

    private static void test(Net model, MNISTDataLoader test_loader) {
        model.eval();
        Tensor test_loss = ld.zeros(1);

        for (LibDL.data.Example batch : test_loader) {
            Tensor data = batch.getData();
            Tensor target = batch.getTarget();
            Tensor output = model.forward(data);
            test_loss = test_loss.add(ld.nll_loss(output, target));
        }
        System.out.println("Loss: ");
        test_loss.print();
    }

    public static void main(String[] args) throws InterruptedException {
        Net net = new Net();

        MNISTDataLoader train_loader = new MNISTDataLoader(true);
        MNISTDataLoader test_loader = new MNISTDataLoader(false);
        LibDL.optim.SGD optimizer = new LibDL.optim.SGD(net.parameters(), 0.01);

        long start, finish;

        for (int epoch = 1; epoch <= epochs; ++epoch) {
            start = System.currentTimeMillis();
            train(net, train_loader, optimizer, epoch);
            finish = System.currentTimeMillis();
            System.out.println("Seconds " + (finish - start)/1000);
            test(net, test_loader);
        }
    }
}
