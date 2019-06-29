/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package LibDL.nn;

import LibDL.SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t;
import LibDL.Tensor;

public class Conv2dModuleType {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public Conv2dModuleType(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(Conv2dModuleType obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LibDL.Conv2dModuleTypeModuleJNI.delete_nn_Conv2dModuleType(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setCore(SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t value) {
    LibDL.Conv2dModuleTypeModuleJNI.nn_Conv2dModuleType_core_set(swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t getCore() {
    return new SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t(LibDL.Conv2dModuleTypeModuleJNI.nn_Conv2dModuleType_core_get(swigCPtr, this), true);
  }

  public Conv2dModuleType() {
    this(LibDL.Conv2dModuleTypeModuleJNI.new_nn_Conv2dModuleType__SWIG_0(), true);
  }

  public Tensor forward(Tensor self) {
    return new Tensor(LibDL.Conv2dModuleTypeModuleJNI.nn_Conv2dModuleType_forward(swigCPtr, this, Tensor.getCPtr(self), self), true);
  }

  public Conv2dModuleType(SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t core) {
    this(LibDL.Conv2dModuleTypeModuleJNI.new_nn_Conv2dModuleType__SWIG_1(SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t.getCPtr(core)), true);
  }

}
