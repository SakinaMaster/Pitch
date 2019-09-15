class Card {
    private Suit suit;
    private FaceName faceName;

    //Constructor for class Card.
    Card(Suit suit, FaceName faceName) {
        this.faceName = faceName;
        this.suit = suit;
    }

    public String toString() {
        //return this.suit.toString() + "-" + this.faceName.toString() +" " + this.faceName.faceValue;
        return this.suit.toString() + "\n" + this.faceName.toString();
    }

    public FaceName getFaceName() {
        return this.faceName;
    }

    public Suit getSuit()
    {
        return this.suit;
    }

    public int getFaceValue()
    {
        return this.faceName.faceValue;
    }

}
