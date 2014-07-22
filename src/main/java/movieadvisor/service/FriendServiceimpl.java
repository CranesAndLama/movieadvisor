package movieadvisor.service;

import movieadvisor.model.Friend;
import movieadvisor.model.User;
import movieadvisor.repository.FriendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("friendService")
public class FriendServiceimpl implements FriendService{
	@Autowired
	private FriendRepository friendRepository;
	
	@Transactional
	public void addFriend(User user, Long friendId) {
		Friend friend = new Friend();
		friend.setFriendId(friendId);
		friend.setUser(user);
		
		Friend friendDb = friendRepository.getFriend(friendId, user.getUserId());
		if (friend.equals(friendDb)) {
			System.out.println("User "+ friendId + " is allready your friend");
			/*movieRepository.deleteRecentViewed(movieDb);
			movieRepository.saveRecentViewed(movie);*/
		}
		else {
			friendRepository.saveFriend(friend);
		}
		
	}
	@Transactional
	public void removeFriend(User loginUser, Long friendId) {
		Friend friendDb = friendRepository.getFriend(friendId, loginUser.getUserId());
		friendRepository.removeFriend(friendDb);
		
	}

}
