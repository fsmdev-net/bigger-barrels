package net.fsmdev.biggerbarrels.mixin;

import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BarrelBlockEntity.class)
public abstract class BarrelBlockEntityMixin {
    @Shadow
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);

    /**
     * @author FsmDev
     * @reason Changes size depending on setting
     */
    @Overwrite
    public int size() {
        return 54;
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
