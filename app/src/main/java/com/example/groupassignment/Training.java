package com.example.groupassignment;

import java.util.ArrayList;

public class Training {
    private String name;
    private String comment;


    public Training(){

    }

    public Training(String name, String comment){

        this.name = name;
        this.comment = comment;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }



    public static Training getTraining(String id) {
        for(Training training : getTrainings()) {
            if(training.getName().equals(id)) {
                return training;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return name;
    }


    public static ArrayList<Training> getTrainings() {
        ArrayList<Training> trainings = new ArrayList<>();
        trainings.add(new Training("Legs", "15 reps squats, 15 reps lunges (each side), 12 reps leg presses, 12 reps hamstring curls, REPEAT 4 TIMES!"));
        trainings.add(new Training("Abs", "20 reps ab bicycles, 10 reps bird cat exercise (each side), 10 reps situps, REPEAT 4 TIMES!"));
        trainings.add(new Training("Arms", "10 reps pushups, 10 reps bicep curls (each side), 10 reps lateral raises, 12 reps lat pull-downs, REPEAT 4 TIMES!"));
        trainings.add(new Training("Chest", "10 reps dumbbell chest press, 10 reps bench press, 10 reps incline bench press, REPEAT 4 TIMES!"));
        trainings.add(new Training("Calves", "10 reps calf raises, 10 reps seated calf raise, 10 reps single-leg calf raise, REPEAT 4 TIMES!"));
        trainings.add(new Training("Shoulders", "10 reps seated shoulder press, 10 reps military press, 10 reps dumbbell lateral raise, REPEAT 4 TIMES!"));
        trainings.add(new Training("Back", "5 reps chin ups, 10 reps inverted rows, 10 reps bent over rows, REPEAT 4 TIMES!"));

        return trainings;

    }


}
