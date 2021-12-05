public class PostoDeVigia {
    Robot robot1;
    Robot robot2;

    public PostoDeVigia(int cord_x1, int cord_y1, int cord_x2, int cord_y2) {
        this.robot1 = new Robot(cord_x1, cord_y1);
        this.robot2 = new Robot(cord_x2, cord_y2);
    }

    private Robot selectRobot(int robot) {
        switch(robot) {
        case 1:
            return robot1;
        case 2:
            return robot2;
        default:
            return null;
        }
    }

    public String move(int robot, int distance) {
        Robot chosen_robot = selectRobot(robot);
        if(distance <= 0) {
            return "Distancia invalida.";
        } else {
            chosen_robot.move(distance);
            return null;
        }
    }

    public String changeOrientation(int robot, String orientation) {
        Robot chosen_robot = selectRobot(robot);
        if(!orientation.matches("N|S|E|O")) {
            return "Direcao invalida.";
        } else {
            chosen_robot.changeOrientation(orientation);
            return null;
        }
    }

    public void markPI(int robot) {
        Robot chosen_robot = selectRobot(robot);
        chosen_robot.markPI();
    }

    public String getWalkedDistance(int robot) {
        Robot chosen_robot = selectRobot(robot);
        return Integer.toString(chosen_robot.getWalkedDistance());
    }

    public String currentLocation(int robot) {
        Robot chosen_robot = selectRobot(robot);
        return chosen_robot.currentLocation();
    }

    public String distanceToPI(int robot) {
        Robot chosen_robot = selectRobot(robot);
        return Integer.toString(chosen_robot.distanceToPI());
    }

    public String maxDistance() {
        if(robot1.getWalkedDistance() == robot2.getWalkedDistance()) {
            return "EMPATE";
        }
        else if(robot1.getWalkedDistance() > robot2.getWalkedDistance()) {
            return "ROBOT 1";
        }
        else {
            return "ROBOT 2";
        }
    }
}