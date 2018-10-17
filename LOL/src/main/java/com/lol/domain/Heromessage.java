package com.lol.domain;

import java.math.BigDecimal;

public class Heromessage {
    private Short hid;

    private Short health;

    private BigDecimal restoreHealth;

    private Short magic;

    private BigDecimal restoreMagic;

    private Short movementSpeed;

    private Short attackRange;

    private Short atk;

    private BigDecimal atkSpeed;

    private Short armor;

    private Short spells;

    public Short getHid() {
        return hid;
    }

    public void setHid(Short hid) {
        this.hid = hid;
    }

    public Short getHealth() {
        return health;
    }

    public void setHealth(Short health) {
        this.health = health;
    }

    public BigDecimal getRestoreHealth() {
        return restoreHealth;
    }

    public void setRestoreHealth(BigDecimal restoreHealth) {
        this.restoreHealth = restoreHealth;
    }

    public Short getMagic() {
        return magic;
    }

    public void setMagic(Short magic) {
        this.magic = magic;
    }

    public BigDecimal getRestoreMagic() {
        return restoreMagic;
    }

    public void setRestoreMagic(BigDecimal restoreMagic) {
        this.restoreMagic = restoreMagic;
    }

    public Short getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(Short movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public Short getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(Short attackRange) {
        this.attackRange = attackRange;
    }

    public Short getAtk() {
        return atk;
    }

    public void setAtk(Short atk) {
        this.atk = atk;
    }

    public BigDecimal getAtkSpeed() {
        return atkSpeed;
    }

    public void setAtkSpeed(BigDecimal atkSpeed) {
        this.atkSpeed = atkSpeed;
    }

    public Short getArmor() {
        return armor;
    }

    public void setArmor(Short armor) {
        this.armor = armor;
    }

    public Short getSpells() {
        return spells;
    }

    public void setSpells(Short spells) {
        this.spells = spells;
    }
}