package edu.sjsu.cmpe282.mahout.recommender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class UserRecommender {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("data/user-user_Result.csv"));
			DataModel model = new FileDataModel(new File("data/ratings.csv"));
			UserSimilarity userSimilarity = new LogLikelihoodSimilarity(model);
			UserNeighborhood userNeighbourhood = new NearestNUserNeighborhood(
					3, userSimilarity, model);
			Recommender recommender = new GenericUserBasedRecommender(model,
					userNeighbourhood, userSimilarity);
			Recommender cachingRecommender = new CachingRecommender(recommender);
			int count = 1;
			System.out.println("Analysis Started....");
			for (LongPrimitiveIterator prim = model.getUserIDs(); prim.hasNext();) {
				long userid = prim.nextLong();
				List<RecommendedItem> resommendationList = cachingRecommender.recommend(userid, 3);

				for (RecommendedItem recommendation : resommendationList) {
					bw.write(userid + "," + recommendation.getItemID() + ","
							+ recommendation.getValue());
					bw.newLine();
				}
				count++;
			}
			bw.flush();
			bw.close();
			System.out
					.println("Analysis Done. Check the result in data/user-user_Result.csv");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TasteException e) {
			e.printStackTrace();
		}

	}

}
