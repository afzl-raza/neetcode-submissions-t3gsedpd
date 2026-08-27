static class Point{
    int x;
    int y;
    Point(int[] point){
        this.x=point[0];
        this.y=point[1];
    }
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return this.x==other.x && this.y==other.y; 

    }
    public int hashCode(){
        return Objects.hash(x,y);
    }
}
class CountSquares {
    Map<Point,Integer> points;

    public CountSquares() {
        this.points = new HashMap<>();     
    }
    
    public void add(int[] point) {
        Point p = new Point(point);
        points.put(p,points.getOrDefault(p,0)+1);
        
    }
    
    public int count(int[] point) {
        Point q = new Point(point);
        int total =0;
        for(Point p: points.keySet()){
            if(q.x==p.x){
                int dist = Math.abs(q.y-p.y);
                if(dist==0) continue;

                Point rightBottom = new Point(new int[]{q.x+dist,q.y});
                Point rightTop = new Point(new int[]{q.x+dist,p.y});
                total+=points.getOrDefault(rightBottom,0)*points.getOrDefault(rightTop,0)*points.getOrDefault(p,0);
                Point leftBottom = new Point(new int[]{q.x-dist,q.y});
                Point leftTop = new Point(new int[]{q.x-dist,p.y});
                total+=points.getOrDefault(leftBottom,0)*points.getOrDefault(leftTop,0)*points.getOrDefault(p,0);
            }
        }
        return total;
        
        
    }
}
