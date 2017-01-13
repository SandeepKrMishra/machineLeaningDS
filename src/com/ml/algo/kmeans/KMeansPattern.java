package com.ml.algo.kmeans;

import java.util.ArrayList;

class KMeans_Ex5b
{
    // If you look closely, you can see the letters made out of 1's
    private static int A1[] = {0, 0, 1, 1, 0, 0, 0, 
                               0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 1, 0, 1, 0, 0, 
                               0, 0, 1, 0, 1, 0, 0, 
                               0, 1, 1, 1, 1, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               1, 1, 1, 0, 1, 1, 1};

    private static int B1[] = {1, 1, 1, 1, 1, 1, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 1, 1, 1, 1, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               1, 1, 1, 1, 1, 1, 0};

    private static int C1[] = {0, 0, 1, 1, 1, 1, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 0, 1, 1, 1, 1, 0};

    private static int D1[] = {1, 1, 1, 1, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 1, 0, 
                               1, 1, 1, 1, 1, 0, 0};

    private static int E1[] = {1, 1, 1, 1, 1, 1, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 0, 
                               0, 1, 0, 1, 0, 0, 0, 
                               0, 1, 1, 1, 0, 0, 0, 
                               0, 1, 0, 1, 0, 0, 0, 
                               0, 1, 0, 0, 0, 0, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               1, 1, 1, 1, 1, 1, 1};

    private static int J1[] = {0, 0, 0, 1, 1, 1, 1, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 0, 1, 1, 1, 0, 0};

    private static int K1[] = {1, 1, 1, 0, 0, 1, 1, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 0, 1, 0, 0, 0, 
                               0, 1, 1, 0, 0, 0, 0, 
                               0, 1, 1, 0, 0, 0, 0, 
                               0, 1, 0, 1, 0, 0, 0, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               1, 1, 1, 0, 0, 1, 1};

    private static int A2[] = {0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 1, 0, 1, 0, 0, 
                               0, 0, 1, 0, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 1, 1, 1, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0};

    private static int B2[] = {1, 1, 1, 1, 1, 1, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 1, 1, 1, 1, 1, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 1, 1, 1, 1, 1, 0};

    private static int C2[] = {0, 0, 1, 1, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 0, 1, 1, 1, 0, 0};

    private static int D2[] = {1, 1, 1, 1, 1, 0, 0, 
                               1, 0, 0, 0, 0, 1, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 1, 0, 
                               1, 1, 1, 1, 1, 0, 0};

    private static int E2[] = {1, 1, 1, 1, 1, 1, 1, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 1, 1, 1, 1, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 1, 1, 1, 1, 1, 1};

    private static int J2[] = {0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 0, 1, 1, 1, 0, 0};

    private static int K2[] = {1, 0, 0, 0, 0, 1, 0, 
                               1, 0, 0, 0, 1, 0, 0, 
                               1, 0, 0, 1, 0, 0, 0, 
                               1, 0, 1, 0, 0, 0, 0, 
                               1, 1, 0, 0, 0, 0, 0, 
                               1, 0, 1, 0, 0, 0, 0, 
                               1, 0, 0, 1, 0, 0, 0, 
                               1, 0, 0, 0, 1, 0, 0, 
                               1, 0, 0, 0, 0, 1, 0};

    private static int A3[] = {0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 0, 1, 0, 0, 0, 
                               0, 0, 1, 0, 1, 0, 0, 
                               0, 0, 1, 0, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 1, 1, 1, 1, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 1, 0, 0, 0, 1, 1};

    private static int B3[] = {1, 1, 1, 1, 1, 1, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 1, 1, 1, 1, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               1, 1, 1, 1, 1, 1, 0};

    private static int C3[] = {0, 0, 1, 1, 1, 0, 1, 
                               0, 1, 0, 0, 0, 1, 1, 
                               1, 0, 0, 0, 0, 0, 1, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 0, 
                               1, 0, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 0, 1, 1, 1, 0, 0};

    private static int D3[] = {1, 1, 1, 1, 0, 0, 0, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 1, 0, 0, 
                               1, 1, 1, 1, 0, 0, 0};

    private static int E3[] = {1, 1, 1, 1, 1, 1, 1, 
                               0, 1, 0, 0, 0, 0, 1, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 1, 1, 1, 0, 0, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 0, 0, 0, 0, 0, 
                               0, 1, 0, 0, 0, 0, 0, 
                               0, 1, 0, 0, 0, 0, 1, 
                               1, 1, 1, 1, 1, 1, 1};

    private static int J3[] = {0, 0, 0, 0, 1, 1, 1, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 0, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 0, 1, 1, 1, 0, 0};

    private static int K3[] = {1, 1, 1, 0, 0, 1, 1, 
                               0, 1, 0, 0, 0, 1, 0, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 0, 1, 0, 0, 0, 
                               0, 1, 1, 0, 0, 0, 0, 
                               0, 1, 0, 1, 0, 0, 0, 
                               0, 1, 0, 0, 1, 0, 0, 
                               0, 1, 0, 0, 0, 1, 0, 
                               1, 1, 1, 0, 0, 1, 1};
    
