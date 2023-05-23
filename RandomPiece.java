import java.util.concurrent.ThreadLocalRandom;

public class RandomPiece extends Piece {
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
    // generates a random piece
    public Active getActive() {
        int id = ThreadLocalRandom.current().nextInt(0, 7);
        Piece.Point[] newPiece = {
            new Piece.Point(pieces[id][0].r, pieces[id][0].c),
            new Piece.Point(pieces[id][1].r, pieces[id][1].c),
            new Piece.Point(pieces[id][2].r, pieces[id][2].c),
            new Piece.Point(pieces[id][3].r, pieces[id][3].c)
        };
        return new Active(newPiece, id + 1);
    }

    // return a piece with a specific id
    // Overloaded
    public Active getActive(int id) {
        Piece.Point[] newPiece = {
            new Piece.Point(pieces[id][0].r, pieces[id][0].c),
            new Piece.Point(pieces[id][1].r, pieces[id][1].c),
            new Piece.Point(pieces[id][2].r, pieces[id][2].c),
            new Piece.Point(pieces[id][3].r, pieces[id][3].c)
        };
        return new Active(newPiece, id + 1);
    }
}