package com.birkwald.mbc.utils.useful_matrices;

import com.birkwald.mbc.utils.data_containers.HomogeneousMatrix4d;
import com.birkwald.mbc.utils.data_containers.PosBasedVec4d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

//todo haven't finished
public enum RotateMatrices {
    ;

    private HomogeneousMatrix4d matrix4d;

    RotateMatrices(HomogeneousMatrix4d matrix4d) {
        this.matrix4d = matrix4d;
    }

    /**
     * Rodrigues' rotation formular
     *
     * @param pos        vec be rotate
     * @param rotateAxis rotate axis
     */
    public static PosBasedVec4d rotateAroundAnyAxis(BlockPos pos, Vec3d rotateAxis, double angle, Boolean isPoint) {
        Vec3d v = new Vec3d(pos.getX(), pos.getY(), pos.getZ());
        Vec3d result = v.scale(Math.cos(angle)).add(rotateAxis.crossProduct(v).scale(Math.sin(angle))).add(rotateAxis.scale(rotateAxis.dotProduct(v)).scale(1 - Math.sin(angle)));
        return new PosBasedVec4d(result.x, result.y, result.z, isPoint);
    }

    public PosBasedVec4d rotateWithHomogeneous(double offsetX, double offsetY, double offsetZ, PosBasedVec4d vec4d) {
        return new PosBasedVec4d(matrix4d.add(HomogeneousMatrix4d.getOffsetMatrix(offsetX, offsetY, offsetZ)).operate(vec4d), vec4d.isPoint());
    }

    public PosBasedVec4d rotate(PosBasedVec4d vec4d) {
        return matrix4d.operate(vec4d);
    }

    public PosBasedVec4d rotate(BlockPos pos, boolean isPoint) {
        return matrix4d.operate(new PosBasedVec4d(pos, isPoint));
    }
}
