public class AlarmClock {
    int snoozeInterval;

    public int getSnoozeInterval() {
        return snoozeInterval;
    }

    public void setSnoozeInterval(int snoozeInterval) {
        this.snoozeInterval = snoozeInterval;
    }

    public void snooze() {
        System.out.println("Snoozing " + snoozeInterval + " minutes");
    }
}
