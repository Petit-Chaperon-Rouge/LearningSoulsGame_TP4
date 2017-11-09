package lsg.weapons;

import lsg.consumables.repair.RepairKit;

/**
 * Created by alecoeuc on 12/10/17.
 */
public class Weapon {

    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;

    public static final String DURABILITY_STAT_STRING = "durability";

    // Constructeurs


    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability){
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }


    // Getteurs & Setteurs


    public String getName(){
        return this.name;
    }


    public int getMinDamage() {
        return this.minDamage;
    }


    public int getMaxDamage() {
        return this.maxDamage;
    }


    public int getStamCost() {
        return this.stamCost;
    }


    public int getDurability() {
        return this.durability;
    }
    private void setDurability(int durability) {
        this.durability = durability;
    }


    // Méthodes

    /**
     * Décrémente la durability de 1
     */
    public void use() {
        this.setDurability(this.getDurability()-1);
    }

    /**
     * Indique si l'arme est cassée en fonstion de durability
     * @return (boolean) true : l'arme est cassée
     */
    public boolean isBroken() {
        return durability<=0;
    }

    public void repairWith(RepairKit kit){
        this.setDurability(this.getDurability()+kit.use());
    }

    /**
     * Surcharge de toString
     * @return Les statistiques de l'arme
     */
    public String toString(){
        String dur = DURABILITY_STAT_STRING.substring(0, 3);
        return getName() + " (min:" + getMinDamage() + " max:" + getMaxDamage() + " stam:" + getStamCost() + " " + dur + ":" + getDurability() + ")";
    }

}
