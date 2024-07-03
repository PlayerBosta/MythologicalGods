package com.playerbosta.mythologyunleashed.screen;

import com.playerbosta.mythologyunleashed.block.ModBlocks;
import com.playerbosta.mythologyunleashed.block.entity.GemPolishingStationBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class GemPolishingStationMenu extends AbstractContainerMenu {
    public final GemPolishingStationBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public GemPolishingStationMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public GemPolishingStationMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.GEM_POLISHING_MENU.get(), pContainerId);
        checkContainerSize(inv, 2);
        blockEntity = ((GemPolishingStationBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;
    }


    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.GEM_POLISHING_STATION.get());
    }

}