// CS1020 (AY2013/4 Semester 2)
// Take-home lab #4
// Name: 
// Matric. No.: 
// Lab group: 
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Marks will be awarded for this in sit-in labs.
// Please remove this line and its preceding 3 lines.

import java.util.*;

public class CargoOptimization {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// use an array list to represent the stacks in the terminal
		ArrayList<Stack<Container>> stacks = new ArrayList<Stack<Container>>();
        String line = s.next();
        char[] lines = line.toCharArray();
        ArrayList<Character> a = new ArrayList<Character>();
        for(char b : lines){
            Container c = new Container(b);
            int best = findBestStack(c,stacks);
            if (best<0){
                Stack<Container> aa = new Stack<Container>();
                aa.push(c);
                stacks.add(aa);
                //best = (int)newArrival.getDestination();
            }
            
            else {
                stacks.get(best).push(c);
            }
            //System.out.println(b<'C');
        }
        
        System.out.println("asd"+stacks.size());
        

		// complete the program


	}

	// returns the index of the best stack to put the container
	public static int findBestStack(Container newArrival, ArrayList<Stack<Container>> stacks) {

		// complete the method
        int best = -1;
        int bestInd = -1;
        boolean done = false;
        if(stacks.isEmpty())
            return -1;
        
        else {
            for(int i=0;i<stacks.size();i++){
                int temp = newArrival.calculateFitWith(stacks.get(i));
                if (i==0){
                    best = temp;
                    bestInd = 0;
                }
                else {
                    if (temp<=best) {
                        best = temp;
                        bestInd = i;
                        done = true;
                    }
                }
                
                
            }
            
        }
        if (done)
            return bestInd;
        else return -1;

	}
}


class Container {
	private char destination;
	public Container(char destination) {
		this.destination = destination;
	}
	public char getDestination() {
		return destination;
	}

	// method should return compatibility score between this container and the target stack. 
	// they are most compatible when the container at the top of the stack has the same destination as this container
	public int calculateFitWith(Stack<Container> candidate) {

		// complete the method
        
        
        System.out.println(destination-candidate.peek().getDestination());
        return destination-candidate.peek().getDestination();
	}
}
