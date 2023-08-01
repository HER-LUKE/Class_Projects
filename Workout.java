/**
 *This class creates and manages the Workout ArrayList
 * @version(1.05)
 * @author Luke Herron
 */

public class Workout {
    private String exerciseName;
    private double weight;
    private int sets;
    private int reps;

    public Workout(String exerciseName, double weight, int sets, int reps) {
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    // Getters and setters 
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return exerciseName + " - Weight: " + weight + " - Sets: " + sets + " - Reps: " + reps;
    }
}
