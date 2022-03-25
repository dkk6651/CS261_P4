import java.util.*;

/**File Name: DivideAndConquer.java
 * Author: Daniel Kee Kim
 * Description: Divide and Conquer method of Closest pair of points.
 * Divides the full list into half after sorting to find closest pair.
 * Recursion bottoms out at counts less than 4 and uses brute force.
 */

public class DivideAndConquer extends ClosestPairAlg{

    /**
     * Closest Pair algorithm using Divide and Conquer
     * @param P input array of Points
     * @return Triple of two points and their distance
     */
    public Triple closestPair(Point[] P) {
        int count = P.length;
        if(count <= 3){
            ClosestPairAlg a = new BruteForce();
            return a.closestPair(P);
        }

        Point[] list = new Point[count];
        for (int i = 0; i < count; i++) {
            Point point = new Pointx(P[i].x, P[i].y);
            list[i] = point;
        }
        Arrays.sort(list);

        int separation = list[count/2].x;
        Triple tripleLeft = closestPair(Arrays.copyOfRange(list, 0, count/2));
        Triple tripleRight = closestPair(Arrays.copyOfRange(list, count/2, count));

        Triple result;
        double distance;

        if(tripleLeft.dist < tripleRight.dist){
            result = tripleLeft;
            distance = tripleLeft.dist;
        }else{
            result = tripleRight;
            distance = tripleRight.dist;
        }

        ArrayList<Point> temp = new ArrayList<>();
        Collections.addAll(temp, list);
        temp.removeIf(p -> Math.abs(p.x - separation) > distance);

        Point[] yList = new Point[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            Point point = new Pointy(temp.get(i).x, temp.get(i).y);
            yList[i] = point;
        }

        Arrays.sort(yList);

        ClosestPairAlg a = new BruteForce();
        Triple yTriple = a.closestPair(yList);

        if(yTriple != null && yTriple.dist < result.dist){
            result = yTriple;
        }

        return result;
    }
}
