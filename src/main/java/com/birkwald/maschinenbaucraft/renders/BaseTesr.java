package com.birkwald.maschinenbaucraft.renders;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BaseTesr<T extends TileEntity> extends TileEntitySpecialRenderer<T> {

    protected void renderBlock(IBlockState state, Vec3d offset, BlockPos pos, Tessellator tessellator, BufferBuilder bufferBuilder, World world) {
        GlStateManager.translate(offset.x, offset.y, offset.z);
        BlockRendererDispatcher dispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
        IBakedModel model = dispatcher.getModelForState(state);
        dispatcher.getBlockModelRenderer().renderModel(world, model, state, pos, bufferBuilder, true);
        tessellator.draw();
    }

    protected void renderItem(ItemStack stack, Vec3d offset, Vec3d scale, BlockPos pos, Tessellator tessellator, BufferBuilder bufferBuilder, World world) {
        ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableLighting();
        IBakedModel itemModel = itemModelMesher.getItemModel(stack);
        GlStateManager.translate(offset.x, offset.y, offset.z);
        GlStateManager.scale(scale.x, scale.y, scale.z);

        Minecraft.getMinecraft().getRenderItem().renderItem(stack, itemModel);
    }

    protected void renderModel(IBakedModel model, IBlockState state, Vec3d offset, BlockPos pos, Tessellator tessellator, BufferBuilder bufferBuilder, World world) {
        GlStateManager.translate(offset.x, offset.y, offset.z);
        BlockRendererDispatcher dispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
        dispatcher.getBlockModelRenderer().renderModel(world, model, state, pos, bufferBuilder, true);
        tessellator.draw();
    }
}
