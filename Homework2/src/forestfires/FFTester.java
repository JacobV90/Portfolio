package forestfires;

// NO NEED TO MODIFY THIS CLASS
// DO NOT SUBMIT THIS FILE

// But you can toy with this class to test your solution and perhaps, 
// to add new tests. The new tests nedd not to be submitted.


public class FFTester {

    // Shows that we can draw some trees
    // Shows 3 trees in a diagonal line, waits for 5 seconds
    public static void case1() {
        FFViewer view = new FFViewer();
        FFTree[] T = {
            new FFTree(200, 200),
            new FFTree(300, 300),
            new FFTree(400, 400)
        };
        view.drawTrees(T);
        view.pause(4);
        view.dispose();
    }

    // Shows trees on fire, then shows them burnt
    public static void case2() {
        FFViewer view = new FFViewer();
        // Now I create an array of trees
        FFTree[] T = new FFTree[50];
        for (int i = 0; i < 50; i++) {
            // This spreads the trees around
            T[i] = new FFTree((i * i * 97 + i * 267 + 19) % 601, (i * i * 19 + i * 267 + 111) % 517 + 50);
            // Every other tree is set on fire
            if (i % 2 == 0) {
                T[i].setFire();
            }
        }

        // I let three days go by on each tree
        for (int i = 0; i < 5; i++) {
            // I draw the trees
            view.drawTrees(T);
            view.pause(0.5);
            // I let a day pass
            for (FFTree t : T) {
                t.newDay();
            }
        }
        view.pause(1.5);
        view.dispose();
    }

    // Tests FFSimulator, which in turns uses FFTree
    public static void case3() {
        FFSimulator sim = new FFSimulator(1000, 3);
        sim.simulation();
    }

    // If you really liked case3(), try this one
    public static void case4() {
        // Dense forests. Uncomment to see 5 likely awesome fires
        for (int i = 1; i <= 5; i++) {
            (new FFSimulator(1000, i)).simulation();
        }
        // Density matters! Uncomment if you want to see 10 lame fires
        for (int i = 1; i <= 5; i++) {
            (new FFSimulator(500, i)).simulation();
        }
    }
    
    // Tests FFCustomSimulator
    public static void case5() {
        FFCustomSimulator sim;
        // slower simulation
        sim = new FFCustomSimulator(500, 3);
        sim.setFrameSpeed(0.25);
        sim.simulation();
        // faster simulation
        sim = new FFCustomSimulator(1000, 3);
        sim.setFrameSpeed(0.01);
        sim.simulation();
        // wider radius of fire spread
        sim = new FFCustomSimulator(250, 3);
        sim.setFrameSpeed(0.25);
        sim.setSpreadDistance(50);
        sim.simulation();
    }

}
