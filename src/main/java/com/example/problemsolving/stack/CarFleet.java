package com.example.problemsolving.stack;

import java.util.*;

public class CarFleet {

    public static void main(String[] args) {
        System.out.println(carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int carFleet = 0;
        if (position.length == 1) return 1;

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            List<Integer> pair = new ArrayList<>();
            pair.add(position[i]);
            pair.add(speed[i]);
            pairs.add(pair);
        }
        Collections.sort(pairs, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> pair1, List<Integer> pair2) {
                return pair1.get(0).compareTo(pair2.get(0));
            }
        });

        ArrayList<Double> reachTargetAtTime = new ArrayList<>();
        for (List<Integer> pair : pairs) {
            reachTargetAtTime.add(reachingTarget(pair.get(0), pair.get(1), target));
        }

        int idx = reachTargetAtTime.size() - 1;
        while (idx >= 0) {
            int idxCompare = idx - 1;
            while (idxCompare >= 0 && reachTargetAtTime.get(idx) >= reachTargetAtTime.get(idxCompare)) {
                idxCompare--;
            }
            carFleet++;
            idx = idxCompare;
        }
        System.out.println(reachTargetAtTime);
        return carFleet;
    }

    public static double reachingTarget(int position, int speed, int target) {
        if (speed <= 0) return -1;
        return (double) (target - position) / (double) speed;
    }

    public static int carFleet2(int target, int[] position, int[] speed) {
        int fleets = 0;
        float[] time = new float[target];
        float maxTime = 0;
        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }

        for (int i = target - 1; i >= 0; i--) {
            if (time[i] > maxTime) {
                maxTime = time[i];
                fleets++;
            }
        }
        return fleets;
    }

    public int carFleet3(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            list.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(list, Comparator.comparingInt(arr -> arr[0]));

        for (int j = position.length - 1; j >= 0; j--) {
            double time = (double) (target - list.get(j)[0]) / list.get(j)[1];
            if (!stack.isEmpty() && stack.peek() >= time) {
                continue;
            }
            stack.push(time);
        }
        return stack.size();

    }
}
