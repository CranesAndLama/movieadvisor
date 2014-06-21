package movieadvisor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import movieadvisor.model.Friend;


import org.springframework.stereotype.Repository;

@Repository("friendRepository")
public class FriendRepositoryImpl implements FriendRepository{
	
	@PersistenceContext
	private EntityManager em;	
	
	public Friend getFriend(Long friendId, Long userId) {
		TypedQuery<Friend> query = em.createNamedQuery(Friend.GET_FRIEND_BY_USERID_AND_FRIENDID, Friend.class);
		query.setParameter("userId", userId);
		query.setParameter("friendId", friendId);
		List<Friend> friends = query.getResultList();
		System.out.println(friends.size());
		if (friends.size() == 0) 
			return null;
		else {
			Friend friend = friends.get(0);
			return friend;
		}
	}

	public void saveFriend(Friend friend) {
		em.persist(friend);
		em.flush();
	}
}
