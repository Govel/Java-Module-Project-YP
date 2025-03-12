public class Race {

    String leader = "";
    int distance = 0;

    public void getLeader(Car car) {
        int newDistance = car.speed * 24;
        if (newDistance > distance) {
            distance = newDistance;
            leader = car.name;
        }
    }
}
