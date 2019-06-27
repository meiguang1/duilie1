package com.hcycom.ctginms.postdomain;

public class PostDataStatistics {
    private Object sampleSize;
    private Object effectiveStrength;

    public Object getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Object sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Object getEffectiveStrength() {
        return effectiveStrength;
    }

    public void setEffectiveStrength(Object effectiveStrength) {
        this.effectiveStrength = effectiveStrength;
    }

    @Override
    public String toString() {
        return "PostDataStatistics{" +
            "sampleSize=" + sampleSize +
            ", effectiveStrength=" + effectiveStrength +
            '}';
    }
}
