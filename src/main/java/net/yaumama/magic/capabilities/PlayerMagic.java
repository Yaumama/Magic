package net.yaumama.magic.capabilities;

import net.minecraft.nbt.CompoundTag;

public class PlayerMagic {
    private String selectedSpell;

    public String getSelectedSpell() {
        return selectedSpell;
    }

    public void selectSpell(String spell) {
        selectedSpell = spell;
    }

    public void copyFrom(PlayerMagic source) {
        this.selectedSpell = source.selectedSpell;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putString("selectedSpell", selectedSpell);
    }

    public void loadNBTData(CompoundTag nbt) {
        selectedSpell = nbt.getString("selectedSpell");
    }
}
