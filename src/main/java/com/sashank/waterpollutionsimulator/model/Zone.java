package com.sashank.waterpollutionsimulator.model;


public class Zone {

    private int pollution;   // 0 – 100
    private int oxygen;      // 0 – 100
    private int life;        // 0 – 100

    public Zone() {
        this.pollution = 0;
        this.oxygen = 100;
        this.life = 100;
    }

    public void applyPollution(int amount) {
        pollution = Math.min(100, pollution + amount);
        oxygen = Math.max(0, oxygen - amount / 2);
        life = Math.max(0, life - amount / 3);
    }

    public void cleanup(int amount) {
        pollution = Math.max(0, pollution - amount);
        oxygen = Math.min(100, oxygen + amount / 2);
        life = Math.min(100, life + amount / 3);
    }

    // getters
    public int getPollution() { return pollution; }
    public int getOxygen() { return oxygen; }
    public int getLife() { return life; }
}
