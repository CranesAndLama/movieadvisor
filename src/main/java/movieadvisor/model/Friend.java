package movieadvisor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Friend.GET_FRIEND_BY_USERID_AND_FRIENDID, 
			query="Select friend1 from Friend friend1 where (friend1.user.userId = :userId and friend1.friendId = :friendId)")
})
public class Friend {
	public static final String GET_FRIEND_BY_USERID_AND_FRIENDID = "getFriend";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private Long friendId;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (this.getClass() != other.getClass()) {
			return false;
		}
		Friend otherObject = (Friend)other;
		if ((this.getFriendId() == otherObject.getFriendId()) 
				&& (this.getUser().getUserId() == otherObject.getUser().getUserId())) {
			return true;
		}
		else {
			return false;
		}
	}
}
