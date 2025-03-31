package org.jerryopen.vsfix.mixin.mekanism;

import mekanism.common.content.miner.MinerFilter;
import mekanism.common.lib.chunkloading.IChunkLoader;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.interfaces.IBoundingBlock;
import mekanism.common.tile.interfaces.IHasVisualization;
import mekanism.common.tile.interfaces.ISustainedData;
import mekanism.common.tile.interfaces.ITileFilterHolder;
import mekanism.common.tile.machine.TileEntityDigitalMiner;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jerryopen.vsfix.init.conversion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityDigitalMiner.class)
public abstract class TileEntityDigitalMinermixin extends TileEntityMekanism implements ISustainedData, IChunkLoader, IBoundingBlock, ITileFilterHolder<MinerFilter<?>>, IHasVisualization {
    // ┏┓　　　┏┓
// ┏┛┻━━━┛┻┓
// ┃　　　　　　　┃ 　
// ┃　　　━　　　┃
// ┃　┳┛　┗┳　┃
// ┃　　　　　　　┃
// ┃　　　┻　　　┃
// ┃　　　　　　　┃
// ┗━┓　　　┏━┛
// ┃　　　┃ 神兽保佑　　　　　　　　
// ┃　　　┃ 代码无BUG！
// ┃　　　┗━━━┓
// ┃　　　　　　　┣┓
// ┃　　　　　　　┏┛
// ┗┓┓┏━┳┓┏┛
// ┃┫┫　┃┫┫
// ┗┻┛　┗┻┛


    @Shadow public abstract int getMinY();
    @Shadow public int radius;
    protected TileEntityDigitalMinermixin(BlockPos pos, BlockState state) {
        super(MekanismBlocks.DIGITAL_MINER, pos, state);

    }@Inject(method = "getStartingPos",at=@At( "HEAD" ),remap = false,cancellable = true)
    private void getStaringPos(CallbackInfoReturnable<BlockPos> cir) {
        cir.setReturnValue(new BlockPos(conversion.blockposconvertgetShipToWorld(level,getBlockPos()).getX() - radius, getMinY(), conversion.blockposconvertgetShipToWorld(level,getBlockPos()).getZ() - radius));
    }

}
