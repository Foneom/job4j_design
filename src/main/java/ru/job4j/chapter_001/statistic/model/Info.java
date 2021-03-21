package ru.job4j.chapter_001.statistic.model;

public class Info {

    int added;
    int changed;
    int deleted;

    public int getAdded() {
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public void countAdd() {
        added++;
    }

    public void countChanged() {
        changed++;
    }
}
