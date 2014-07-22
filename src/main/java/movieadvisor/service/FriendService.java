package movieadvisor.service;

import movieadvisor.model.User;

public interface FriendService {

	void addFriend(User user, Long friendId);

	void removeFriend(User loginUser, Long friendId);


}
