/**
 * Used to represent information about a rule that needs to be applied 
 * when going to a new generation in the cellular automata. 
 * @author jkidney
 * @version Sept 14, 2012
 */
package parser;

public class Rule 
{
    public static final int LESS_THEN = -1;
    public static final int EQUALS = 0;
    public static final int GREATER_THEN = 1;

    public static final boolean ALIVE = true;
    public static final boolean EMPTY = false;

    private boolean appliesTo; // what kind of cell does this rule apply to
    // true = alive cells, false = empty cells

    private boolean action; //what happens if the rule does apply
    //true = the cell either stays alive or is born
    //false the cell is dead ( and marked as empty)

    private int numNeighbors; // the number of neighbors that is required by the rule

    private int compare;    //Indication if the rule wants more, equal or less in a 
    //count of neighbors to make the rule applicable
    // -1 = rule applies if the count of neighbors is less then the required amount
    //  0 = rule applies if the count of neighbors is equal to the required amount
    //  1 = rule applies if the count of neighbors is greater then the required amount

    public boolean getAppliesTo()
    {
      return appliesTo;
    }

    public boolean getAction() { return action; }
    public void setAppliesTo_Alive() 
    { 
        appliesTo = true; 
    }

    public void setAppliesTo_Empty() 
    { 
        appliesTo = false; 
    }

    public void setAction_Alive() 
    { 
        action = true; 
    }

    public void setAction_Dead() 
    { 
        action = false; 
    }

    public int getNumNeighbors() 
    { 
        return numNeighbors; 
    }

    public void setNumNeighbors(int numNeighbors) 
    { 
        this.numNeighbors = numNeighbors;
    }

    public int getCompare() 
    { 
        return compare; 
    }

    public void setCompare(int compare) 
    { 
        this.compare = compare; 
    }

    @Override
    public String toString() {
        return "Rule [appliesTo=" + appliesTo + ", action=" + action
        + ", numNeighbors=" + numNeighbors + ", compare=" + compare + "]";
    }

}
