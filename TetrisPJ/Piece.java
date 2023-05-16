package TetrisPJ;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Collections;

public class Piece {
    // starting position for each pieces and create a new Point object 
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
    
    public static ArrayList<Integer> getRandomNumbers(int count, int min, int max) {
        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            availableNumbers.add(i);
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < count) {
            int randomNumber = random.nextInt(availableNumbers.size());
            int number = availableNumbers.get(randomNumber);
            uniqueNumbers.add(number);
            availableNumbers.remove(randomNumber);
        }

        ArrayList<Integer> randomList = new ArrayList<>(uniqueNumbers);
        Collections.shuffle(randomList); // เรียงลำดับแบบสุ่ม
        return randomList;
    }



    // generates a random piece
    public Active getActive () {
        ArrayList<Integer> randomList = getRandomNumbers(7, 0, 6);
        Random rand = new Random();
        int randomIndex = rand.nextInt(randomList.size()); // เลือกเลขสุ่มออกมาในช่วงตั้งแต่ 0 ถึง size-1
        int id = randomList.get(randomIndex);
        Point[] newPiece = {
            new Point(pieces[id][0].r, pieces[id][0].c), 
            new Point(pieces[id][1].r, pieces[id][1].c), 
            new Point(pieces[id][2].r, pieces[id][2].c), 
            new Point(pieces[id][3].r, pieces[id][3].c)
        };
        return new Active(newPiece, id+1);
    }

    // return a piece with a specific id
    public Active getActive (int id) {
        Point[] newPiece = {
            new Point(pieces[id][0].r, pieces[id][0].c), 
            new Point(pieces[id][1].r, pieces[id][1].c), 
            new Point(pieces[id][2].r, pieces[id][2].c), 
            new Point(pieces[id][3].r, pieces[id][3].c)
        };
        return new Active(newPiece, id+1);
    }

    //represents the active piece
    static class Active {
        Point[] pos;
        int id;
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
    private void permute(int i, int[] a) {
        if (i == 6)
            return;
        int swap = ThreadLocalRandom.current().nextInt(i, 7);
        int temp = a[i];
        a[i] = a[swap];
        a[swap] = temp;
        permute(i + 1, a);
    }

    // generates a permutation of the seven pieces and returns it
	public int[] getPermutation () {
		int[] res = new int[7];
		for (int i = 0; i < 7; i++)
			res[i] = i;
		permute(0, res);
		return res;
	}
}