    private static final String names[] = new String[]{"A", "B", "C", "D", "E", "J", "K"};
    
    private static final int NUMBER_OF_CLUSTERS = 7;           // Seven letters among the samples.
    private static final int NUM_CENTROIDS = 4;
    private static final int TEST_SAMPLES = 21;
    private static final int SAMPLE_WIDTH = 7;
    private static final int SAMPLE_HEIGHT = 9;
    private static final double BIG_NUMBER = Math.pow(10, 10); // some big number that's sure to be larger than our data range.
    
    private static ArrayList<Data> pointsFound = null;         // For collecting coordinates from samples.
    private static ArrayList<Data> dataSet = null;
    private static ArrayList<Centroid> centroids = null;
    private static ArrayList<int[]> pattern = new ArrayList<int[]>();
    
    // I want to collect the two values (x and y) of each centroid:
    private static double clusters[][] = new double[NUMBER_OF_CLUSTERS][NUM_CENTROIDS * 2];
    
    private static void train()
    {
        int clusterID = 0;
        boolean isFirstCycle = true; // No point in averaging a single number with itself.
        for(int i = 0; i < TEST_SAMPLES; i++)
        {
            initializeNewCycle();
            findCoordinates(i);
            kMeanCluster();
            int m = 0;
            for(int j = 0; j < NUM_CENTROIDS; j++)
            {
                // The x and y coordinates of each centroid are collected, then averaged with previous coordinates.
                if(!isFirstCycle){
                    // Average with previous x coordinates of this centroid.
                    clusters[clusterID][m] = (clusters[clusterID][m] + centroids.get(j).X()) / 2.0;
                }else{
                    clusters[clusterID][m] = centroids.get(j).X();
                }
                m++;
                if(!isFirstCycle){
                    // Average with previous y coordinates of this centroid.
                    clusters[clusterID][m] = (clusters[clusterID][m] + centroids.get(j).Y()) / 2.0; 
                }else{
                    clusters[clusterID][m] = centroids.get(j).Y();
                }
                m++;
            }
            clusterID++;
            // Seven letters of each font are presented in order A, B, C, D, E, J, K.
            if(clusterID >= NUMBER_OF_CLUSTERS){
                clusterID = 0;
                isFirstCycle = false;
            }
        }
        
        return;
    }
    
    private static void test()
    {
        for(int z = 0; z < TEST_SAMPLES; z++)
        {
            initializeNewCycle();
            findCoordinates(z);
            kMeanCluster();
            double predictions[] = new double[NUMBER_OF_CLUSTERS];
            for(int j = 0; j < NUMBER_OF_CLUSTERS; j++)
            {
                int k = 0;
                double totalDistance = 0.0;
                for(int i = 0; i < NUM_CENTROIDS; i++)
                {
                    totalDistance += Math.abs(centroids.get(i).X() - clusters[j][k]);
                    k++;
                    totalDistance += Math.abs(centroids.get(i).Y() - clusters[j][k]);
                    k++;
                }
                predictions[j] = totalDistance;
            }
            System.out.println("Expected: " + names[z % NUMBER_OF_CLUSTERS] + ", Actual: " + names[minimum(predictions)]);
        }
        
        return;
    }
    
    private static void initializeNewCycle()
    {
        pointsFound = new ArrayList<Data>();
        dataSet = new ArrayList<Data>();
        centroids = new ArrayList<Centroid>();
        
        centroids.add(new Centroid(1.0, 1.0)); // NW corner
        centroids.add(new Centroid(5.0, 1.0)); // NE corner
        centroids.add(new Centroid(1.0, 7.0)); // SW corner
        centroids.add(new Centroid(5.0, 7.0)); // SE corner
        return;
    }
    
    private static void findCoordinates(int patternNum)
    {
        int z = 0;
        // Find the coordinates of each "1" that makes out the letter in each sample's 7x9 grid.
        for(int y = 0; y < SAMPLE_HEIGHT; y++)
        {
            for(int x = 0; x < SAMPLE_WIDTH; x++)
            {
                if(pattern.get(patternNum)[z] > 0){
                    pointsFound.add(new Data(x, y));
                }
                z++;
            }
        }
        return;
    }
    
