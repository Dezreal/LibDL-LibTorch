/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package LibDL;

public class TensorModuleJNI {
  public final static native long new_Tensor__SWIG_0();
  public final static native long new_Tensor__SWIG_1(long jarg1);
  public final static native long Tensor_add(long jarg1, Tensor jarg1_, long jarg2, Tensor jarg2_);
  public final static native long Tensor_reshape(long jarg1, Tensor jarg1_, int[] jarg2);
  public final static native long Tensor_view(long jarg1, Tensor jarg1_, int[] jarg2);
  public final static native int Tensor_size(long jarg1, Tensor jarg1_, int jarg2);
  public final static native void Tensor_print(long jarg1, Tensor jarg1_);
  public final static native void Tensor_backward(long jarg1, Tensor jarg1_);
  public final static native float Tensor_item(long jarg1, Tensor jarg1_);
  public final static native void Tensor_core_set(long jarg1, Tensor jarg1_, long jarg2);
  public final static native long Tensor_core_get(long jarg1, Tensor jarg1_);
  public final static native void delete_Tensor(long jarg1);
}
