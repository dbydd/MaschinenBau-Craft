package com.birkwald.mbc.utils.data_containers;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;

public class HomogeneousMatrix4d extends Array2DRowRealMatrix {
    private static final double[] IDENTITY_C1 = new double[]{1, 0, 0, 0};
    private static final double[] IDENTITY_C2 = new double[]{0, 1, 0, 0};
    private static final double[] IDENTITY_C3 = new double[]{0, 0, 1, 0};
    private static final double[] IDENTITY_C4 = new double[]{0, 0, 0, 1};

    public HomogeneousMatrix4d(double[] col1, double[] col2, double[] col3, double[] col4) throws DimensionMismatchException, NoDataException, NullArgumentException {
        super(new double[][]{
                {col1[0], col2[0], col3[0], col4[0]},
                {col1[1], col2[1], col3[1], col4[1]},
                {col1[2], col2[2], col3[2], col4[2]},
                {col1[3], col2[3], col3[3], 1}
        });
    }

    public HomogeneousMatrix4d(double[] col1, double[] col2, double[] col3, double offsetX, double offsetY, double offsetZ) throws DimensionMismatchException, NoDataException, NullArgumentException {
        super(new double[][]{
                {col1[0], col2[0], col3[0], offsetX},
                {col1[1], col2[1], col3[1], offsetY},
                {col1[2], col2[2], col3[2], offsetZ},
                {col1[3], col2[3], col3[3], 1}
        });
        // todo check is column vec
    }

    public PosBasedVec4d operate(PosBasedVec4d v) throws DimensionMismatchException {
        return new PosBasedVec4d(super.operate(v), v.isPoint());
    }

    public static HomogeneousMatrix4d getOffsetMatrix(double offsetX, double offsetY, double offsetZ) {
        return new HomogeneousMatrix4d(IDENTITY_C1, IDENTITY_C2, IDENTITY_C3, new double[]{offsetX, offsetY, offsetZ, 1});
    }
}
