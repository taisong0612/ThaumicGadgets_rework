package com.ancient.thaumicgadgets.util;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;


public interface IFunctionLibrary {

    static Aspect getAspectFromMode(int mode) {
        switch (mode) {

            case 0:
                return Aspect.AIR;
            case 1:
                return Aspect.FIRE;
            case 2:
                return Aspect.WATER;
            case 3:
                return Aspect.EARTH;
            case 4:
                return Aspect.ORDER;
            case 5:
                return Aspect.ENTROPY;
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    static boolean isPointInRegion(int sX, int sY, int fX, int fY, int mouseX, int mouseY) {
        if (mouseX > sX && mouseX < sX + fX) {
            if (mouseY > sY && mouseY < sY + fY) {
                return true;
            }
        }
        return false;
    }
}
