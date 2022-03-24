import java.util.*;

public class DivideAndConquer extends ClosestPairAlg{
    public Triple closestPair(Point[] P) {
        int count = P.length;
        if(count <= 3){
            ClosestPairAlg a = new BruteForce();
            return a.closestPair(P);
        }

        PriorityQueue<Point> xQueue = new PriorityQueue<>();
        for(Point p : P){
            Point point = new Pointx(p.x, p.y);
            xQueue.add(point);
        }

        System.out.println(Arrays.toString(list));
        double separation = list[count/2] + list[count/2 + 1];
        Triple tripleLeft = closestPair((Point[]) Arrays.copyOfRange(xQueue.toArray(), 0, count/2));
        Triple tripleRight = closestPair((Point[]) Arrays.copyOfRange(xQueue.toArray(), count/2 + 1, count));

        double distance = Math.min(tripleLeft.dist, tripleRight.dist);

        for(Point p : P){

        }

        return null;
    }
}
