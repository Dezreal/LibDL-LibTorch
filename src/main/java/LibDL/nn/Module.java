/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package LibDL.nn;

import LibDL.SWIGTYPE_p_std__vectorT_at__Tensor_t;

public class Module {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public Module(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(Module obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LibDL.ModuleModuleJNI.delete_nn_Module(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public LibDL.nn.LinearModuleType register_linear_module(String name, LibDL.nn.Linear module_holder) {
    return new LibDL.nn.LinearModuleType(LibDL.ModuleModuleJNI.nn_Module_register_linear_module(swigCPtr, this, name, LibDL.nn.Linear.getCPtr(module_holder), module_holder), true);
  }

  public LibDL.nn.Conv2dModuleType register_conv2d_module(String name, LibDL.nn.Conv2d module_holder) {
    return new LibDL.nn.Conv2dModuleType(LibDL.ModuleModuleJNI.nn_Module_register_conv2d_module(swigCPtr, this, name, LibDL.nn.Conv2d.getCPtr(module_holder), module_holder), true);
  }

  public SWIGTYPE_p_std__vectorT_at__Tensor_t parameters() {
    return new SWIGTYPE_p_std__vectorT_at__Tensor_t(LibDL.ModuleModuleJNI.nn_Module_parameters(swigCPtr, this), true);
  }

  public void train() {
    LibDL.ModuleModuleJNI.nn_Module_train(swigCPtr, this);
  }

  public void eval() {
    LibDL.ModuleModuleJNI.nn_Module_eval(swigCPtr, this);
  }

  public Module() {
    this(LibDL.ModuleModuleJNI.new_nn_Module(), true);
  }

}
