package movieadvisor.repository;

import movieadvisor.model.Friend;

public interface FriendRepository {

	Friend getFriend(Long friendId, Long userId);

	void saveFriend(Friend friend);

}
