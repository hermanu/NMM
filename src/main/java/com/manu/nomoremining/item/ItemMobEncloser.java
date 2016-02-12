package com.manu.nomoremining.item;

import com.manu.nomoremining.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Manu on 07/02/2016.
 */
public class ItemMobEncloser extends Item
{

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {

        Entity mob;

        if(stack.getTagCompound() != null){
            NBTTagCompound nbt = stack.getTagCompound();
            mob = EntityList.createEntityFromNBT(nbt,worldIn);

            if (mob == null) {
                return true;
            }
            mob.readFromNBT(nbt);

//          mob.setLocationAndAngles(spawnX, spawnY, spawnZ, worldIn.rand.nextFloat() * 360.0F, 0);

            boolean spaceClear = worldIn.checkNoEntityCollision(mob.getEntityBoundingBox())
                    && worldIn.getCollidingBoundingBoxes(mob, mob.getEntityBoundingBox()).isEmpty();
            if(!spaceClear) {
                return false;
            }

            if(stack.hasDisplayName() && mob instanceof EntityLiving) {
                ((EntityLiving)mob).setCustomNameTag(stack.getDisplayName());
            }

            worldIn.spawnEntityInWorld(mob);
            if(mob instanceof EntityLiving) {
                ((EntityLiving)mob).playLivingSound();
            }
            LogHelper.info("SPAWN BITCH");

            return true;
        }

        return false;
    }


    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target)
    {

        //Capturing mob
        String entityId = target.getName();
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("id",entityId);
        target.writeToNBT(nbt);
        stack.setTagCompound(nbt);
        ItemStack capturedMob = new ItemStack(ItemNMM.mob_encloser);
        capturedMob.setTagCompound(nbt);
//        setDisplayNameFromEntityNameTag(capturedMob,target);
        playerIn.swingItem();
        target.setDead();
        if(target.isDead)
        {
            stack.stackSize--;
        }
        if(!playerIn.inventory.addItemStackToInventory(capturedMob))
        {
            target.worldObj.spawnEntityInWorld(new EntityItem(target.worldObj,target.posX,target.posY, target.posZ, capturedMob));
        }
        playerIn.setCurrentItemOrArmor(0, stack);

        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {

        stack.setTagCompound(null);
        return stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        if(stack.getTagCompound() != null){

            NBTTagCompound nbt = stack.getTagCompound();
            tooltip.add("Name : " +nbt.getString("id"));
            tooltip.add("Health : "+ nbt.getInteger("Health"));
        }

    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        if(stack.getTagCompound() != null)
        {
            return stack.getTagCompound().hasKey("coords");
        }
        return false;
    }

    private void setDisplayNameFromEntityNameTag(ItemStack item, Entity ent) {
        if(ent instanceof EntityLiving) {
            EntityLiving entLiv = (EntityLiving)ent;
            String name = entLiv.getName();
            if(name.length() > 0) {
                item.setStackDisplayName(EnumChatFormatting.RED +name);
            }
        }
    }

}
