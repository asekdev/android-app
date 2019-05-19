package com.example.androidapp.Objects;

public class RNG {

    private int startRange;
    private int endRange;
    private int number;

    public RNG(int start, int finish) {
        this.startRange = start;
        this.endRange = finish;
    }

    public int getStartRange() {
        return startRange;
    }

    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int generate() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * this.getEndRange() + this.getStartRange();
        int result = (int) randomDouble;

        return result;

    }
}
