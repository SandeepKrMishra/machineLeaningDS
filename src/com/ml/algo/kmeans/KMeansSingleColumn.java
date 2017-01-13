package com.ml.algo.kmeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KMeansSingleColumn {
	private static int noOfClusters = 3;
	private static int dataPoints[] = { 2, 4, 10, 12, 3, 20, 30, 11, 25 };

	private static int itr = 0;
	private static int[] centroids = null;
	private static int[] newCentroids = null;
	private static Map<Integer, ArrayList<Integer>> map = null;

	public static void main(String args[]) {

		centroids = new int[noOfClusters];
		for (int k = 0; k < noOfClusters; k++) {
			centroids[k] = dataPoints[k];
		}

		boolean flag = true;
		while (flag) {
			itr++;
			clusterAssignment();
			moveCentroid();
			
			int centroidsDisDiff = 0;
			for(int i = 0; i < noOfClusters; i++) {
				if(centroids[i] == newCentroids[i]) {
					centroidsDisDiff = centroidsDisDiff + 1;
				}
			}
			
			if (centroidsDisDiff == noOfClusters) {
				flag = false;
			} else {
				centroids = newCentroids;
			}
			
			for (int k = 0; k < noOfClusters; k++) {
				System.out.println("After iteration " + itr + " , cluster " + (k + 1) + " :\n");
				ArrayList<Integer> clusterValues = map.get(k + 1);
				for (Integer value : clusterValues) {
					System.out.print(value + "\t");
				}
				System.out.println("\n");
			}
		}
	}

	private static void clusterAssignment() {
		map = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 1; i <= noOfClusters; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < dataPoints.length; i++) {
			int dataValue = dataPoints[i];
			int maxTemp = Integer.MAX_VALUE;
			int cl = 0;
			for (int j = 0; j < centroids.length; j++) {
				int centroidValue = centroids[j];
				int distance = Math.abs(dataValue - centroidValue);
				if (distance < maxTemp) {
					cl = j;
					maxTemp = distance;
				}
			}
			ArrayList<Integer> cluster = map.get(cl + 1);
			cluster.add(dataValue);
		}
	}

	private static void moveCentroid() {
		newCentroids = new int[noOfClusters];
		for (int k = 0; k < noOfClusters; k++) {
			int sum = 0;
			ArrayList<Integer> clusterValues = map.get(k + 1);
			for (Integer val : clusterValues) {
				sum = sum + val;
			}
			int newCentroid = Math.round(sum / clusterValues.size());
			newCentroids[k] = newCentroid;
		}
	}
}
