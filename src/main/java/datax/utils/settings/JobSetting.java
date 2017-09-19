package datax.utils.settings;

public class JobSetting {
    private static class Speed {
        private Integer channel = 3;

        public Integer getChannel() {
            return channel;
        }

        public void setChannel(Integer channel) {
            this.channel = channel;
        }
    }

    private Speed speed = new Speed();

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
}
