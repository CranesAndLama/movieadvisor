package movieadvisor.recommender;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class RecommenderEngine {
	private static MysqlDataSource configureDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource ();
		dataSource.setURL("jdbc:mysql://localhost:3306/movieadvisor");
		//dataSource.setServerName("localhost:3306/");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		//dataSource.setDatabaseName("movieadvisor");
		return dataSource;
	}
	public static List<RecommendedItem> makeRecommendations(Long userId) throws TasteException {
		MysqlDataSource dataSource = configureDataSource();
		JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "movie", "userId",
				"movieId", "rating", null);
				
				
		/*DataModel model;
		model = new FileDataModel(new File("C:/u.data"));*/
		//model = new MySQLJDBCDataModel();
		//CachingRecommender cachingRecommender = new CachingRecommender(new SVDRecommender(model));
		
		UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, userSimilarity, dataModel);
		Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, userSimilarity);
		Recommender cachingRecommender = new CachingRecommender(recommender);
		 //10 recommendations for 1 user
		List<RecommendedItem> recommendations = cachingRecommender.recommend(userId, 10);
		return recommendations;
	}
	/*public static void main(String[] args) throws TasteException, IOException {
		
		
		List<RecommendedItem> recommendations = makeRecommendations(1);
		for (RecommendedItem recommendedItem : recommendations) {
			System.out.println(recommendedItem);
		}
	}*/
}
