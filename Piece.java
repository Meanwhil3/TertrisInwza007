import java.util.concurrent.ThreadLocalRandom;

public abstract class Piece {
    // starting position for each pieces and create a new Point object
    // O, I, J, L, S, Z, T in order
    private static final Point[][] pieces = {
        {new Point(0, 4), new Point(0, 5), new Point(1, 4), new Point(1, 5)},
        {new Point(1, 3), new Point(1, 4), new Point(1, 5), new Point(1, 6)},
        {new Point(0, 3), new Point(1, 3), new Point(1, 4), new Point(1, 5)},
        {new Point(0, 5), new Point(1, 3), new Point(1, 4), new Point(1, 5)},
        {new Point(1, 3), new Point(1, 4), new Point(0, 4), new Point(0, 5)},
        {new Point(0, 3), new Point(0, 4), new Point(1, 4), new Point(1, 5)},
        {new Point(1, 3), new Point(1, 4), new Point(1, 5), new Point(0, 4)}
    };
    // represents a point on the grid
    static class Point {
        int r, c;
        Point (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // generates a random piece
    public abstract Active getActive();

    // return a piece with a specific id
    // Overloaded
    public abstract Active getActive(int id);

    //represents the active piece
    static class Active {
        Point[] pos;
        int id;
        // lor = top most rows / hir = bottom most rows
        // loc = left most colums / hic =  right most colums
        int lor, hir, loc, hic;
        int state = 0;
        Active (Point[] pos, int id) {
            this.pos = pos;
            this.id = id;
            if (id != 2) {
                lor = 0; hir = 2;
                loc = 3; hic = 5;
            }
            else {
                lor = 0; hir = 3;
                loc = 3; hic = 6;
            }
        }
    }

    // function to permute the pieces
    private void preview(int i, int[] a) {
        if (i == 6)
            return;
        int swap = ThreadLocalRandom.current().nextInt(i, 7);
        int temp = a[i];
        a[i] = a[swap];
        a[swap] = temp;
        preview(i + 1, a);
    }

    // generates a permutation of the seven pieces and returns it
    public int[] getPreview() {
        int[] res = new int[7];
        for (int i = 0; i < 7; i++)
            res[i] = i;
        preview(0, res);
        return res;
    }
}