/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package LibDL;

public class ldModuleJNI {
  public final static native void ld_print();
  public final static native long ld_ones(int jarg1);
  public final static native long ld_zeros(int jarg1);
  public final static native long ld_randn__SWIG_0(int jarg1);
  public final static native long ld_relu(long jarg1, Tensor jarg1_);
  public final static native long ld_log_softmax(long jarg1, Tensor jarg1_, int jarg2);
  public final static native long ld_max_pool2d(long jarg1, Tensor jarg1_, int jarg2, int jarg3);
  public final static native long ld_nll_loss(long jarg1, Tensor jarg1_, long jarg2, Tensor jarg2_);
  public final static native long ld_dropout(long jarg1, Tensor jarg1_, double jarg2, boolean jarg3);
  public final static native long ld_randn__SWIG_1(int[] jarg1);
  public final static native long new_ld();
  public final static native void delete_ld(long jarg1);
}
