/*package movieadvisor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movieadvisor.model.Watchlist;

@Repository("watchlistRepository")
public class WatchlistRepositoryImpl implements WatchlistRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	public void addWatchlist(Watchlist watchlistMovie) {
		em.persist(watchlistMovie);
		em.flush(); 
	}

	public List<Integer> getUserWatchlist(Long userId) {
		TypedQuery<Integer> query = em.createNamedQuery(Watchlist.GET_USER_WATCHLIST, Integer.class);
		query.setParameter("userId", userId);
		List<Integer> moviesId = query.getResultList();
		return moviesId;
	}
}
*/