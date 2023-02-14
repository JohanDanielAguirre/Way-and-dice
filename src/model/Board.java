package model;
public class Board {
    //Relationship
    private Box root;
    public void addBox(Box box) {
        if (root == null) {
            root = box;
            return;
        }
        addBox(root, box);
    }
    private void addBox(Box current, Box box) {
        if (current == null) return;
        if (current.getNext() == null) {
            current.setNext(box);
            return;
        }
        addBox(current.getNext(),box);
    }
    public State valueBox(int value) {
        return valueBox(value,root);
    }
    private State valueBox(int value, Box current) {
        if (current.getValue() == value) return current.getState();
        return valueBox(value,current.getNext());
    }
    public void setBoxState(int value, int state) {
        setBoxState(value, state, root);
    }
    private void setBoxState(int value, int state, Box current) {
        if (current.getValue() == value) {
            current.setState(State.values()[state]);
            return;
        }
        setBoxState(value, state, current.getNext());
    }
    //Getters and Setters
    public Box getRoot() {
        return root;
    }

}
