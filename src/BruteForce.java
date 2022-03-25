public class BruteForce extends ClosestPairAlg{
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
