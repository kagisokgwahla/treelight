import java.util.*;
import java.io.*;

public class Treelight1{
	public static void main (String [] args) throws IOException, FileNotFoundException{
		Scanner file = null;
		
		try 
		{
			file = new Scanner(new FileInputStream("theinput.txt"));
		}
		catch (Exception e){ System.out.println("Not Found");}
		
		List<Integer> dimensions = new ArrayList<Integer>();
		String [] stringdi = file.nextLine().split("\\s+");
		for(int x=0; x < stringdi.length; x++){
			int inputD = Integer.valueOf(stringdi[x]);
			dimensions.add(inputD);
			}
		List<Float> AreaSunlight = new ArrayList<Float>();
		String [] listnum = file.nextLine().split("\\s+");
		for(int y=0; y<listnum.length;y++){
			float inputA = Float.parseFloat(listnum[y]);
			AreaSunlight.add(inputA);
			}
	    int numtree = Integer.valueOf(file.nextLine());
	    List<Float> Tree = new ArrayList<Float>();
	    
	    //Begin looping over the different tress
	    
	    while(file.hasNextLine()){
			float sum = 0;
			String [] ct = file.nextLine().split("\\s+");
			List<Integer> currenttree = new ArrayList<Integer>();
			for(int z=0; z<ct.length ; z++){
				int inputC = Integer.valueOf(ct[z]);
				currenttree.add(inputC);
				}
			int x = currenttree.get(1);
			int y = currenttree.get(0);
			int spread = currenttree.get(2);
			int startingp = x + y*(dimensions.get(0));
			
			//start calculating the trees
			//This is for the x axis
			int x_dimension = dimensions.get(1);
			int y_dimension = dimensions.get(0);
			int numx = x_dimension - x;
			int x_fact = numx - spread;
			//This is for the y axis
			int numy = y_dimension - y;
			int y_fact = numy - spread;
			
			if(y_fact>0){
				for( int k=0; k< spread; k++){
					if(x_fact>0){
					int sp = startingp+(x_dimension*k);
						
						for(int w=0; w< spread ; w++){
							sum+=AreaSunlight.get(sp+w);
							}
						}
					if(x_fact<0){
					int sp1 = startingp+(x_dimension*k);
						
						for(int w1=0; w1< numx ; w1++){
							sum+=AreaSunlight.get(sp1+w1);
							}
						}
					}
				Tree.add(sum);
				}
			if(y_fact<0){
				for( int k=0; k< numy; k++){
					if(x_fact>0){
					int sp2 = startingp+(x_dimension*k);
						
						for(int w=0; w< spread ; w++){
							sum+=AreaSunlight.get(sp2+w);
							}
						
						}
					if(x_fact<0){
					int sp1 = startingp+(x_dimension*k);
						
						for(int w1=0; w1< numx ; w1++){
							sum+=AreaSunlight.get(sp1+w1);
							}
						
						}
					}
				Tree.add(sum);
				}
				
			}
			float total=0;
			for(int e=0; e<Tree.size(); e++){
				total += Tree.get(e);
				}
			float average = total/numtree;
			System.out.println(average);
			System.out.println(numtree);
			for(int r=0; r<Tree.size(); r++){
				System.out.println(Tree.get(r));
				}
		
		
		}
	}
