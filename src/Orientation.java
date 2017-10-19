public enum Orientation {

    N,S,E,W;

    private Orientation left;
    private Orientation right;

    static {
        N.left = Orientation.W;
        N.right = Orientation.E;
        S.left = Orientation.E;
        S.right = Orientation.W;
        E.left = Orientation.N;
        E.right = Orientation.S;
        W.left = Orientation.S;
        W.right = Orientation.N;
    }

    public Orientation turnLeft() {
        return left;
    }

    public Orientation turnRight() {
        return right;
    }

}
