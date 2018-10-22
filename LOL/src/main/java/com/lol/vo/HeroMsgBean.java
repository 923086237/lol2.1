package com.lol.vo;

import java.math.BigDecimal;

/**
 * @author Barrior丶
 * @date 2018/10/22 11:21
 */
public class HeroMsgBean {

    private short id;

    private String title;

    private String name;

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

    private String image;

    private BigDecimal price;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
