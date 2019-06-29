/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package LibDL.nn;

import LibDL.SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t;

public class Conv2d {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public Conv2d(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(Conv2d obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LibDL.Conv2dModuleJNI.delete_nn_Conv2d(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Conv2d(int in_channels, int out_channels, int kernel_size) {
    this(LibDL.Conv2dModuleJNI.new_nn_Conv2d(in_channels, out_channels, kernel_size), true);
  }

  public SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t getCore() {
    return new SWIGTYPE_p_std__shared_ptrT_torch__nn__Conv2dImpl_t(LibDL.Conv2dModuleJNI.nn_Conv2d_getCore(swigCPtr, this), true);
  }

}