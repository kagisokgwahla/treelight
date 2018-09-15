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
		while(file.hasNextInt()){
			int i = file.nextInt();
			dimensions.add(i);
			}
		file.nextLine();
		List<Double> AreaSunlight = new ArrayList<Double>();
		while(file.hasNextInt()){
			double u = file.nextDouble();
			AreaSunlight.add(u);
			}
	    int numtrees = Integer.valueOf(file.nextLine());
		int [] trees = new int[numtrees];
		int counttree = 0;
		
		while(file.hasNextLine()){
			int sum = 0;
			List<Integer> currenttree = new ArrayList<Integer>();
		    while(file.hasNextInt()){
			int i = file.nextInt();
			currenttree.add(i);
			}
			int x = currenttree.get(1);
			int y = currenttree.get(0);
			int spread = currenttree.get(2);
			int startingpoint = x + y*(dimensions.get(1));
			
			int x_dimension = dimensions.get(1);
			int y_dimension = dimensions.get(0);
		    int numx = x_dimension - x;
		    int x_fact = numx - spread;
		    int numy = y_dimension - y;
		    int y_fact = numy -spread;
		    
		    if(y_fact>0){
				for(int x3=0; x3<(spread*5) ; x3+=5){
					if (x_fact>0){
						startingpoint= startingpoint + x3;
						for(int y3=0; y3<spread; y3++){
							sum+=AreaSunlight.get(startingpoint +y3);
							}
						}
					if (x_fact<0){
						startingpoint= startingpoint + x_dimension;
						for(int z=0; z<numx; z++){
							sum+=AreaSunlight.get(startingpoint +z);
							}
						}
					}
				
				}
			if(y_fact<0){
				for(int x2=0; x2<(numy*5) ; x2+=5){
					if (x_fact>0){
						startingpoint= startingpoint + x2;
						for(int y1=0; y1<spread; y1++){
							sum+=AreaSunlight.get(startingpoint +y1);
							}
						}
					if (x_fact<0){
						startingpoint= startingpoint + x_dimension;
						for(int x1=0; x1<numx; x1++){
							sum+=AreaSunlight.get(startingpoint +x1);
							}
						}
					}
			      }
			trees[counttree]=sum;
			counttree++;
			}
			int total=0;
		for(int x=0; x<trees.length; x++){
			total +=trees[x];
			}
		double average = total/numtrees;
		System.out.println(average);
		System.out.println(numtrees);
		
		for(int x= 0; x<trees.length; x++){
			System.out.println(trees[x]);
			}
		}
	}
