package com.birkwald.mbc.utils.data_containers;

import net.minecraft.util.math.BlockPos;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class PosBasedVec4d extends ArrayRealVector {

    private final boolean isPoint;

    public PosBasedVec4d(BlockPos pos, boolean isPoint) {
        super(new double[]{pos.getX(), pos.getY(), pos.getZ(), isPoint ? 1 : 0});
        this.isPoint = isPoint;
    }

    public PosBasedVec4d(RealVector vector, boolean isPoint) {
        super(vector);
        this.isPoint = isPoint;
    }

    public PosBasedVec4d(double X, double Y, double Z, boolean isPoint) {
        super(new double[]{X, Y, Z, isPoint ? 1 : 0});
        this.isPoint = isPoint;
    }

    public double getX() {
        return this.getEntry(0);
    }

    public double getY() {
        return this.getEntry(1);
    }

    public double getZ() {
        return this.getEntry(2);
    }

    public boolean isPoint() {
        return isPoint;
    }

    public BlockPos asBlockPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
}
