package net.fsmdev.biggerbarrels.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BarrelBlockEntity.class)
public abstract class BarrelBlockEntityMixin {
    @Accessor
    abstract void setInventory(DefaultedList<ItemStack> inventory);

    /**
     * @author FsmDev
     * @reason Changes size depending on setting
     */
    @Overwrite
    public int size() {
        return 54;
    }

    @Inject(method="<init>", at=@At("RETURN"))
    private void init(BlockPos pos, BlockState state, CallbackInfo ci) {
        setInventory(DefaultedList.ofSize(this.size(), ItemStack.EMPTY));
    }

    /**
     * @author FsmDev
     * @reason Changes grid depending on size
     */
    @Overwrite
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x6(syncId, playerInventory, (BarrelBlockEntity) (Object) this);
    }
}
