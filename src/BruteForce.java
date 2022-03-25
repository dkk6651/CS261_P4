/**File Name: BruteForce.java
 * Author: Daniel Kee Kim
 * Description: Brute Force method of Closest pair of points.
 * Checks all possible combinations of points by iterating threw them twice.
 */

public class BruteForce extends ClosestPairAlg{

    /**
     * Closest Pair algorithm using Brute Force method
     * @param P input array of Points
     * @return Triple of two points and distance
     */
    public Triple closestPair(Point[] P){
        double lowest = Double.MAX_VALUE;
        Triple triple = null;
        for(int i = 0; i < P.length; i++){
            for(int j = i+1; j < P.length; j++){
                double dist = P[i].distance(P[j]);
                if(dist < lowest){
                    triple = new Triple(P[i], P[j], dist);
                    lowest = dist;
                }
            }
        }
        return triple;
    }
}
