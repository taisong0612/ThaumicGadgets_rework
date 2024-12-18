package com.ancient.thaumicgadgets.util;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import javax.annotation.Nullable;
import java.util.Random;


public interface IPrimalArmorAbilities {
    Random rand = new Random();


    static void abilityAirArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
        if (count == 1) {
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 0));
        }
        if (count == 2) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 0));
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 0));
        }
        if (count == 3) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 1));
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 0));
        }
        if (count == 4) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 1));
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 2));
        }
    }


    static void abilityFireArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
        entity.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 205, 0));
    }


    static void abilityEarthArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
        if (count < 4) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 205, 0));
        } else {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 205, 1));
        }
    }


    static void ablilityAirArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25) {
                source.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 205, 0));
            }
        }
    }


    static void ablilityFireArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {
                source.setFire(2);
            }
        }
    }


    static void ablilityWaterArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            source.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 205, 1));
        }
    }


    static void ablilityEarthArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {

            if (source instanceof EntityPlayer) {
                source.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 205, 2));
            }
            source.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 205, 0));
        }
    }


    static void ablilityOrdoArmorGetDamage(EntityLivingBase entity, @Nullable EntityLivingBase source, int count) {
        int modifier = Math.max(count, 0);
        entity.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D * modifier);
    }


    static void ablilityEntropyArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            source.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 205, 1));
        }
    }

    static void ablilityFireCrystalGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {

                source.knockBack(source, 5.0F, entity.posX - source.posX, entity.posZ - source.posZ);
                source.setFire(2);
            }
        }
    }


    static void ablilityWaterCrystalGetDamage(@Nullable EntityLivingBase entity, @Nullable int count, float damageAmount) {
        entity.heal(damageAmount * 0.15F * count);
    }


    static void ablilityOrdoCrystalGetDamage(EntityLivingBase entity, EntityLivingBase source, int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {
                for (PotionEffect ef : (PotionEffect[]) source.getActivePotionEffects().toArray((Object[]) new PotionEffect[0])) {

                    if (!ef.getPotion().isBadEffect()) {

                        entity.addPotionEffect(ef);
                        source.removePotionEffect(ef.getPotion());
                    }
                }
            }
        }
    }


    static void ablilityEntropyCrystalGetDamage(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {
                if (source.getActivePotionEffect(MobEffects.POISON) == null) {
                    source.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 205, 1));
                }
            }
        }
    }
}