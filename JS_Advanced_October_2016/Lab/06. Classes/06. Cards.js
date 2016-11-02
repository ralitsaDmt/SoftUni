let defineCards = (function () {

    let Suits = {
        CLUBS: "\u2663",
        DIAMONDS: "\u2666",
        HEARTS: "\u2665",
        SPADES: "\u2660"
    };
    let Faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

    function validFace(face) {
        if (!Faces.includes(face)){
            throw new Error(`Invalid card face: ${face}`);
        }
        return face;
    }

    function validSuit(suit) {
        for (let key in Suits){
            if (Suits[key] == suit){
                return suit;
            }
        }
        throw new Error(`Invalid card suit: ${suit}`);
    }

    class Card{
        constructor(face, suit){
            this._face = validFace(face);
            this._suit = validSuit(suit);
        }


        get face(){
            return this._face;
        }

        set face(face){
           this._face = validFace(face);
        }

        get suit (){
            return this._suit;
        }

        set suit(suit){
            this._suit = validSuit(suit);
        }

        toString(){
            return `${this._face}$${this._suit}`;
        }
    }

    return {Suits, Card}

})();

let Suits = defineCards.Suits;
let Card = defineCards.Card;

let card = new Card('Q', Suits.DIAMONDS);
console.log(card);