    private static void kMeanCluster()
    {
        double minimum = BIG_NUMBER;      // The minimum value to beat. 
        double distance = 0.0;            // The current minimum value.
        int cluster = 0;
        boolean isStillMoving = true;
        int dataCounter = 0;
        Data tempData = null;
        
        // Add in new data, one at a time, recalculating centroids with each new one. 
        while(dataSet.size() < pointsFound.size())
        {
            dataSet.add(pointsFound.get(dataCounter));
            minimum = BIG_NUMBER;
            for(int i = 0; i < NUM_CENTROIDS; i++)
            {
                distance = dist(pointsFound.get(dataCounter), centroids.get(i));
                if(distance < minimum){
                    minimum = distance;
                    cluster = i;
                }
            }
            pointsFound.get(dataCounter).cluster(cluster);
            
            // calculate new centroids.
            for(int i = 0; i < NUM_CENTROIDS; i++)
            {
                int totalX = 0;
                int totalY = 0;
                int totalInCluster = 0;
                for(int j = 0; j < dataSet.size(); j++)
                {
                    if(dataSet.get(j).cluster() == i){
                        totalX += dataSet.get(j).X();
                        totalY += dataSet.get(j).Y();
                        totalInCluster++;
                    }
                }
                if(totalInCluster > 0){
                    centroids.get(i).X(totalX / totalInCluster);
                    centroids.get(i).Y(totalY / totalInCluster);
                }
            }
            dataCounter++;
        }
        
        // Now, keep shifting centroids until equilibrium occurs.
        while(isStillMoving)
        {
            // calculate new centroids.
            for(int i = 0; i < NUM_CENTROIDS; i++)
            {
                int totalX = 0;
                int totalY = 0;
                int totalInCluster = 0;
                for(int j = 0; j < dataSet.size(); j++)
                {
                    if(dataSet.get(j).cluster() == i){
                        totalX += dataSet.get(j).X();
                        totalY += dataSet.get(j).Y();
                        totalInCluster++;
                    }
                }
                if(totalInCluster > 0){
                    centroids.get(i).X(totalX / totalInCluster);
                    centroids.get(i).Y(totalY / totalInCluster);
                }
            }
            
            // Assign all data to the new centroids
            isStillMoving = false;
            
            for(int i = 0; i < dataSet.size(); i++)
            {
                tempData = dataSet.get(i);
                minimum = BIG_NUMBER;
                for(int j = 0; j < NUM_CENTROIDS; j++)
                {
                    distance = dist(tempData, centroids.get(j));
                    if(distance < minimum){
                        minimum = distance;
                        cluster = j;
                    }
                }
                tempData.cluster(cluster);
                if(tempData.cluster() != cluster){
                    tempData.cluster(cluster);
                    isStillMoving = true;
                }
            }
        }
        return;
    }
    
    private static double dist(Data d, Centroid c)
    {
        //Calculate Euclidean distance.
        return Math.sqrt(Math.pow((c.Y() - d.Y()), 2) + Math.pow((c.X() - d.X()), 2));
    }
    
    private static int minimum(double[] anArray)
    {
        // Returns an array index.
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            for(int i = 0; i < NUMBER_OF_CLUSTERS; i++)
            {
                if(anArray[i] < anArray[winner]){
                    winner = i;
                    foundNewWinner = true;
                }
            }
            if(foundNewWinner == false){
                done = true;
            }
        }
        return winner;
    }
    
    private static class Data
    {
        private double mX = 0;
        private double mY = 0;
        private int mCluster = 0;
        
        public Data()
        {
            return;
        }
        
        public Data(double x, double y)
        {
            this.X(x);
            this.Y(y);
            return;
        }
        
        public void X(double x)
        {
            this.mX = x;
            return;
        }
        
        public double X()
        {
            return this.mX;
        }
        
        public void Y(double y)
        {
            this.mY = y;
            return;
        }
        
        public double Y()
        {
            return this.mY;
        }
        
        public void cluster(int clusterNumber)
        {
            this.mCluster = clusterNumber;
            return;
        }
        
        public int cluster()
        {
            return this.mCluster;
        }
    }
    
    private static class Centroid
    {
        private double mX = 0.0;
        private double mY = 0.0;
        
        public Centroid()
        {
            return;
        }
        
        public Centroid(double newX, double newY)
        {
            this.mX = newX;
            this.mY = newY;
            return;
        }
        
        public void X(double newX)
        {
            this.mX = newX;
            return;
        }
        
        public double X()
        {
            return this.mX;
        }
        
        public void Y(double newY)
        {
            this.mY = newY;
            return;
        }
        
        public double Y()
        {
            return this.mY;
        }
    }
    
    public static void main(String[] args)
    {
        pattern.add(A1);
        pattern.add(B1);
        pattern.add(C1);
        pattern.add(D1);
        pattern.add(E1);
        pattern.add(J1);
        pattern.add(K1);
        pattern.add(A2);
        pattern.add(B2);
        pattern.add(C2);
        pattern.add(D2);
        pattern.add(E2);
        pattern.add(J2);
        pattern.add(K2);
        pattern.add(A3);
        pattern.add(B3);
        pattern.add(C3);
        pattern.add(D3);
        pattern.add(E3);
        pattern.add(J3);
        pattern.add(K3);
        
        train();
        test();
        
        return;
    }
}

public class KMeansPattern {

}