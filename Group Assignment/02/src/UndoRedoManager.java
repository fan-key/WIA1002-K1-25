//Edlan Nabil - Undo/Redo with Stack
import java.util.Scanner;
import java.util.Stack;

static class UndoRedoManager{
    Stack<String> undo = new Stack<>();
    Stack<String> redo = new Stack<>();
    
    void perform(String action){
        String[] perform = action.split(":");
        if(perform.length>=2){
            String command = perform[0];
            String value = perform[1];
            System.out.println(command + ":"+value);
        }
        undo.push(action);//save in undo since redo only available after undo-ing action
        redo.clear();
    }
    String undo(){
        if(undo.isEmpty())
            return "cannot undo";
        String undoaction = undo.pop();
        redo.push(undoaction);
            return undoaction;
    }
    String redo(){
        if(redo.isEmpty())
            return "cannot redo";
        String redoaction = redo.pop();
        undo.push(redoaction);
            return redoaction;
    }
    void printStacks(){
        System.out.println("Undo: "+undo);
        System.out.println("Redo: "+redo);
    }
}