import java.util.*;

public class DivideAndConquer extends ClosestPairAlg{
    public Triple closestPair(Point[] P) {
        int count = P.length;
        if(count <= 3){
            ClosestPairAlg a = new BruteForce();
            return a.closestPair(P);
        }

        PriorityQueue<Point> xQueue = new PriorityQueue<>();
        for (Point p : P) {
            Point point = new Pointx(p.x, p.y);
            xQueue.add(point);
        }
        Point[] list = xQueue.toArray(new Point[0]);

        double separation = list[count/2].x;
        Triple tripleLeft = closestPair(Arrays.copyOfRange(xQueue.toArray(new Point[0]), 0, count/2));
        Triple tripleRight = closestPair(Arrays.copyOfRange(xQueue.toArray(new Point[0]), count/2, count));

        Triple result;
        double distance;

        if(tripleLeft.dist < tripleRight.dist){
            result = tripleLeft;
            distance = tripleLeft.dist;
        }else{
            result = tripleRight;
            distance = tripleRight.dist;
        }

        xQueue.removeIf(p -> Math.abs(separation - p.x) > distance);

        PriorityQueue<Point> yQueue = new PriorityQueue<>();
        for(Point p : xQueue){
            Point point = new Pointy(p.x, p.y);
            yQueue.add(point);
        }

        ClosestPairAlg a = new BruteForce();
        if(yQueue.toArray().length > 1){
            Triple yTriple = a.closestPair(yQueue.toArray(new Point[0]));

            if(yTriple.dist < distance){
                result = yTriple;
            }
        }

        return result;
    }
}
