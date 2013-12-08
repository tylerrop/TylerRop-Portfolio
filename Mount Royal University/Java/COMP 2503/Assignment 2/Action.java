import gameUtil.*;
/**
 * Creates Action objects that take in appropriate information to create Action objects with different values
 * 
 * @author (Tyler Rop) 
 * @version (2)
 */
public class Action
{

    //stores the possible variations of action objects (deck to pile, deck to foundation, pile to pile, pile to foundation)
    public enum ActionType { D2P, D2F, P2P, P2F } 
    
    //the action that the user selected in the menu to interact with the game
    private ActionType move;
    
    //where the card (potentially) came from
    private int from;
    
    //where the card was sent to
    private int to;

    /**
     * Constructor for objects of class Action
     * move    - deaing a card
     * 
     * @param Action move is the menu choice that the user made
     */
    public Action(ActionType move)
    {
        this.move = move;
    }

    /**
     * Constructor for objects of class Action
     * move - dealt card to pile
     * move - dealt card to foundation
     * 
     * @param Action move is the menu choice that the user made
     * @param int pile/foundation is the destination that the user added the card to
     */
    public Action(ActionType move, int to)
    {
        this.move = move;
        this.to = to;
    }

    /**
     * Constructor for objects of class Action
     * 
     * @param int to - the pile # that the card was added to
     * @param int from - the pile the card was sent from
     */
    public Action(ActionType move, int from, int to)
    {
        this.move = move;
        this.to = to;
        this.from = from;
    }

    /**
     * getMove
     * 
     * gets the Action move and returns it
     */
    public ActionType getActionType()
    {
        return move;
    }
    
    /**
     * getFrom
     * 
     * gets the int from and returns it
     */
    public int getFrom()
    {
        return from;
    }

    /**
     * getTo
     * 
     * gets the int to and returns it
     */
    public int getTo()
    {
        return to;
    }
}
