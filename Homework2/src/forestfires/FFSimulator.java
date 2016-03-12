package forestfires;

// DO NOT MODIFY THIS CLASS
// DO NOT SUBMIT THIS FILE

public class FFSimulator {

    // internal array with the trees that represent a forest
    protected FFTree[] myforest;

    /**
     * Constructor.
     *
     * @param forest_size The total number of trees in the forest.
     * @param fire_size The initial number of trees on fire.
     */
    public FFSimulator(int forest_size, int fire_size) {
        myforest = new FFTree[forest_size];
        for (int i = 0; i < forest_size; i++) {
            // This spreads the trees randomly
            myforest[i] = new FFTree(50 + (int) (Math.random() * 500), 50 + (int) (Math.random() * 500));
            // 4 trees are set on fire
            if (i < fire_size) {
                myforest[i].setFire();
            }
        }
    }

    /**
     * Size of the active fire.
     *
     * @return The number of trees that are currently on fire.
     */
    public int fireSize() {
        int n = 0;
        for (FFTree t : myforest) {
            if (t.isBurning()) {
                n++;
            }
        }
        return n;
    }

    /**
     * Get the trees that are currently on fire.
     *
     * @return An array of FFTree, which currently have isBurning()==true.
     */
    public FFTree[] getBurningTrees() {
        if (fireSize() == 0) {
            return null;
        }
        int n = fireSize();
        FFTree[] result = new FFTree[n];
        for (FFTree t : myforest) {
            if (t.isBurning()) {
                result[--n] = t;
            }
        }
        return result;
    }

    /**
     * Spreads the fire from the frees in the burningTrees array to the ones in
     * the internal array (myforest)
     *
     * @param burningTrees The trees that are spreading fire.
     */
    public void spreadFire(FFTree[] burningTrees) {
		if (burningTrees==null) return;
        for (FFTree t : myforest) {
            for (FFTree b : burningTrees) {
                if (t.distanceTo(b) < 20) {
                    t.setFire();
                }
            }
        }
    }

    /**
     * Advances one day in the forest.
     */
    public void newDay() {
        for (FFTree t : myforest) {
            t.newDay();
        }
    }

    // animation speed
    protected double wait_time = 0.1;

    /**
     * Simulates and visualizes the forest fire.
     */
    public void simulation() {
        FFViewer w = new FFViewer();
        while (this.fireSize() > 0) {
            // FIRST, we draw the forest for 0.1 seconds
            w.drawTrees(myforest);
            w.pause(wait_time / 2);
            w.drawTrees(myforest); // 2nd draw--makes the fire look alive
            w.pause(wait_time / 2);
            // SECOND: we get the trees on fire
            FFTree[] onFire = this.getBurningTrees();
            // THIRD: we advance a day
            this.newDay();
            // FOURTH: we spread the fire
            this.spreadFire(onFire);
        }
        // FINALLY: we show the final state of forest for 2 seconds
        w.drawTrees(myforest);
        w.pause(1);
        // ...and we close the window
        w.dispose();
    }

}
