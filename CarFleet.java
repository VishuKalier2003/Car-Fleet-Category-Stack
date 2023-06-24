/* There are n cars going to the same destination along a one-lane road. The destination is target miles away. You are given 
two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the 
speed of the ith car (in miles per hour). A car can never pass another car ahead of it, but it can catch up to it and drive 
bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these 
two cars is ignored (i.e., they are assumed to have the same position).
A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car 
fleet. If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet. Return 
the number of car fleets that will arrive at the destination.
* Eg 1 : target = 12    positions = [10,8,0,5,3]   speed = [2,4,1,1,3]     Output = 3 
* Eg 2 : target = 10    positions = [3]            speed = [3]             Output = 1 
* Eg 3 : target = 100   positions = [4,2,0]        speed = [1,2,4]         Output = 1 
*/
import java.util.*;
public class CarFleet
{
      public int TotalNumberOfCarFleets(int target, int position[], int speed[])
      {
            int num[][] = new int[position.length][2];    //* Array Creation -> O(N)
            for(int i = 0; i < position.length; i++)    //! Data Storing -> O(N)
            {
                  num[i][0] = position[i];
                  num[i][1] = speed[i];
            }
            Arrays.sort(num, (a, b) -> Integer.compare(b[0], a[0]));  //! Descending Order Sort -> O(N log N)
            Stack<Integer> stack = new Stack<Integer>();     //* Stack Declaration -> O(k)
            int fleets = 1;
            stack.push((int)((target - num[num.length - 1][0]) / num[num.length - 1][1]));
            // Last element pushed in the Stack...
            for(int i = num.length - 2; i >= 0; i--)    //! Iterating Backwards -> O(N)
            {
                  if((int)((target - num[i][0]) / num[i][1]) < stack.peek())
                  {     // If the previous car is moving faster, a Car Fleet will be formed...
                        stack.push((int)((target - num[i][0]) / num[i][1]));
                        fleets++;
                  }
            }
            return fleets;    // Returning the number of Fleets formed... 
      }
      public static void main(String args[])
      {
            // Test Case 1
            int p[] = {10, 8, 0, 5, 3};
            int s[] = {2, 4, 1, 1, 3};
            int t = 12;
            // Test Case 2
            int p1[] = {3};
            int s1[] = {3};
            int t1 = 10;
            // Test Case 3
            int p2[] = {0, 2, 4};
            int s2[] = {4, 2, 1};
            int t2 = 100;
            CarFleet carFleet = new CarFleet();      // Object Creation...
            System.out.println("Case 1 | Number of Car Fleets : "+carFleet.TotalNumberOfCarFleets(t, p, s));
            System.out.println("Case 2 | Number of Car Fleets : "+carFleet.TotalNumberOfCarFleets(t1, p1, s1));
            System.out.println("Case 3 | Number of Car Fleets : "+carFleet.TotalNumberOfCarFleets(t2, p2, s2));
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)